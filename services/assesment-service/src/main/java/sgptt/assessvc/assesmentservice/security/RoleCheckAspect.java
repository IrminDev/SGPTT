package sgptt.assessvc.assesmentservice.security;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;
import sgptt.assessvc.assesmentservice.dto.AuthDTO;

@Aspect
@Component
public class RoleCheckAspect {
    @Value("${env.data.auth.url}")
    private String authServiceUrl;

    private final RestClient.Builder restClientBuilder;
    private final HttpServletRequest request;

    @Autowired
    public RoleCheckAspect(RestClient.Builder restClientBuilder, HttpServletRequest request) {
        this.restClientBuilder = restClientBuilder;
        this.request = request;
    }

    @Before("@annotation(requiresRole)")
    public void checkRole(RequiresRole requiresRole) throws SecurityException {
        String token = request.getHeader("Authorization");

        if (token == null || token.isEmpty()) {
            throw new SecurityException("Token not found");
        }

        ResponseEntity<AuthDTO> response;

        RestClient request = restClientBuilder.baseUrl(authServiceUrl).build();

        try {
            response = request.get().uri("/api/auth/authorize/me").headers(headers -> {
                headers.add("Authorization", token);
            }).retrieve().toEntity(AuthDTO.class);
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.UNAUTHORIZED) {
                throw new SecurityException("Unauthorized: Invalid token");
            } else {
                throw new SecurityException("Error during authorization");
            }
        } catch (Exception e) {
            throw new SecurityException("Error during authorization");
        }

        if (response.getBody() == null) {
            throw new SecurityException("Invalid token");
        }

        String[] roles = requiresRole.value();

        for (String requiredRole : roles) {
            if (response.getBody().getRole().equals(requiredRole)) {
                return;
            }
        }

        throw new SecurityException("Unauthorized");
    }
}

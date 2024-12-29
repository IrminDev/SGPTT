package sgptt.adminsvc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sgptt.adminsvc.request.ActivityRequest;
import sgptt.adminsvc.request.RegisterRequest;
import sgptt.adminsvc.security.RequiresRole;
import sgptt.adminsvc.service.OpenActivityService;
import sgptt.adminsvc.service.RegisterService;

@RestController
@RequestMapping("/api/administration")
public class CATTController {

    private final RegisterService registerService;
    private final OpenActivityService openActivityService;

    @Autowired
    public CATTController(RegisterService registerService, OpenActivityService openActivityService) {
        this.registerService = registerService;
        this.openActivityService = openActivityService;
    }

    @PutMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    @RequiresRole({"Catt"})
    private void registerNewUser(@RequestBody RegisterRequest registerRequest) {
        registerService.insertNewUser(registerRequest);
    }

    @PutMapping("/openActivity")
    @ResponseStatus(HttpStatus.CREATED)
    @RequiresRole({"Catt"})
    private void openActivity(@RequestBody ActivityRequest activity) {
        openActivityService.openActivity(activity);
    }
}

package com.sgptt.protocolsservice.configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class Configuration(
	@Autowired
	@Qualifier(value = "auth-interceptor")
	private val authInterceptor: HandlerInterceptor,
	
	@Autowired
	@Qualifier(value = "upload-interceptor")
	private val uploadProtocolAuthInterceptor: HandlerInterceptor
): WebMvcConfigurer {
	override fun addInterceptors(registry: InterceptorRegistry) {
		super.addInterceptors(registry)
		registry.addInterceptor(authInterceptor)
			.addPathPatterns("/api/protocols/all", "/api/protocols/{id}")
		registry.addInterceptor(uploadProtocolAuthInterceptor)
			.addPathPatterns("/api/protocols/upload")
	}
}
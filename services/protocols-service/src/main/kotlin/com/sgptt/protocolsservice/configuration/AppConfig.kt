package com.sgptt.protocolsservice.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.EnableAspectJAutoProxy
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
@EnableAspectJAutoProxy
class AppConfig : WebMvcConfigurer {
	
	override fun addCorsMappings(registry: CorsRegistry) {
		registry.addMapping("/**")
			.allowedMethods("GET", "POST", "PUT", "DELETE")
			.allowedHeaders("*")
			.allowedOrigins("*")
	}
	
}
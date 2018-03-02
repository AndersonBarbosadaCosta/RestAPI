package com.truxton.RestAPI;


import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket appConfigDocs() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.truxton.RestAPI"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(infoDocs());
	}
	
	private ApiInfo infoDocs() {
		
	
		ApiInfo apiInfo= new ApiInfo("My REST API", "Aplicaçao REST com SpringBoot", "1.0", "terms", new Contact("Anderson", "http:truxton.com", "andersonb.costa2@gmail.com"), "Apache Licence", "API Licence URL",Collections.emptyList());
		return apiInfo;
	}

	
	
}

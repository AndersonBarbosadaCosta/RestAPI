package br.com.anderson.RestAPI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket appConfigDocs() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.anderson.RestAPI"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(infoDocs());
    }

    private ApiInfo infoDocs() {


        ApiInfo apiInfo = new ApiInfo("REST API Products", "Application REST with Spring Boot",
                "1.0", "terms",
                new Contact("Anderson Costa", null, "andersonb.costa2@gmail.com"),
                "Apache Licence", "API Licence URL", Collections.emptyList());
        return apiInfo;
    }


}

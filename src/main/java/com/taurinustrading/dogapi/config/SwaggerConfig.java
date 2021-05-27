package com.taurinustrading.dogapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;
/**********************************************************************************************************************
 * The SwaggerConfig class uses Swagger to automate the generation of machine and human readable specification for JSON
 * APIs within the Spring family of projects.
 *
 * @note  https://springfox.github.io/springfox/docs/current/#introduction
 * @note  http://localhost:8080/swagger-ui/
 *
 * @author Michael Lewis
 *********************************************************************************************************************/
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false)  // Custom messages included in the controller classes
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Dog REST API",
                "This API returns a list of dogs",
                "1.0",
                "http://www.taurinustrading.com/tos",
                new Contact("Michael Lewis", "www.taurinustrading.com", "mjolewis@gmail.com"),
                "License of API",
                "http://www.taurinustrading.com/license",
                Collections.emptyList()
        );
    }
}

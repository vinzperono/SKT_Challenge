package com.main.solution;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.main.solution.controller.EmployeeController;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * REST API Doc class
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2) 
          .select()   
          // We don't want to expose everything. We can filter with the package name
          .apis(RequestHandlerSelectors.basePackage(EmployeeController.class.getPackage().getName()))
          // We can also filter using the path
          .paths(PathSelectors.any())                         
          .build();                                          
    }
	
}

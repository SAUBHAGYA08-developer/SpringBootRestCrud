package com.restcrudapi.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Profile({"default","qa"})
public class SwaggerConfig {
	
	@Bean							
	public Docket createDocket() {
		//System.out.println("Start");
		return new Docket(DocumentationType.SWAGGER_2)//create empty UI
				.select()//select Controller
				.apis(RequestHandlerSelectors.basePackage("com.restcrudapi.controller"))//from this package
				//.paths()//having common path-/rest,PathSelectors.regex("/rest.*")
				.build()//create final docket Object
				.apiInfo(apiInfo())
				;
	}

	private ApiInfo apiInfo() {
		// TODO Auto-generated method stub
		return new ApiInfo("My App",//title
				"This is swagger UI",//description
				"1.0.5",//version
				"http://localhost:9090/swagger-ui.html#/",
				new Contact(//Contact info
						"My App",
						"http://localhost:9090/swagger-ui.html#/",
						"email.com"),
				"Myapp Licence",//company service Name
				"http://localhost:9090/swagger-ui.html#/",//company site
				Collections.emptyList());//vendor name
	}


}

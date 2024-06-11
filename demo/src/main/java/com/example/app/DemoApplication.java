package com.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication

  @OpenAPIDefinition( info= @Info(
  
  title="Spring Boot REST API Documentation", description =
  "Spring Boot REST API Documentation", version = "v1.0", contact = @Contact(
  name= "Onkar Dantakale", email="onkardantkale1007@gmail.com", url=""
  
  ), license=@License( name="Apache 2.0", url=""
  
  )
  
  
  ), externalDocs=@ExternalDocumentation( description=
  "Spring Boot Student Management Documentation", url= ""
  
  ) )
 
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

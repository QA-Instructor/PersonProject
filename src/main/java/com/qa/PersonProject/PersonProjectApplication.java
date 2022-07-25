package com.qa.PersonProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class PersonProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonProjectApplication.class, args);
	}

	@GetMapping("/hello")
	public String sayHello(){
		return "Hello on port 8081";
	}

	@GetMapping("/bye")
	public String sayBye(){
		return "Goodbye on port 8081";
	}

}

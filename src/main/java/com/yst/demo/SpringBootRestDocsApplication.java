package com.yst.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringBootRestDocsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestDocsApplication.class, args);
	}
	@RestController
	private static class HomeController {
		@GetMapping("/")
		public String home(){
			return "Hello";
		}
	}
	
	

}

package com.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//this exclude is needed to remove the default login window, which appears if you have Spring Security module in your application
//you can also define your own security settings, you don't need to have the  default one
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class JokesApplication {

	public static void main(String[] args) {
		SpringApplication.run(JokesApplication.class, args);
	}

}

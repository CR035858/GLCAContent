package com.gl.studentapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com.gl.studentapi.controller","com.gl.studentapi.model","com.gl.studentapi.repository","com.gl.studentapi.service"})
public class StudentapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentapiApplication.class, args);
		System.out.println("Welcome To Students Rest API");
	}

}

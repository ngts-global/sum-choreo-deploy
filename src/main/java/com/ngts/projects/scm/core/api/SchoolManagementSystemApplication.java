package com.ngts.projects.scm.core.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SchoolManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(SchoolManagementSystemApplication.class);
		application.run(args);
	}

}

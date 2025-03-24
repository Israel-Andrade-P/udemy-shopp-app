package com.zel92.udemy_java_course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class UdemyJavaCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(UdemyJavaCourseApplication.class, args);
	}

}

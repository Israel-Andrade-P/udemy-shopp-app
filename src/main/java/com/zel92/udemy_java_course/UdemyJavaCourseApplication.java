package com.zel92.udemy_java_course;

import com.zel92.udemy_java_course.entity.User;
import com.zel92.udemy_java_course.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class UdemyJavaCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(UdemyJavaCourseApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(UserRepository userRepository){
		return args -> {
			var u1 = User.builder()
					.name("Zel")
					.email("zel@gmail")
					.password("1234")
					.telephone("555")
					.build();
			var u2 = User.builder()
					.name("Stacey")
					.email("stace@gmail")
					.password("1212")
					.telephone("222")
					.build();
			userRepository.save(u1);
			userRepository.save(u2);
		};
	}
}

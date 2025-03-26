package com.zel92.udemy_java_course;

import com.zel92.udemy_java_course.entity.Category;
import com.zel92.udemy_java_course.entity.Order;
import com.zel92.udemy_java_course.entity.User;
import com.zel92.udemy_java_course.enumeration.OrderStatus;
import com.zel92.udemy_java_course.repository.CategoryRepository;
import com.zel92.udemy_java_course.repository.OrderRepository;
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
	public CommandLineRunner runner(UserRepository userRepository, OrderRepository orderRepository, CategoryRepository categoryRepository){
		return args -> {

			var c1 = Category.builder()
					.title("Electronics")
					.build();
			var c2 = Category.builder()
					.title("Books")
					.build();
			var c3 = Category.builder()
					.title("Computers")
					.build();	
					
			categoryRepository.save(c1);
			categoryRepository.save(c2);
			categoryRepository.save(c3);		

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
			
			var o1 = Order.builder()
					.client(u1)
					.orderStatus(OrderStatus.PAID.getStatus())
					.build();	
			var o2 = Order.builder()
					.client(u2)
					.orderStatus(OrderStatus.WAITING_PAYMENT.getStatus())
					.build();
			var o3 = Order.builder()
					.client(u1)
					.orderStatus(OrderStatus.DELIVERED.getStatus())
					.build();			

			userRepository.save(u1);
			userRepository.save(u2);

			orderRepository.save(o1);
			orderRepository.save(o2);
			orderRepository.save(o3);
		};
	}
}

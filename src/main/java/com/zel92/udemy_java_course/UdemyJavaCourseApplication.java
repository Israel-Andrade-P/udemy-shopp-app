package com.zel92.udemy_java_course;

import com.zel92.udemy_java_course.entity.Category;
import com.zel92.udemy_java_course.entity.Order;
import com.zel92.udemy_java_course.entity.OrderItem;
import com.zel92.udemy_java_course.entity.Payment;
import com.zel92.udemy_java_course.entity.Product;
import com.zel92.udemy_java_course.entity.User;
import com.zel92.udemy_java_course.enumeration.OrderStatus;
import com.zel92.udemy_java_course.repository.CategoryRepository;
import com.zel92.udemy_java_course.repository.OrderItemRepository;
import com.zel92.udemy_java_course.repository.OrderRepository;
import com.zel92.udemy_java_course.repository.ProductRepository;
import com.zel92.udemy_java_course.repository.UserRepository;

import java.math.BigDecimal;
import java.util.Arrays;

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
	public CommandLineRunner runner(UserRepository userRepository, 
									OrderRepository orderRepository, 
									CategoryRepository categoryRepository, 
									ProductRepository productRepository,
									OrderItemRepository orderItemRepository){
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
			var c4 = Category.builder()
					.title("Clothing")
					.build();		
					
			categoryRepository.save(c1);
			categoryRepository.save(c2);
			categoryRepository.save(c3);
			categoryRepository.save(c4);		

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

			var p1 = Product.builder()
						.name("Lord of The Rings")
						.description("Cool book")
						.price(BigDecimal.valueOf(29.99))				
						.build();
			var p2 = Product.builder()
						.name("Micro-wave")
						.description("Cool wave")
						.price(BigDecimal.valueOf(229.99))				
						.build();
			var p3 = Product.builder()
						.name("Shoes")
						.description("Cool shoe")
						.price(BigDecimal.valueOf(49.99))				
						.build();		
			var p4 = Product.builder()
						.name("Smart TV")
						.description("Cool tv bro")
						.price(BigDecimal.valueOf(49.99))				
						.build();
			
			p1.getCategories().add(c2);
			p2.getCategories().add(c1);
			p3.getCategories().add(c4);
			p4.getCategories().add(c1);	
			p4.getCategories().add(c3);		
			
			productRepository.save(p1);
			productRepository.save(p2);
			productRepository.save(p3);	
			productRepository.save(p4);		

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

			orderRepository.save(o1);
			orderRepository.save(o2);
			orderRepository.save(o3);

			OrderItem ot1 = new OrderItem(o1, p1, p1.getPrice(), 2);
			OrderItem ot2 = new OrderItem(o1, p3, p3.getPrice(), 1);
			OrderItem ot3 = new OrderItem(o2, p3, p3.getPrice(), 2);
			OrderItem ot4 = new OrderItem(o3, p4, p4.getPrice(), 3);

			orderItemRepository.saveAll(Arrays.asList(ot1, ot2, ot3, ot4));

			Payment pay1 = Payment.builder()
						   .order(o1)
						   .build();
			Payment pay2 = Payment.builder()
						   .order(o3)
						   .build();	
			o1.setPayment(pay1);
			o3.setPayment(pay2);			   		   
			orderRepository.save(o1);
			orderRepository.save(o3);			   
		};
	}
}

package com.zel92.udemy_java_course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zel92.udemy_java_course.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}

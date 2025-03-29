package com.zel92.udemy_java_course.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zel92.udemy_java_course.dto.ProductResponse;
import com.zel92.udemy_java_course.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
     private final ProductService service;

    @GetMapping
    public ResponseEntity<List<ProductResponse>> fetchAllOrders(){
        return ResponseEntity.ok().body(service.fetchProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> fetchById(@PathVariable ("id") Long id){
        return ResponseEntity.ok().body(service.fetchById(id));
    }
}

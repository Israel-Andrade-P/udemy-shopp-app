package com.zel92.udemy_java_course.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zel92.udemy_java_course.dto.CategoryResponse;
import com.zel92.udemy_java_course.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService service;

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> fetchAllOrders(){
        return ResponseEntity.ok().body(service.fetchCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> fetchById(@PathVariable ("id") Long id){
        return ResponseEntity.ok().body(service.fetchById(id));
    }
}

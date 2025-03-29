package com.zel92.udemy_java_course.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zel92.udemy_java_course.dto.ProductResponse;
import com.zel92.udemy_java_course.entity.Product;
import com.zel92.udemy_java_course.exception.ProductNotFoundException;
import com.zel92.udemy_java_course.mapper.ProductMapper;
import com.zel92.udemy_java_course.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper mapper;

    public List<ProductResponse> fetchProducts(){
        return productRepository.findAll().stream().map(mapper::fromProduct).toList();
    }

    public ProductResponse fetchById(Long id){
        return mapper.fromProduct(findById(id));
    }

    private Product findById(Long id){
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product with ID: " + id + " not found"));
    }
}

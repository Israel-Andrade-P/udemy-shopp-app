package com.zel92.udemy_java_course.mapper;

import org.springframework.stereotype.Service;

import com.zel92.udemy_java_course.dto.ProductResponse;
import com.zel92.udemy_java_course.entity.Product;

@Service
public class ProductMapper {

    public ProductResponse fromProduct(Product product){
        return ProductResponse.builder()
        .name(product.getName())
        .description(product.getDescription())
        .price(product.getPrice())       
        .build();
    }
}

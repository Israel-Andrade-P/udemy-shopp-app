package com.zel92.udemy_java_course.mapper;

import com.zel92.udemy_java_course.entity.OrderItem;
import org.springframework.stereotype.Service;

import com.zel92.udemy_java_course.dto.ProductResponse;
import com.zel92.udemy_java_course.entity.Product;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductMapper {
    private final CategoryMapper categoryMapper;

    public ProductResponse fromProduct(OrderItem orderItem) {
        return ProductResponse.builder()
                .name(orderItem.getProduct().getName())
                .description(orderItem.getProduct().getDescription())
                .price(orderItem.getProduct().getPrice())
                .quantity(orderItem.getQuantity())
                .categories(orderItem.getProduct().getCategories().stream().map(categoryMapper::fromCategory).toList())
                .build();
    }

    public ProductResponse fromProduct(Product product) {
        return ProductResponse.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .categories(product.getCategories().stream().map(categoryMapper::fromCategory).toList())
                .build();
    }
}

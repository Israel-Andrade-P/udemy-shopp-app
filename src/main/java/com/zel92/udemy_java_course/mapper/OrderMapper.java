package com.zel92.udemy_java_course.mapper;

import org.springframework.stereotype.Service;

import com.zel92.udemy_java_course.dto.OrderResponse;
import com.zel92.udemy_java_course.entity.Order;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderMapper {
    private final UserMapper userMapper;
    
    public OrderResponse fromOrder(Order order){
        return OrderResponse.builder()
        .createdAt(order.getCreatedAt())
        .status(order.getOrderStatus())
        .client(userMapper.fromUser(order.getClient()))
        .build();
    }
}

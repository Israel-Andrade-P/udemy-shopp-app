package com.zel92.udemy_java_course.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zel92.udemy_java_course.dto.OrderResponse;
import com.zel92.udemy_java_course.entity.Order;
import com.zel92.udemy_java_course.exception.OrderNotFoundException;
import com.zel92.udemy_java_course.mapper.OrderMapper;
import com.zel92.udemy_java_course.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper mapper;

    public List<OrderResponse> fetchOrders(){
        return orderRepository.findAll().stream().map(mapper::fromOrder).toList();
    }

    public OrderResponse fetchById(Long id){
        return mapper.fromOrder(findById(id));
    }

    private Order findById(Long id){
        return orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException("User with ID: " + id + " not found"));
    }
}

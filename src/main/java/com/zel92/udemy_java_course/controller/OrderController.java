package com.zel92.udemy_java_course.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zel92.udemy_java_course.dto.OrderResponse;
import com.zel92.udemy_java_course.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService service;

    @GetMapping
    public ResponseEntity<List<OrderResponse>> fetchAllOrders(){
        return ResponseEntity.ok().body(service.fetchOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> fetchById(@PathVariable ("id") Long id){
        return ResponseEntity.ok().body(service.fetchById(id));
    }
}

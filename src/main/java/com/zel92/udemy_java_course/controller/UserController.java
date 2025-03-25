package com.zel92.udemy_java_course.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zel92.udemy_java_course.dto.UserResponse;
import com.zel92.udemy_java_course.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping
    public ResponseEntity<List<UserResponse>> fetchAllUsers(){
        return ResponseEntity.ok().body(service.fetchUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> fetchById(@PathVariable ("id") Long id){
        return ResponseEntity.ok().body(service.fetchById(id));
    }
}

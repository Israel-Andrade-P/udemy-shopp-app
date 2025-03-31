package com.zel92.udemy_java_course.controller;

import java.net.URI;
import java.util.List;

import com.zel92.udemy_java_course.dto.UserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zel92.udemy_java_course.dto.UserResponse;
import com.zel92.udemy_java_course.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody UserRequest request){
        var user = service.addUser(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body("User has been created successfully");
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> fetchAllUsers(){
        return ResponseEntity.ok().body(service.fetchUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> fetchById(@PathVariable ("id") Long id){
        return ResponseEntity.ok().body(service.fetchById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable ("id") Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

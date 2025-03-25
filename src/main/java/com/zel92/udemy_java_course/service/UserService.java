package com.zel92.udemy_java_course.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zel92.udemy_java_course.dto.UserResponse;
import com.zel92.udemy_java_course.entity.User;
import com.zel92.udemy_java_course.exception.UserNotFoundException;
import com.zel92.udemy_java_course.mapper.UserMapper;
import com.zel92.udemy_java_course.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper mapper;

    public List<UserResponse> fetchUsers(){
        return userRepository.findAll().stream().map(mapper::fromUser).toList();
    }

    public UserResponse fetchById(Long id){
        return mapper.fromUser(findById(id));
    }

    private User findById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with ID: " + id + " not found"));
    }
}

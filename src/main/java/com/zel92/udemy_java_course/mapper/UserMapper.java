package com.zel92.udemy_java_course.mapper;

import com.zel92.udemy_java_course.dto.UserRequest;
import org.springframework.stereotype.Service;

import com.zel92.udemy_java_course.dto.UserResponse;
import com.zel92.udemy_java_course.entity.User;

@Service
public class UserMapper {
    
    public UserResponse fromUser(User user){
        return UserResponse.builder()
        .name(user.getName())
        .email(user.getEmail())
        .telephone(user.getTelephone())
        .build();
    }

    public User toUser(UserRequest request){
        return User.builder()
                .name(request.name())
                .email(request.email())
                .password(request.password())
                .telephone(request.telephone())
                .build();
    }
}

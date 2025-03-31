package com.zel92.udemy_java_course.service;

import java.util.List;

import com.zel92.udemy_java_course.dto.UserRequest;
import io.micrometer.common.util.StringUtils;
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

    public User addUser(UserRequest request){
        return userRepository.save(mapper.toUser(request));
    }

    public List<UserResponse> fetchUsers(){
        return userRepository.findAll().stream().map(mapper::fromUser).toList();
    }

    public UserResponse fetchById(Long id){
        return mapper.fromUser(findById(id));
    }

    public void delete(Long id){
        userRepository.delete(findById(id));
    }

    public void update(Long id, UserRequest newData){
        var dbUser = findById(id);

        if(!StringUtils.isBlank(newData.name())){
            dbUser.setName(newData.name());
        }
        if(!StringUtils.isBlank(newData.email())){
            dbUser.setEmail(newData.email());
        }
        if(!StringUtils.isBlank(newData.telephone())){
            dbUser.setTelephone(newData.telephone());
        }

        userRepository.save(dbUser);
    }

    private User findById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with ID: " + id + " not found"));
    }
}

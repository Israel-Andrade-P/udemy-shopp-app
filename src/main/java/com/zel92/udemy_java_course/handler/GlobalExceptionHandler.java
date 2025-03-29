package com.zel92.udemy_java_course.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.zel92.udemy_java_course.exception.CategoryNotFoundException;
import com.zel92.udemy_java_course.exception.OrderNotFoundException;
import com.zel92.udemy_java_course.exception.ProductNotFoundException;
import com.zel92.udemy_java_course.exception.UserNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handler(UserNotFoundException exp){
        return ResponseEntity.unprocessableEntity().body(exp.getMessage());
    }

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<String> handler(OrderNotFoundException exp){
        return ResponseEntity.unprocessableEntity().body(exp.getMessage());
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<String> handler(CategoryNotFoundException exp){
        return ResponseEntity.unprocessableEntity().body(exp.getMessage());
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handler(ProductNotFoundException exp){
        return ResponseEntity.unprocessableEntity().body(exp.getMessage());
    }
}

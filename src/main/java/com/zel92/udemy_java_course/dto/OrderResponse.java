package com.zel92.udemy_java_course.dto;

import java.time.LocalDateTime;

import lombok.Builder;

@Builder
public record OrderResponse(LocalDateTime createdAt, String status, UserResponse client) {
}

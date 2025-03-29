package com.zel92.udemy_java_course.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;

@Builder
public record OrderResponse(LocalDateTime createdAt, String status, UserResponse client, List<ProductResponse> items) {
}

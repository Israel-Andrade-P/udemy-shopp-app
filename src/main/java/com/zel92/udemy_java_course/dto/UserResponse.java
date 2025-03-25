package com.zel92.udemy_java_course.dto;

import lombok.Builder;

@Builder
public record UserResponse(String name, String email, String telephone) {
}

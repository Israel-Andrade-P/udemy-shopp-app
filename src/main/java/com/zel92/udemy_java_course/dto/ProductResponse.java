package com.zel92.udemy_java_course.dto;

import java.math.BigDecimal;

import lombok.Builder;

@Builder
public record ProductResponse(String name, String description, BigDecimal price) {

}

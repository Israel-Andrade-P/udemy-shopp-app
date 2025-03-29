package com.zel92.udemy_java_course.mapper;

import org.springframework.stereotype.Service;

import com.zel92.udemy_java_course.dto.CategoryResponse;
import com.zel92.udemy_java_course.entity.Category;

@Service
public class CategoryMapper {

    public CategoryResponse fromCategory(Category category){
        return CategoryResponse
        .builder()
        .title(category.getTitle())
        .build();
    }
}

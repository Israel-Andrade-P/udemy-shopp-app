package com.zel92.udemy_java_course.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zel92.udemy_java_course.dto.CategoryResponse;
import com.zel92.udemy_java_course.entity.Category;
import com.zel92.udemy_java_course.exception.CategoryNotFoundException;
import com.zel92.udemy_java_course.mapper.CategoryMapper;
import com.zel92.udemy_java_course.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper mapper;

    public List<CategoryResponse> fetchCategories(){
        return categoryRepository.findAll().stream().map(mapper::fromCategory).toList();
    }

    public CategoryResponse fetchById(Long id){
        return mapper.fromCategory(findById(id));
    }

    private Category findById(Long id){
        return categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException("Category with ID: " + id + " not found"));
    }
}


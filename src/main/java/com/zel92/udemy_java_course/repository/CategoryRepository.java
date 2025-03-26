package com.zel92.udemy_java_course.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zel92.udemy_java_course.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
    
    @Query(
        """
    SELECT c FROM Category c WHERE c.title=:title
                """
    )
    Optional<Category> findByTitle(String title);
}

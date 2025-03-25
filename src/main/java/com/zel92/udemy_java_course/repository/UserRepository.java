package com.zel92.udemy_java_course.repository;

import com.zel92.udemy_java_course.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(
            """
                    SELECT u FROM User u WHERE u.email=:email
                    """
    )
    Optional<User> findUserByEmail(String email);
}

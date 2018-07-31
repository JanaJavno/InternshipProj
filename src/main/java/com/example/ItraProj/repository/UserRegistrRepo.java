package com.example.ItraProj.repository;

import com.example.ItraProj.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRegistrRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

package com.example.JWT_Access_Refresh.repo;

import com.example.JWT_Access_Refresh.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

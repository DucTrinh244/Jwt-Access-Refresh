package com.example.JWT_Access_Refresh.repo;

import com.example.JWT_Access_Refresh.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {
    Role findByName(String name);
    }

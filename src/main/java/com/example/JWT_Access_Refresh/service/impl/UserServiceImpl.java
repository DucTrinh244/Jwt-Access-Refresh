package com.example.JWT_Access_Refresh.service.impl;

import com.example.JWT_Access_Refresh.domain.Role;
import com.example.JWT_Access_Refresh.domain.User;
import com.example.JWT_Access_Refresh.repo.RoleRepo;
import com.example.JWT_Access_Refresh.repo.UserRepo;
import com.example.JWT_Access_Refresh.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;

    @Override
    public User saveUser(User user) {
        log.info("Saving new user {} to the database", user.getUsername());
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to user {}", roleName, username);
        User user= userRepo.findByUsername(username);
        Role role= roleRepo.findByName(roleName);
        if (user == null|| role == null) {
            log.error("User or Role not found");
            return;
        }
        user.getRoles().add(role);

    }

    @Override
    public User getUser(String username) {
        log.info("Fetching user {}", username);
        return userRepo.findByUsername(username);
    }

    @Override
        public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepo.findAll();
    }
}

package com.example.JWT_Access_Refresh.service;

import com.example.JWT_Access_Refresh.domain.Role;
import com.example.JWT_Access_Refresh.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}

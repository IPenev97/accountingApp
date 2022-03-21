package com.projects.accountingApp.services;

import com.projects.accountingApp.repositories.models.Role;
import com.projects.accountingApp.repositories.models.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();


}

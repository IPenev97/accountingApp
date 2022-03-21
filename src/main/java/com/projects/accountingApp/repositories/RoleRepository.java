package com.projects.accountingApp.repositories;

import com.projects.accountingApp.repositories.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}

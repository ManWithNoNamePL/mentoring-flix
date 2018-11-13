package com.epam.mentoring.flixcore.repository;

import com.epam.mentoring.flixcore.model.Role;
import com.epam.mentoring.flixcore.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    UserRole findByRole(Role role);
}

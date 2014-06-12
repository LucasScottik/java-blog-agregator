package com.godzevych.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.godzevych.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}

package com.godzevych.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.godzevych.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}

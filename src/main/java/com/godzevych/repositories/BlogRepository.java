package com.godzevych.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.godzevych.entities.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
}

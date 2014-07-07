package com.godzevych.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.godzevych.entities.Blog;
import com.godzevych.entities.User;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
	public List<Blog> findByUser(User user);
}

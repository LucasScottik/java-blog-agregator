package com.godzevych.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.godzevych.entities.Blog;
import com.godzevych.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	public List<Item> findByBlog(Blog blog);
}

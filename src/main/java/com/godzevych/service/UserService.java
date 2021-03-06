package com.godzevych.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.godzevych.entities.Blog;
import com.godzevych.entities.Item;
import com.godzevych.entities.User;
import com.godzevych.repositories.BlogRepository;
import com.godzevych.repositories.ItemRepository;
import com.godzevych.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User getOneUser(int id) {
		return userRepository.findOne(id);
	}

	@Transactional
	public User getOneUserWithBlogs(int id) {
		User user = getOneUser(id);
		List<Blog> blogs = blogRepository.findByUser(user);
		
		for (Blog blog : blogs) {
			List<Item> items = itemRepository.findByBlog(blog, new PageRequest(0, 10, Direction.ASC, "publishedDate"));
			blog.setItems(items);
		}
		
		user.setBlogs(blogs);
		
		return user;
	}

	public void saveUser(User user) {
		userRepository.save(user);
	}
}
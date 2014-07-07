package com.godzevych.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.godzevych.entities.Blog;
import com.godzevych.entities.Item;
import com.godzevych.entities.Role;
import com.godzevych.entities.User;
import com.godzevych.repositories.BlogRepository;
import com.godzevych.repositories.ItemRepository;
import com.godzevych.repositories.RoleRepository;
import com.godzevych.repositories.UserRepository;

@Transactional
@Service
public class InitDbService {
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@PostConstruct
	public void init() {
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);
		
		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
		
		User userAdmin = new User();
		userAdmin.setName("admin");
		List<Role> rolesList = new ArrayList<Role>();
		rolesList.add(roleAdmin);
		rolesList.add(roleUser);
		userAdmin.setRoles(rolesList);
		userRepository.save(userAdmin);

		Blog javaVidsBlog = new Blog();
		javaVidsBlog.setName("javaVids");
		javaVidsBlog.setUrl("http://feeds.feedburner.com/javavids?format=xml");
		javaVidsBlog.setUser(userAdmin);
		blogRepository.save(javaVidsBlog);
		
		Item item1 = new Item();
		item1.setTitle("first");
		item1.setLink("http://www.javavids.com");
		item1.setPublishedDate(new Date());
		item1.setBlog(javaVidsBlog);
		itemRepository.save(item1);
		
		Item item2 = new Item();
		item2.setTitle("second");
		item2.setLink("http://www.javavids.com");
		item2.setPublishedDate(new Date());
		item2.setBlog(javaVidsBlog);
		itemRepository.save(item2);
	}
}

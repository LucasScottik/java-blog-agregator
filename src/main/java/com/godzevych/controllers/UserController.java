package com.godzevych.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.godzevych.entities.User;
import com.godzevych.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userSevice;
	
	@RequestMapping("/users")
	public String users(Model model) {
		model.addAttribute("users", userSevice.findAll());
		return "users";
	}
	
	@RequestMapping("/users/{id}")
	public String detail(Model model, @PathVariable int id) {
		model.addAttribute("user", userSevice.getOneUserWithBlogs(id));
		return "user-detail";
	}
	
	@RequestMapping("/register")
	public String showUserRegister() {
		return "user-register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String doUserRegister(@ModelAttribute("user") User user) {
		userSevice.saveUser(user);
		return "user-register";
	}
	
	@ModelAttribute("user")
	public User construct() {
		return new User();
	}
}

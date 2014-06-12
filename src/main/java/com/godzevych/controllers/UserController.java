package com.godzevych.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}

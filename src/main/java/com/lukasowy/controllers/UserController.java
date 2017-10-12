package com.lukasowy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lukasowy.models.User;
import com.lukasowy.services.UserService;

@RestController
@RequestMapping("/")
public class UserController {

	private UserService userService;

	@Autowired
	//better go with constructor injection
	public UserController(UserService userService) {
		this.userService = userService;
	}
	@RequestMapping("/user")
	public List<User> userList() {
		return userService.userList();
	}

}

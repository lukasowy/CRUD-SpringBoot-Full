package com.lukasowy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lukasowy.models.User;
import com.lukasowy.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	private UserService userService;

	@Autowired
	// better go with constructor injection
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/delete/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String deleteUser(@PathVariable Long id) {
		return userService.deleteUser(id);
	}

	@RequestMapping("/add")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	@RequestMapping("/list/{id}")
	public User findOne(@PathVariable Long id) {
		return userService.findOne(id);
	}

	@GetMapping("/list")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	public String userList(Model model) {
		model.addAttribute("users", userService.userList());
		return "/user/list";
	}

}

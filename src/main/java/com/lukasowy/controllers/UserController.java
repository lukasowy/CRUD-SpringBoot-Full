package com.lukasowy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

	@GetMapping("/login")
	public String login(Model model, String error, String logout) {
		if (error != null) {
			model.addAttribute("error", "Your username and password is invalid");
		}
		if (logout != null) {
			model.addAttribute("message", "You have been logged out successfully!");
		}
		return "login";
	}

	@GetMapping("/form")
	public String userForm(Model model) {
		model.addAttribute("isNew", true);
		model.addAttribute("userForm", new User());
		model.addAttribute("roles", userService.roleList());
		return "user/form";
	}

	@GetMapping("/edit/{id}")
	public String editUser(@PathVariable Long id, Model model) {
		model.addAttribute("isNew", false);
		model.addAttribute("userForm", userService.findOne(id));
		model.addAttribute("roles", userService.roleList());
		return "user/form";
	}

	@GetMapping(value="/delete/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public @ResponseBody String deleteUser(@PathVariable Long id) {
		return userService.deleteUser(id);
	}

	@PostMapping(value="/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public @ResponseBody String addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	@GetMapping("/list/{id}")
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

package com.lukasowy.services;

import java.util.List;

import com.lukasowy.models.Role;
import com.lukasowy.models.User;

public interface UserService {
	List<User> userList();

	User findOne(Long id);

	String addUser(User user);

	String deleteUser(Long id);
	
	List<Role> roleList();
}

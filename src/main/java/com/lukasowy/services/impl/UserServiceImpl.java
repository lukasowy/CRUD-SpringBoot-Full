package com.lukasowy.services.impl;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lukasowy.models.Role;
import com.lukasowy.models.User;
import com.lukasowy.repository.RoleRepository;
import com.lukasowy.repository.UserRepository;
import com.lukasowy.services.UserService;

@Service
@CacheConfig(cacheNames={"userCache"}) //instead of putting cache value everytime we can put once and we can put multiple cache names in that array
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}

	@Override
	@Cacheable
	//@Cacheable("userCache")
	public List<User> userList() {
		return userRepository.findAll();
	}

	@Override
	public User findOne(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	@CachePut(key = "#user")
	//@CachePut(value = "userCache", key = "#user")
	public String addUser(User user) {
		String message = "";
		JSONObject jsonObject = new JSONObject();
		try {
			if (user.getId() == null) {
				message = "Added";
			} else {
				message = "Updated";
			}
			user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
			user.setRole(roleRepository.findOne(user.getRoleId()));
			jsonObject.put("status", "success");
			jsonObject.put("title", message+" Confirmation");
			jsonObject.put("message", userRepository.save(user).getUserName() + " " + message + " successfully.");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}

	@Override
	@CacheEvict(allEntries=true)
	//@CacheEvict(value = "userCache", allEntries=true)
	public String deleteUser(Long id) {
		JSONObject jsonObject = new JSONObject();
		try {
			userRepository.delete(id);
			jsonObject.put("message", "User deleted successfully.");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}

	@Override
	public List<Role> roleList() {
		return roleRepository.findAll();
	}

	@Override
	@CacheEvict(allEntries=true) // replace old cache with the new
	//@CacheEvict(value = "userCache", allEntries=true) // replace old cache with the new
	public void refreshCache() {
	}

}

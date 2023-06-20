package com.dxc.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.model.User;
import com.dxc.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping
	private User createdBy(@RequestBody User user) {
		user.setUserAddedDate(new Date());
		return userRepository.save(user);
	}
	
	@PutMapping("/{userId}")
	public User updateUser(@PathVariable Long userId, @RequestBody User user) {
		User existingUser = userRepository.findById(userId).orElse(null);
		if (existingUser != null) {
			existingUser.setUserName(user.getUserName());
			existingUser.setUserPassword(user.getUserPassword());
			existingUser.setUserMobile(user.getUserMobile());
			return userRepository.save(existingUser);
		}
		return null;
	}
	
	@GetMapping("/{userId}")
	public User getUser(@PathVariable Long userId) {
		return userRepository.findByUserId(userId);		
	}
	
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable Long userId) {
		userRepository.deleteById(userId);
	}
}

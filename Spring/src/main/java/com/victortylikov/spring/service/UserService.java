package com.victortylikov.spring.service;

import java.util.List;

import com.victortylikov.spring.domain.User;

public interface UserService {
	
	List<User> findAllUsers();

	void addUser(User user);
	
	User getUserByName(String login);
}

package com.victortylikov.spring.dao;

import java.util.List;

import com.victortylikov.spring.domain.User;

public interface UserDao {

	List<User> findAllUsers();

	void addUser(User user);
	
	User getUserByName(String login);
}

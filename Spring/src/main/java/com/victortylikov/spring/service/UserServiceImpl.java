package com.victortylikov.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.victortylikov.spring.dao.UserDao;
import com.victortylikov.spring.domain.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	@Transactional
	public List<User> findAllUsers() {
		return userDao.findAllUsers();
	}

	@Override
	@Transactional
	public void addUser(User user) {
		userDao.addUser(user);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User getUserByName(String login) {
		return userDao.getUserByName(login);
	}
	

}

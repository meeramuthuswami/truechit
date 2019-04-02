package com.truechit.spring.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.truechit.spring.dao.UserDAO;
import com.truechit.spring.model.User;

@Transactional
public class UserService {
	
	@Autowired
	UserDAO userDAO; 

	public List<User> findAllUsers() {
		return userDAO.list();
	}
	
	public User findById(String id) {
		return userDAO.get(id);
	}

	public void saveUser(User user) {
		userDAO.save(user);
	}

	public void updateUser(String id, User user) {
		userDAO.update(id, user);
	}

	public void deleteUserById(String id) {
		userDAO.delete(id);
	}

	public boolean isUserExist(String id) {
		return userDAO.get(id) != null;
	}

}
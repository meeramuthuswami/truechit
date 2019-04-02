package com.truechit.spring.dao;

import java.util.List;

import com.truechit.spring.model.User;

public interface UserDAO {
	
	public String save(User user);
	
	public User get(String id);

	public List<User> list();
	
    public void update(String id, User user);
    
    public void delete(String id);
    
    public boolean addChitToUser(String userId, String chitId);
    
    public boolean submitBid(String chitId, double amount);
}
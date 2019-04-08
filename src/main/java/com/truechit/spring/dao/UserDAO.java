package com.truechit.spring.dao;

import java.util.List;

import com.truechit.spring.model.User;

public interface UserDAO {
	
	public Long save(User user);
	
	public User get(Long id);

	public List<User> list();
	
    public void update(Long id, User user);
    
    public void delete(Long id);
    
    public boolean addChitToUser(Long userId, Long chitId);

	boolean submitBid(Long userId, Long chitId, double amount);
}
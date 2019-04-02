package com.truechit.spring.dao;

import java.util.List;

import com.truechit.spring.model.Chit;
import com.truechit.spring.model.User;

public interface ChitDAO {
	
	public String save(Chit Chit);
	
	public Chit get(String id);

	public List<Chit> list();
	
    public void update(String id, Chit Chit);
    
    public void delete(String id);

    public double calculateAmountForMonth(String chitId, int cycle);
}

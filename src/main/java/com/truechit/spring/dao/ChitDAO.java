package com.truechit.spring.dao;

import java.util.List;

import com.truechit.spring.model.Chit;
import com.truechit.spring.model.User;

public interface ChitDAO {
	
	public Long save(Chit Chit);
	
	public Chit get(Long id);

	public List<Chit> list();
	
    public void update(Long id, Chit Chit);
    
    public void delete(Long id);

    public double calculateAmountForMonth(Long chitId, int cycle);
}

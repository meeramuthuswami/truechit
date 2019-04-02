package com.truechit.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.truechit.spring.dao.ChitDAO;
import com.truechit.spring.model.Chit;

public class ChitService {
	
	@Autowired
	ChitDAO chitDAO; 

	public List<Chit> findAllChits() {
		return chitDAO.list();
	}
	
	public Chit findById(String id) {
		return chitDAO.get(id);
	}

	public void saveChit(Chit user) {
		chitDAO.save(user);
	}

	public void updateChit(String id, Chit chit) {
		chitDAO.update(id, chit);
	}

	public void deleteChitById(String id) {
		chitDAO.delete(id);
	}

	public boolean isChitExist(String id) {
		return chitDAO.get(id) != null;
	}

}

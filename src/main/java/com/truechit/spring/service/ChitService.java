package com.truechit.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.truechit.spring.dao.ChitDAO;
import com.truechit.spring.model.Chit;

@Service
public class ChitService {
	
	@Autowired
	ChitDAO chitDAO; 

	public List<Chit> findAllChits() {
		return chitDAO.list();
	}
	
	public Chit findById(Long id) {
		return chitDAO.get(id);
	}

	public void saveChit(Chit user) {
		chitDAO.save(user);
	}

	public void updateChit(Long id, Chit chit) {
		chitDAO.update(id, chit);
	}

	public void deleteChitById(Long id) {
		chitDAO.delete(id);
	}

	public boolean isChitExist(Long id) {
		return chitDAO.get(id) != null;
	}

}

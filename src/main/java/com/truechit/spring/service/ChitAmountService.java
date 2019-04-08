package com.truechit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.truechit.spring.dao.ChitAmountDAO;
import com.truechit.spring.model.ChitAmount;

@Service
public class ChitAmountService {
	
	@Autowired
	ChitAmountDAO chitAmountDAO;
	

	public Long addChitAmount(ChitAmount amount)
	{
		return chitAmountDAO.addChitAmount(amount);
	}

	public void updateChitAmount(ChitAmount amount)
	{
		chitAmountDAO.updateChitAmount(amount);
	}
	
	public List<ChitAmount> getChitAmountsByChitId(String chitId)
	{
		return chitAmountDAO.getChitAmountsByChitId(chitId);
	}
	
	public List<ChitAmount> getChitAmountsByUserId(String userId)
	{
		return chitAmountDAO.getChitAmountsByUserId(userId);
	}
	
	public List<ChitAmount> getChitAmount(String userId, String chitId)
	{
		return chitAmountDAO.getChitAmount(userId, chitId);
	}
	
	public ChitAmount getChitAmount(String userId, String chitId, int cycle)
	{
		return chitAmountDAO.getChitAmount(userId, chitId, cycle);
	}
}

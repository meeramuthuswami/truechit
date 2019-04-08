package com.truechit.spring.dao;

import java.util.List;

import com.truechit.spring.model.ChitAmount;

public interface ChitAmountDAO {
	
	public Long addChitAmount(ChitAmount amount);

	public void updateChitAmount(ChitAmount amount);
	
	public List<ChitAmount> getChitAmountsByChitId(String ChitId);
	
	public List<ChitAmount> getChitAmountsByUserId(String UserId);
	
	public List<ChitAmount> getChitAmount(String userId, String chitId);
	
	public ChitAmount getChitAmount(String userId, String chitId, int cycle);
}

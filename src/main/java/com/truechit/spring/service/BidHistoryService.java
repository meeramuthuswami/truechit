package com.truechit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.truechit.spring.dao.BidHistoryDAO;
import com.truechit.spring.model.BidHistory;

@Service
public class BidHistoryService {

	@Autowired
	BidHistoryDAO bidhistorydao;
	

	public BidHistory getWinningBet(Long chitId, int cycle)
	{
		return bidhistorydao.getWinningBid(chitId, cycle);
	}
	
	
	public double getMaxBidAmount(Long chitId, int cycle)
	{
		return bidhistorydao.getMaxBidAmount(chitId, cycle);
	}
	
	public String submitBid(BidHistory bid) 
	{
		return bidhistorydao.submitBid(bid);
	}
}

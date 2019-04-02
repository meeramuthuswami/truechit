package com.truechit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.truechit.spring.dao.BidHistoryDAO;

public class BidHistoryService {

	@Autowired
	BidHistoryDAO bidhistorydao;
	

	double getWinningBet(String chitId, int cycle)
	{
		return bidhistorydao.getWinningBid(chitId, cycle);
	}
	
	
	double getMaxBidAmount(String chitId, int cycle)
	{
		return bidhistorydao.getMaxBidAmount(chitId, cycle);
	}
}

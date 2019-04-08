package com.truechit.spring.dao;

import java.util.Date;
import java.util.List;

import com.truechit.spring.model.BidHistory;
import com.truechit.spring.model.Chit;

public interface BidHistoryDAO {
	
    public BidHistory getWinningBid(Long chitId, int cycle);
    
	public String submitBid(BidHistory bid);
	
	public BidHistory get(Long id);

	public List<BidHistory> list();
	
	public double getMaxBidAmount(Long chitId, int cycle);
}

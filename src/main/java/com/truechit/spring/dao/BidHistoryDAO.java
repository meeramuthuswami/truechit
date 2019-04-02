package com.truechit.spring.dao;

import java.util.List;

import com.truechit.spring.model.BidHistory;
import com.truechit.spring.model.Chit;

public interface BidHistoryDAO {
	
    public double getWinningBid(String chitId, int cycle);
    
	public String save(BidHistory bid);
	
	public BidHistory get(String id);

	public List<BidHistory> list();
	
	public double getMaxBidAmount(String chitId, int cycle);

}

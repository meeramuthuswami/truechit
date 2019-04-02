package com.truechit.spring.model;

import java.util.Date;

public class BidHistory {

	private String id;
	private String chitId;
	private int userId;
	private boolean isWon;
	private Date bidDate;
	private double bidAmount;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getChitId() {
		return chitId;
	}
	public void setChitId(String chitId) {
		this.chitId = chitId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public boolean isWon() {
		return isWon;
	}
	public void setWon(boolean isWon) {
		this.isWon = isWon;
	}
	public Date getBidDate() {
		return bidDate;
	}
	public void setBidDate(Date bidDate) {
		this.bidDate = bidDate;
	}
	public double getBidAmount() {
		return bidAmount;
	}
	public void setBidAmount(double bidAmount) {
		this.bidAmount = bidAmount;
	}
	
}

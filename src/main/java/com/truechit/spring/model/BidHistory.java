package com.truechit.spring.model;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "BidHistory")
public class BidHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long chitId;
	private Long userId;
	private boolean isWon;
	private Date bidDate;
	private double bidAmount;
	private int chitCycle;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getChitId() {
		return chitId;
	}
	public void setChitId(Long chitId) {
		this.chitId = chitId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
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
	public int getChitCycle() {
		return chitCycle;
	}
	public void setChitCycle(int chitCycle) {
		this.chitCycle = chitCycle;
	}
	
}

package com.truechit.spring.model;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "TranscationHistory")

public class TranscationHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transactionId;
	private String chitId;
	private int userId;
	private double amountPaid;
	private Date dateOfPayment;
	private boolean isTransactionSuccess;
	
	public Long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
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
	public double getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}
	public Date getDateOfPayment() {
		return dateOfPayment;
	}
	public void setDateOfPayment(Date dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}
	public boolean isTransactionSuccess() {
		return isTransactionSuccess;
	}
	public void setTransactionSuccess(boolean isTransactionSuccess) {
		this.isTransactionSuccess = isTransactionSuccess;
	}

}

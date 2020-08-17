package com.example.bankfirstproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TransactionTable")
public class Transaction {
	
	@Id
	@GeneratedValue
	private Long id;
	private Long fromAccount;
	private Long toAccount;
	private double transactedAmount;
	public Transaction(Long fromAccount, Long toAccount, double transactedAmount) {
		super();
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.transactedAmount = transactedAmount;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(Long fromAccount) {
		this.fromAccount = fromAccount;
	}
	public Long getToAccount() {
		return toAccount;
	}
	public void setToAccount(Long toAccount) {
		this.toAccount = toAccount;
	}
	public double getTransactedAmount() {
		return transactedAmount;
	}
	public void setTransactedAmount(double transactedAmount) {
		this.transactedAmount = transactedAmount;
	}
	public Transaction() {
		
		// TODO Auto-generated constructor stub
	}
	
	
	
}

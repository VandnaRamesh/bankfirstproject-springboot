package com.example.bankfirstproject.service;

import java.util.List;

import com.example.bankfirstproject.dto.RequestDTO;
import com.example.bankfirstproject.dto.TransferDTO;
import com.example.bankfirstproject.entity.Bank;
import com.example.bankfirstproject.entity.Transaction;

public interface BankServiceRepo {
	public String addCustomer(RequestDTO requestdto);
	public String withdraw(Long id,double amt);
	public String deposit(Long id,double amt);
	public String fundtransfer(TransferDTO transferdto);
	public List<Bank> getAllCustomers(); 
	public List<Transaction> getTransactionHistory();
}

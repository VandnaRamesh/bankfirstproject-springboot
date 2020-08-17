package com.example.bankfirstproject.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bankfirstproject.dto.RequestDTO;
import com.example.bankfirstproject.dto.TransferDTO;
import com.example.bankfirstproject.entity.Bank;
import com.example.bankfirstproject.entity.Transaction;
import com.example.bankfirstproject.service.BankService;


@RestController
public class BankRestController {
	@Autowired
	public BankService bankservice;
	@PostMapping(value="/customer")
	public ResponseEntity<String> addCustomer(@RequestBody RequestDTO requestdto)
	{
		return new ResponseEntity<String>(bankservice.addCustomer(requestdto),
				HttpStatus.CREATED);
	}
	
	@PostMapping(value="/withdraw")
	public ResponseEntity<String> withdraw(@RequestParam(name="id")Long id,
			@RequestParam(name="amount")double amount)
	{
		return new ResponseEntity<String>(bankservice.withdraw(id,amount),HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value="/deposit")
	public ResponseEntity<String> deposit(@RequestParam(name="id")Long id,
			@RequestParam(name="amount")double amount)
	{
		return new ResponseEntity<String>(bankservice.deposit(id,amount),HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value="/fundtransfer")
	public ResponseEntity<String> fundtransfer(@RequestBody TransferDTO transferdto)
	{
		return new ResponseEntity<String>(bankservice.fundtransfer(transferdto),HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value="/allcustomer")
	public ResponseEntity<List<Bank>> getAllCustomers()
	{
		List<Bank> allcustomers=bankservice.getAllCustomers();
		return new ResponseEntity<List<Bank>>(allcustomers,HttpStatus.OK);
	}
	
	@GetMapping(value="/alltransaction")
	public ResponseEntity<List<Transaction>> getTransactionHistory()
	{
		List<Transaction> alltransactions=bankservice.getTransactionHistory();
		return new ResponseEntity<List<Transaction>>(alltransactions,HttpStatus.OK);
	}
	
	
}

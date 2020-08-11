package com.example.bankfirstproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bankfirstproject.dto.RequestDTO;
import com.example.bankfirstproject.dto.TransferDTO;
import com.example.bankfirstproject.entity.Bank;
import com.example.bankfirstproject.repository.BankRepository;

@Service
public class BankService implements BankServiceRepo {
	@Autowired
	public BankRepository bankrepo;

	@Override
	public String addCustomer(RequestDTO requestdto) {
		
		Bank bank=new Bank();
		bank.setAccname(requestdto.getAccname());
		bank.setAcctype(requestdto.getAcctype());
		bank.setAddress(requestdto.getAddress());
		bank.setAmount(requestdto.getAmount());
		bankrepo.save(bank);
		return "Added Customer";
	}

	@Override
	public String withdraw(Long id, double amt) {
		Optional<Bank> bank= bankrepo.findById(id);
		if(!bank.isPresent())
		{
			return "Not found";
		}
		else
		{
			double amm=bank.get().getAmount();
			amm=amm-amt;
			bank.get().setAmount(amm);
			bankrepo.save(bank.get());
			return "Amount withdraw done for "+id+" of amount "+amt;
		}
		
	}

	@Override
	public String deposit(Long id, double amt) {
		Optional<Bank> bank= bankrepo.findById(id);
		if(!bank.isPresent())
		{
			return "Not found";
		}
		else
		{
			double amm=bank.get().getAmount();
			amm=amm+amt;
			bank.get().setAmount(amm);
			bankrepo.save(bank.get());
			return "Amount deposited for "+id+" of amount "+amt;
		}
		
	}

	@Override
	public String fundtransfer(TransferDTO transferdto) {
		// TODO Auto-generated method stub
		Long id1=transferdto.getId1();
		Long id2=transferdto.getId2();
		Optional<Bank> bank1= bankrepo.findById(id1);
		Optional<Bank> bank2= bankrepo.findById(id2);
		if(!bank1.isPresent() || !bank2.isPresent())
		{
			return "Not found";
		}
		else
		{
			
			bank1.get().setAmount(bank1.get().getAmount()-transferdto.getAmount());
			bankrepo.save(bank1.get());
			bank2.get().setAmount(bank2.get().getAmount()+transferdto.getAmount());
			bankrepo.save(bank2.get());
			return "Transferred fund from "+transferdto.getId1()+" to "+transferdto.getId2();
		}
		
		
	}

	@Override
	public List<Bank> getAllCustomers() {
		return bankrepo.findAll();
	}
	
}

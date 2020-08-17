package com.example.bankfirstproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.bankfirstproject.entity.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {

}

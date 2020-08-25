package com.squadthree.fundtransfer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.squadthree.fundtransfer.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

	List<Transaction> findTop5ByFromAccountNumberOrderByTransactionDateDesc(Long accountNumber);

	

	
}

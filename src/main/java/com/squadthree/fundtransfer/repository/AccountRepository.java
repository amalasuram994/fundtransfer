package com.squadthree.fundtransfer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.squadthree.fundtransfer.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {


	public List<Account> findByCustomerId(Integer customerId);

	
	public Optional<Account> findByAccountNumber(Long fromAccountNumber);
}

package com.squadthree.fundtransfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.squadthree.fundtransfer.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

	

}

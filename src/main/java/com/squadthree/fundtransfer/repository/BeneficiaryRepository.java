package com.squadthree.fundtransfer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.squadthree.fundtransfer.entity.Beneficiary;

@Repository
public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Integer>{

	
	public List<Beneficiary> findByAccountId(Integer accountId);
}

package com.squadthree.fundtransfer.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.squadthree.fundtransfer.dto.TransactionDto;
import com.squadthree.fundtransfer.dto.TransactionResponseDto;
import com.squadthree.fundtransfer.entity.Account;
import com.squadthree.fundtransfer.entity.Beneficiary;
import com.squadthree.fundtransfer.entity.Transaction;
import com.squadthree.fundtransfer.repository.AccountRepository;
import com.squadthree.fundtransfer.repository.BeneficiaryRepository;
import com.squadthree.fundtransfer.repository.TransactionRepository;
import com.squadthree.fundtransfer.utility.UtilityService;

import junit.framework.Assert;
 

@RunWith(MockitoJUnitRunner.Silent.class)
	public class TransactionServiceImplTest {
	
	
	   
		@InjectMocks
		TransactionServiceImpl transactionServiceImpl;
	
		@Mock
		TransactionRepository transactionRepository;
	
		@Mock
		AccountRepository accountRepository;
	
		@Mock
		BeneficiaryRepository beneficiaryRepository;
	
		
		@Ignore
		@Test
		public void testTransaction() {
			
		TransactionDto transactionDto = new TransactionDto();
	    transactionDto.setFromAccountNumber((long) 1);
	    transactionDto.setDescription("Test");
	    transactionDto.setAmount(10000.0);
	    transactionDto.setToAccountNumber((long) 2);
	
	
	    Transaction transaction = new Transaction();
	    transaction.setFromAccountNumber((long) 1);
	    transaction.setAmount(10000.0);
	    transaction.setToAccountNumber((long) 2);
	    transaction.setDescription("Test");
	
	
	    Account fromAccount = new Account();
	    fromAccount.setAccountNumber((long) 88888);
	    fromAccount.setCustomerId(1);
	    fromAccount.setAvailableBalance(1000000.0);
	    fromAccount.setAccountId(1);
	    fromAccount.setAccountType("Saving");
	    
	    Account toAccount = new Account();
	    toAccount.setAccountNumber((long) 99999);
	    toAccount.setCustomerId(2);
	    toAccount.setAvailableBalance(10000.0);
	    
	    List<Beneficiary> beneficiaries = new ArrayList<>();
	    Beneficiary beneficiary = new Beneficiary();
	    beneficiary.setAccountId(1);
	    beneficiary.setBenificiaryId(1);
	    beneficiary.setBenificiaryAccountId(1);
	    beneficiaries.add(beneficiary);
	    
	    List<Transaction> transactions = new ArrayList<>();
	    Transaction transactiondet= new Transaction();
	    transactiondet.setAmount(10.0);
	    transactiondet.setDescription("test");
	    transactiondet.setFromAccountNumber((long)1);
	    transactiondet.setToAccountNumber((long)2);
	    transactiondet.setTransactionId(1);
	    transactiondet.setTransactionDate(new Date());
	    transactions.add(transactiondet);
	    
	  
	    Mockito.when(accountRepository.findByAccountNumber((long) 88888)).thenReturn(Optional.of(fromAccount));
	    
	    Mockito.when(beneficiaryRepository.findByAccountId(1)).thenReturn(beneficiaries);
	    
	    Mockito.when(accountRepository.save(toAccount)).thenReturn(toAccount);
	    Mockito.when(transactionRepository.findByFromAccountNumber(Mockito.anyLong())).thenReturn(transactions);
	    Mockito.when(transactionRepository.save(transaction)).thenReturn(transaction);
	    
	   // Mockito.when(accountRepository.findById(2)).thenReturn(Optional.of(account2));
	    TransactionResponseDto transactionResponse = transactionServiceImpl.transaction(transactionDto);
	    Assert.assertNotNull(transactionResponse);
	}

}
 
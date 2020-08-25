package com.squadthree.fundtransfer.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Optional;

import com.squadthree.fundtransfer.dto.AccountDetailDto;
import com.squadthree.fundtransfer.entity.Account;
import com.squadthree.fundtransfer.entity.Customer;
import com.squadthree.fundtransfer.entity.Transaction;
import com.squadthree.fundtransfer.exception.CustomerNotFoundException;
import com.squadthree.fundtransfer.repository.AccountRepository;
import com.squadthree.fundtransfer.repository.CustomerRepository;
import com.squadthree.fundtransfer.repository.TransactionRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class AccountServiceImplTest {
	@InjectMocks
	AccountServiceImpl accountServiceImpl;
	
	@Mock
	CustomerRepository customerRepository;

	@Mock
	AccountRepository accountRepository;

	@Mock
	TransactionRepository transactionRepository;
	Customer customer = new Customer();
	Account account = new Account();
	List<Transaction> transactionList = new ArrayList<>();
	@Before
	public void init() {
		customer.setCustomerId(1);
		customer.setCustomerName("amala");
		customer.setLastName("suram");
		
		account.setAccountId(1);
		account.setAccountNumber(new Long(99999));
		account.setCustomerId(1);
		
		Transaction transaction = new Transaction();
		transaction.setFromAccountNumber(new Long(99999));
		transaction.setAmount(10000.0);
		transaction.setToAccountNumber(new Long(99999));
		transaction.setDescription("Test");
		transactionList.add(transaction);
	}
	
	@Test
	public void testfindAccountSummary(){
	
		Mockito.when(accountRepository.findById(1)).thenReturn(Optional.of(account));
		Mockito.when(transactionRepository
				.findTop5ByFromAccountNumberOrderByTransactionDateDesc(new Long(99999))).thenReturn(transactionList);
		AccountDetailDto accountDetailDto = accountServiceImpl.getAccountDetail(1);
		
		Assert.assertNotNull(accountDetailDto);
		
		
	}
	@Test
	public void testgetAccountDetail(){
		
		Mockito.when(accountRepository.findById(1)).thenReturn(Optional.of(account));
		Mockito.when(transactionRepository
				.findTop5ByFromAccountNumberOrderByTransactionDateDesc(new Long(99999))).thenReturn(transactionList);
		AccountDetailDto accountDetailDto = accountServiceImpl.getAccountDetail(1);
		
		Assert.assertNotNull(accountDetailDto);
		
		
	}
	
	@Test(expected = CustomerNotFoundException.class)
	public void testfindAccountSummaryCustomerNotEx() throws CustomerNotFoundException{
		Mockito.when(accountRepository.findById(3)).thenReturn(Optional.ofNullable(null));
		accountServiceImpl.findAccountSummary(1);
		
	}
	
}


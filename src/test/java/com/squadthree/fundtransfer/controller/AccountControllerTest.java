package com.squadthree.fundtransfer.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.squadthree.fundtransfer.dto.AccountDetailDto;
import com.squadthree.fundtransfer.dto.AccountSummaryDto;
import com.squadthree.fundtransfer.dto.AccountSummaryResponseDto;
import com.squadthree.fundtransfer.entity.Customer;
import com.squadthree.fundtransfer.exception.CustomerNotFoundException;
import com.squadthree.fundtransfer.service.AccountService;
@RunWith(MockitoJUnitRunner.Silent.class)
public class AccountControllerTest {
	@InjectMocks
	AccountController accountController;
	
	@Mock
	AccountService accountService;
	
	AccountSummaryResponseDto accountSummaryResponseDto=new AccountSummaryResponseDto();
	
	List<AccountSummaryDto> accountSummaryList=new ArrayList<AccountSummaryDto>();
	AccountSummaryDto accountSummaryDto=new AccountSummaryDto();
	
	Customer customer=new Customer();
	
	
	
	@Before
	public void init() {
		customer.setCustomerId(1);
		accountSummaryDto.setAccountNumber(99999L);
		accountSummaryDto.setAccountType("saving");
		accountSummaryDto.setAvailableBalance(1000.00);
		
		
		accountSummaryList.add(accountSummaryDto);
	}
	@Test
	public void testgetAccountSummary() throws CustomerNotFoundException{

		Mockito.when(accountService.findAccountSummary(1)).thenReturn(accountSummaryResponseDto);
		ResponseEntity<AccountSummaryResponseDto> accountSummary = accountController.getAccountSummary(1);
	
		assertEquals(200, accountSummary.getBody().getStatusCode());
		
	}
	
	
	@Test
	public void testgetAccountDetail(){
		
		
		AccountDetailDto accountDetailDto = new AccountDetailDto();
		accountDetailDto.setAccountNumber(new Long(878987667));
		accountDetailDto.setAvailableBalance(new Double(100000));
		Mockito.when(accountService.getAccountDetail(1)).thenReturn(accountDetailDto);
		ResponseEntity<AccountDetailDto> accountDetail = accountController.getAccountDetail(1);
		
		assertEquals(200, accountDetail.getBody().getStatusCode());
	}
	
}

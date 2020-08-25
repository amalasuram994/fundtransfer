package com.squadthree.fundtransfer.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.squadthree.fundtransfer.dto.TransactionDto;
import com.squadthree.fundtransfer.dto.TransactionResponseDto;
import com.squadthree.fundtransfer.service.TransactionServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class TransactionControllerTest {
	@InjectMocks
	TransactionController transactionController;

	@Mock
	TransactionServiceImpl transactionServiceImpl;

	
	@Test
	public void testTransaction() {
		TransactionDto transactionDto = new TransactionDto();
		transactionDto.setFromAccountNumber((long)1);
		transactionDto.setAmount(100.0);
		transactionDto.setToAccountNumber((long)2);

		TransactionResponseDto respomseDto = new TransactionResponseDto();
		respomseDto.setResponseMessage("Transaction Success");
		respomseDto.setStatusCode(200);
		Mockito.when(transactionServiceImpl.transaction(transactionDto)).thenReturn(respomseDto);
		
		ResponseEntity<TransactionResponseDto> transactionResponse = transactionController.transaction(transactionDto);
		Assert.assertNotNull(transactionResponse);
	}
}

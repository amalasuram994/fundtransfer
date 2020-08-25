package com.squadthree.fundtransfer.service;

import com.squadthree.fundtransfer.dto.TransactionResponseDto;
import com.squadthree.fundtransfer.dto.TransactionDto;

public interface TransactionService {

	
	TransactionResponseDto transaction(TransactionDto transactionDto);
}

package com.squadthree.fundtransfer.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.squadthree.fundtransfer.dto.TransactionResponseDto;
import com.squadthree.fundtransfer.dto.TransactionDto;
import com.squadthree.fundtransfer.service.TransactionService;
/**
 * 
 * 
 * @author shraddha
 *
 */
@RestController
@RequestMapping("/transactions")
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	
	private static Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	/**
	 * This method is for doing fund transfer.
	 * @param transactionDto
	 * @return responseDto
	 *
	 */
	@PostMapping("")
	public ResponseEntity<TransactionResponseDto> transaction( @RequestBody TransactionDto transactionDto) {
		
		TransactionResponseDto transactionResponseDto = transactionService.transaction(transactionDto);
		logger.info("transaction controller");
		return new ResponseEntity<>(transactionResponseDto, HttpStatus.OK);
	}
}

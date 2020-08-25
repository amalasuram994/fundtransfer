package com.squadthree.fundtransfer.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.squadthree.fundtransfer.constant.AppConstant;
import com.squadthree.fundtransfer.dto.AccountDetailDto;
import com.squadthree.fundtransfer.dto.AccountSummaryResponseDto;
import com.squadthree.fundtransfer.exception.CustomerNotFoundException;
import com.squadthree.fundtransfer.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	
private static Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	AccountService accountService;
	
	/**
	 * @apiNote is used fetching the account summary
	 * @param customerId
	 * @return AccountSummaryResponseDto
	 * @throws CustomerNotFoundException 
	 */

	@GetMapping("/summary/{customerId}")	
	public ResponseEntity<AccountSummaryResponseDto> getAccountSummary(@PathVariable Integer customerId) throws CustomerNotFoundException{
		
		  AccountSummaryResponseDto accountSummaryResponseDto = accountService.findAccountSummary(customerId);
		 
		 accountSummaryResponseDto.setMessage(AppConstant.SUCCESS_STATUS_MESSAGE);
		 accountSummaryResponseDto.setStatusCode(AppConstant.SUCCESS_STATUS_CODE);
		 logger.info(AppConstant.ACCOUNT_SUMMARY_DISPLAY_SUCCESS);
		 return ResponseEntity.ok().body(accountSummaryResponseDto);
	}
	/**
	 * @apiNote This api is used to getAccountDetail
	 * @param accountId
	 * @return AccountDetailDto
	 */
	
	@GetMapping("/details/{accountId}")
	public ResponseEntity<AccountDetailDto> getAccountDetail(@PathVariable Integer accountId){
		
		AccountDetailDto accountDetailDto = accountService.getAccountDetail(accountId);
		accountDetailDto.setResponseMessage(AppConstant.ACCOUNT_DETAILS_DISPLAY_SUCCESS);
		accountDetailDto.setStatusCode(AppConstant.SUCCESS_STATUS_CODE);
		
		
		logger.info(AppConstant
				.ACCOUNT_DETAILS_DISPLAY_SUCCESS);
		return ResponseEntity.ok().body(accountDetailDto);
	}
	

}

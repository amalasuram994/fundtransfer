package com.squadthree.fundtransfer.service;

import java.util.List;

import com.squadthree.fundtransfer.dto.AccountDetailDto;
import com.squadthree.fundtransfer.dto.AccountSummaryDto;
import com.squadthree.fundtransfer.dto.AccountSummaryResponseDto;
import com.squadthree.fundtransfer.exception.CustomerNotFoundException;

public interface AccountService {

	AccountSummaryResponseDto findAccountSummary(Integer customerId) throws CustomerNotFoundException;

	public AccountDetailDto getAccountDetail(Integer accountId);

	
}

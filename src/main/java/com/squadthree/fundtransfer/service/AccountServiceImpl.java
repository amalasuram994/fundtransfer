package com.squadthree.fundtransfer.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squadthree.fundtransfer.constant.AppConstant;
import com.squadthree.fundtransfer.controller.AccountController;
import com.squadthree.fundtransfer.dto.AccountDetailDto;
import com.squadthree.fundtransfer.dto.AccountSummaryDto;
import com.squadthree.fundtransfer.dto.AccountSummaryResponseDto;
import com.squadthree.fundtransfer.entity.Account;
import com.squadthree.fundtransfer.entity.Customer;
import com.squadthree.fundtransfer.entity.Transaction;
import com.squadthree.fundtransfer.exception.AccountNotFoundException;
import com.squadthree.fundtransfer.exception.CustomerNotFoundException;
import com.squadthree.fundtransfer.repository.AccountRepository;
import com.squadthree.fundtransfer.repository.CustomerRepository;
import com.squadthree.fundtransfer.repository.TransactionRepository;

@Service
public class AccountServiceImpl implements AccountService {
	private static Logger logger = LoggerFactory.getLogger(AccountController.class);

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	TransactionRepository transactionRepository;

	/**
	 * This findAccountSummary() is used to get account summary
	 */
	@Override
	public AccountSummaryResponseDto findAccountSummary(Integer customerId) throws CustomerNotFoundException {
		Optional<Customer> customer = customerRepository.findById(customerId);
		AccountSummaryResponseDto accountSummaryResponseDto = new AccountSummaryResponseDto();

		if (customer.isPresent()) {
			accountSummaryResponseDto.setAccountHolderName(customer.get().getCustomerName());
			List<Account> accountList = accountRepository.findByCustomerId(customerId);

			List<AccountSummaryDto> accountSummaryDtoList = accountList.stream().map(a -> convertToDto(a))
					.collect(Collectors.toList());
			accountSummaryResponseDto.setAccountSummaryList(accountSummaryDtoList);
			if (accountSummaryDtoList.isEmpty()) {

				logger.info(AppConstant.ACCOUNT_NOT_FOUND_MESSAGE);
				throw new AccountNotFoundException(AppConstant.ACCOUNT_NOT_FOUND_MESSAGE);

			}

		} else {
			logger.info(AppConstant.CUSTOMER_NOT_FOUND_MESSAGE);
			throw new CustomerNotFoundException(AppConstant.CUSTOMER_NOT_FOUND);
		}

		return accountSummaryResponseDto;
	}

	private AccountSummaryDto convertToDto(Account account) {
		AccountSummaryDto accountDto = new AccountSummaryDto();
		BeanUtils.copyProperties(account, accountDto);
		return accountDto;
	}

	/**
	 * getAccountDetail() is used to get accountDetails
	 */
	@Override
	public AccountDetailDto getAccountDetail(Integer accountId) {
		AccountDetailDto accountDetailDto = new AccountDetailDto();
		Optional<Account> account = accountRepository.findById(accountId);
		if (account.isPresent()) {
			Account accountDetails = account.get();

			BeanUtils.copyProperties(accountDetails, accountDetailDto);
			List<Transaction> transactionList = transactionRepository
					.findTop5ByFromAccountNumberOrderByTransactionDateDesc(account.get().getAccountNumber());

			accountDetailDto.setTransactionDtoList(transactionList);

			return accountDetailDto;
		} else {

			logger.info(AppConstant.ACCOUNT_NOT_FOUND_MESSAGE);
			throw new AccountNotFoundException(AppConstant.ACCOUNT_NOT_FOUND_MESSAGE);
		}
	}

}

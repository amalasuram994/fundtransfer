package com.squadthree.fundtransfer.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.squadthree.fundtransfer.constant.AppConstant;
import com.squadthree.fundtransfer.controller.AccountController;
import com.squadthree.fundtransfer.dto.TransactionResponseDto;
import com.squadthree.fundtransfer.dto.TransactionDto;
import com.squadthree.fundtransfer.entity.Account;
import com.squadthree.fundtransfer.entity.Beneficiary;
import com.squadthree.fundtransfer.entity.Transaction;
import com.squadthree.fundtransfer.exception.AccountNotFoundException;
import com.squadthree.fundtransfer.exception.BeneficiaryNotFoundException;
import com.squadthree.fundtransfer.exception.InsufficientBalanceException;
import com.squadthree.fundtransfer.exception.InvalidTransactionException;
import com.squadthree.fundtransfer.exception.MaximumLimitTransaction;
import com.squadthree.fundtransfer.exception.MinimumBalanceException;
import com.squadthree.fundtransfer.repository.AccountRepository;
import com.squadthree.fundtransfer.repository.BeneficiaryRepository;
import com.squadthree.fundtransfer.repository.TransactionRepository;
import com.squadthree.fundtransfer.utility.UtilityService;


@Service
public class TransactionServiceImpl implements TransactionService {

	private static Logger logger = LoggerFactory.getLogger(AccountController.class);


	@Autowired
	AccountRepository accountRepository;

	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	BeneficiaryRepository beneficiaryRepository;

	@Transactional
	@Override
	public TransactionResponseDto transaction(TransactionDto transactionDto) {
		
		logger.info(AppConstant.IN_TRANSACTION_SERVICEIMPL);
		Double totalBalance;
		Double destinationAccountBalance;
		Account accountData ;
		Beneficiary isBeneficiaryPresent = null;
		Transaction transaction = new Transaction();
		
		Optional<Account> account = accountRepository.findByAccountNumber(transactionDto.getFromAccountNumber());
		Optional<Account> destinationAccountoptional = accountRepository
				.findByAccountNumber(transactionDto.getToAccountNumber());
		
		
		if (account.isPresent()) {
			accountData = account.get();
			if (destinationAccountoptional.isPresent()) {
				
				
				
					List<Beneficiary> beneficiaries = beneficiaryRepository.findByAccountId(accountData.getAccountId());
					
					isBeneficiaryPresent = beneficiaries.stream().filter(beneficiary -> (destinationAccountoptional.get()
							.getAccountId() == beneficiary.getBenificiaryAccountId()))
					.findAny().orElse(null);
					
					if(!ObjectUtils.isEmpty(isBeneficiaryPresent)){
					
						if (transactionDto.getAmount() >= accountData.getAvailableBalance()) {
							
							throw new InsufficientBalanceException(AppConstant.INSUFFICIENT_BALANCE);
							
						} else if (accountData.getAvailableBalance() <= AppConstant.MINIMUM_BALANCE_AMOUNT) {
							
							throw new MinimumBalanceException(AppConstant.MINIMUM_BALANCE);
						}
						totalBalance = accountData.getAvailableBalance() - transactionDto.getAmount();
						accountData.setAvailableBalance(totalBalance);
						accountRepository.save(accountData);
					
					}else{
						
						throw new BeneficiaryNotFoundException(accountData.getAccountId());
					}
				
			}
			
		} else {
			throw new AccountNotFoundException(AppConstant.ACCOUNT_NOT_FOUND_MESSAGE);
		}

		List<Transaction> transactions = transactionRepository
				.findByFromAccountNumber(transactionDto.getFromAccountNumber());
		List<Double> transactionAmounts = new ArrayList();
		transactions.forEach(e -> {
			transactionAmounts.add(e.getAmount());
		});
		
		Optional<Double> totalTransactionDone = transactionAmounts.stream().reduce((a, b) -> a + b);

		if (totalTransactionDone.isPresent()) {
			if (totalTransactionDone.get() >= AppConstant.MAX_TRANSACTION_LIMIT) {
				throw new MaximumLimitTransaction(AppConstant.LIMIT_CROSSED);
			}
		}
		transaction.setTransactionType("Credited");
		transaction.setTransactionDate(new Date(System.currentTimeMillis()));
		BeanUtils.copyProperties(transactionDto, transaction);
		
		
		transactionRepository.save(transaction);

		if (destinationAccountoptional.isPresent()) {
			Account destinationAccount = destinationAccountoptional.get();
			destinationAccountBalance = destinationAccount.getAvailableBalance() + transactionDto.getAmount();
			destinationAccount.setAvailableBalance(destinationAccountBalance);
			accountRepository.save(destinationAccount);
		}
		Transaction destinationTransaction = new Transaction();
		destinationTransaction.setTransactionType("Debited");
		destinationTransaction.setFromAccountNumber(transactionDto.getToAccountNumber());
		destinationTransaction.setToAccountNumber(transactionDto.getFromAccountNumber());
		destinationTransaction.setTransactionDate(new Date(System.currentTimeMillis()));
		destinationTransaction.setDescription(transactionDto.getDescription());
		destinationTransaction.setAmount(transactionDto.getAmount());
		//BeanUtils.copyProperties(transactionDto, destinationTransaction);
		transactionRepository.save(destinationTransaction);

		return UtilityService.responseDto(AppConstant.ACCOUNT_DEBITED);

	}

}

package com.squadthree.fundtransfer.dto;
import java.util.Date;
import java.util.List;

import com.squadthree.fundtransfer.entity.Transaction;
public class AccountDetailDto {
	private String responseMessage;
	private int statusCode;
	private Long accountNumber;
	private Double availableBalance;
	private Date accountCreationDate;
	private List<Transaction> transactionDtoList;
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Double getAvailableBalance() {
		return availableBalance;
	}
	public void setAvailableBalance(Double availableBalance) {
		this.availableBalance = availableBalance;
	}
	public Date getAccountCreationDate() {
		return accountCreationDate;
	}
	public void setAccountCreationDate(Date accountCreationDate) {
		this.accountCreationDate = accountCreationDate;
	}
	public List<Transaction> getTransactionDtoList() {
		return transactionDtoList;
	}
	public void setTransactionDtoList(List<Transaction> transactionDtoList) {
		this.transactionDtoList = transactionDtoList;
	}
	
	
	
	
}

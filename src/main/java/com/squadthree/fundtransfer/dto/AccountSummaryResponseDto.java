package com.squadthree.fundtransfer.dto;

import java.util.List;

public class AccountSummaryResponseDto {
	private Integer statusCode;
	private String message;
	private String accountHolderName;
	private List<AccountSummaryDto> accountSummaryList;
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public List<AccountSummaryDto> getAccountSummaryList() {
		return accountSummaryList;
	}
	public void setAccountSummaryList(List<AccountSummaryDto> accountSummaryList) {
		this.accountSummaryList = accountSummaryList;
	}
	
	
}

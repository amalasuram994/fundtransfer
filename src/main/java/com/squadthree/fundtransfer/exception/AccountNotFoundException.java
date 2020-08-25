package com.squadthree.fundtransfer.exception;

public class AccountNotFoundException extends RuntimeException {

	public AccountNotFoundException() {
		super("Account is not exist ");
	}
}

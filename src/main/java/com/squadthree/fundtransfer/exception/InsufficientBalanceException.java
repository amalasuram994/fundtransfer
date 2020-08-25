package com.squadthree.fundtransfer.exception;

public class InsufficientBalanceException extends RuntimeException {

	public InsufficientBalanceException(String message) {
		super(String.format(message));
	}
}


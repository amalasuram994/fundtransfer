package com.squadthree.fundtransfer.exception;

public class MinimumBalanceException extends RuntimeException {

	public MinimumBalanceException(String message) {
		super(String.format( message));
	}
}
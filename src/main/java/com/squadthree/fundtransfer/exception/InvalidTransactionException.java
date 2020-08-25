package com.squadthree.fundtransfer.exception;

public class InvalidTransactionException extends RuntimeException {

	public InvalidTransactionException(String message ) {
		super(String.format( message));
	}
}

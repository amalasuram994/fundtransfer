package com.squadthree.fundtransfer.exception;

public class CustomerNotFoundException extends Exception {
	public CustomerNotFoundException(Integer customerId) {
		super(String.format("User with Id %d not found", customerId));
	}
}

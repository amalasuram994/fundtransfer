package com.squadthree.fundtransfer.exception;

public class MaximumLimitTransaction extends RuntimeException{
	
	public MaximumLimitTransaction(String message) {
		super(String.format(message));
	}

}

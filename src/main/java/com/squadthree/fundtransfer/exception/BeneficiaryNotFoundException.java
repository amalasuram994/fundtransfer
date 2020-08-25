package com.squadthree.fundtransfer.exception;

public class BeneficiaryNotFoundException extends RuntimeException {

	public BeneficiaryNotFoundException(Integer beneficiaryId) {
		super(String.format("beneficiary with Id %d not found", beneficiaryId));
	}
}

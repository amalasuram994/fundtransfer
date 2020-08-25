package com.squadthree.fundtransfer.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Beneficiary {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer benificiaryId;
	private Integer accountId;
	private Integer benificiaryAccountId;

	public Integer getBenificiaryId() {
		return benificiaryId;
	}

	public void setBenificiaryId(Integer benificiaryId) {
		this.benificiaryId = benificiaryId;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Integer getBenificiaryAccountId() {
		return benificiaryAccountId;
	}

	public void setBenificiaryAccountId(Integer benificiaryAccountId) {
		this.benificiaryAccountId = benificiaryAccountId;
	}

	@Override
	public String toString() {
		return "Beneficiary [benificiaryId=" + benificiaryId + ", accountId=" + accountId + ", benificiaryAccountId="
				+ benificiaryAccountId + ", getBenificiaryId()=" + getBenificiaryId() + ", getAccountId()="
				+ getAccountId() + ", getBenificiaryAccountId()=" + getBenificiaryAccountId() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	

}

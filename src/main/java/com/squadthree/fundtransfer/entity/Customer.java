package com.squadthree.fundtransfer.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	@NotNull
	private String customerName;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private Long phoneNumber;
	

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", getCustomerId()=" + getCustomerId() + ", getCustomerName()=" + getCustomerName()
				+ ", getPassword()=" + getPassword() + ", getFirstName()=" + getFirstName() + ", getLastName()="
				+ getLastName() + ", getEmail()=" + getEmail() + ", getPhoneNumber()=" + getPhoneNumber()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}


	
}

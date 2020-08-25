package com.squadthree.fundtransfer.constant;

public class AppConstant {
	
	
	 private AppConstant() {
		    throw new IllegalStateException("AppConstant class");
		  }

	public static final String SUCCESS_STATUS_MESSAGE = "Success";

	public static final String STATUS_CODE = "statusCode";

	public static final String STATUS_MESSAGE = "statusMessage";

	public static final Integer STATUS_CODE_VALUE = 400;

	public static final String EMPLTY_DATA_MESSAGE = "Data is empty";

	public static final String SOMETHINGWRONG_MESSAGE = "Something went wrong while processing the request";

	public static final String USER_NOT_FOUND_MESSAGE = "User not found";

	public static final String GENERAL_EXCEPTION = "Exception occured";

	public static final String USER_NOT_REGISTER = "User is not register in database";

	public static final String CAUSE = "Cause";

	public static final String ERROR_MESSSAGE = "Error Message";

	public static final Integer SUCCESS_STATUS_CODE = 200;
	
	public static final Integer INSUFFICIENT_BALANCE_STATUS_CODE = 400;

	public static final String INSUFFICIENT_BALANCE = "Insufficient Balance in your account";

	public static final String ACCOUNT_DEBITED = "Your Account Debited Successfully";

	public static final String IN_TRANSACTION_SERVICEIMPL = "You are in Transaction ServiceImpl";

	public static final String ACCOUNT_NUMBER_NOT_FOUND = "From Account Number not found";

	public static final Double MAX_TRANSACTION_LIMIT = 50000.0;

	public static final String LIMIT_CROSSED = "Transaction cannot be processed.You have crossed the maximum limit.";

	public static final Double MINIMUM_BALANCE_AMOUNT = 10000.0;

	public static final String MINIMUM_BALANCE = "Transaction cannot be processed.You have only minimum balance in your account.";

	public static final String CUSTOMER_NOT_FOUND_MESSAGE = "This customer is not ";

	public static final String ACCOUNT_NOT_FOUND_MESSAGE = "Account is not exist for this customerId";

	public static final String ACCOUNT_SUMMARY_DISPLAY_SUCCESS = "Account summary displayed Successfully";

	public static final String CUSTOMER_NOT_FOUND = "Customer Not Found";
	
	public static final String CUSTOMER_LOGGIN_SUCCESS = "Customer loggin successfully";

	public static final String CUSTOMER_LOGGIN_FAIL = "Customer loggin fail";
	
	public static final String ACCOUNT_DETAILS_DISPLAY_SUCCESS = "Account details is display successfully ";
	
	public static final String BENEFICIARY_NOT_FOUND = "Beneficiary not found";
	
	public static final String REGEX_PATTERN = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})";
	
	public static final String NOT_MATCHED = "Password did not fulfill the criteria";
	
	public static final String WRONG = "Password is Wrong";
	
	public static final String INVALID_TRANSACTION = "Source and destination account should not be same";

}

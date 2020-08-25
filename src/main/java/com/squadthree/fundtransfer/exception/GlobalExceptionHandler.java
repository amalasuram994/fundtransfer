package com.squadthree.fundtransfer.exception;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.squadthree.fundtransfer.constant.AppConstant;

import com.squadthree.fundtransfer.dto.TransactionResponseDto;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	/**
	 * Handle the not valid field errors along with validation messages and get the
	 * list of multiple field errors.
	 * 
	 * @author Amala.S
	 * @since 25-08-2020
	 */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", new Date());
		body.put("status", status.value());

		// Get all errors for field valid
		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage)
				.collect(Collectors.toList());

		body.put("errors", errors);
		return new ResponseEntity<>(body, headers, status);
	}

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<Object> customerNotFoundException(CustomerNotFoundException ex, WebRequest request) {
		
		TransactionResponseDto  transactionResponseDto = new TransactionResponseDto();
		transactionResponseDto.setResponseMessage(AppConstant.CUSTOMER_NOT_FOUND);
		transactionResponseDto.setStatusCode(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<>(transactionResponseDto, HttpStatus.NOT_FOUND);
	}
	
	
	/**
	 * This method will handle account Not present exception
	 * 
	 * @param exeception
	 * @return TransactionResponseDto
	 */
	@ExceptionHandler(AccountNotFoundException.class)
	public ResponseEntity<TransactionResponseDto> accountNotFoundException(AccountNotFoundException exeception ) {
		
		TransactionResponseDto  transactionResponseDto = new TransactionResponseDto();
		transactionResponseDto.setResponseMessage(AppConstant.ACCOUNT_NOT_FOUND_MESSAGE);
		transactionResponseDto.setStatusCode(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<>(transactionResponseDto, HttpStatus.NOT_FOUND);
	}
	
	
	/**
	 * This will handle the insufficient balance check
	 * @param exeception
	 * @return TransactionResponseDto
	 */

	@ExceptionHandler(InsufficientBalanceException.class)
	public ResponseEntity<TransactionResponseDto> InsufficientBalanceException(InsufficientBalanceException exeception ) {
		
		TransactionResponseDto  transactionResponseDto = new TransactionResponseDto();
		transactionResponseDto.setResponseMessage(AppConstant.INSUFFICIENT_BALANCE);
		transactionResponseDto.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
		
		return new ResponseEntity<>(transactionResponseDto , HttpStatus.NOT_ACCEPTABLE);
	}
	

	/**
	 * This method will handle maximum limit transaction exception
	 * @param exeception
	 * @return TransactionResponseDto
	 */
	@ExceptionHandler(MaximumLimitTransaction.class)
	public ResponseEntity<TransactionResponseDto> MaximumLimitTransaction(MaximumLimitTransaction exeception) {
		
		TransactionResponseDto  transactionResponseDto = new TransactionResponseDto();
		transactionResponseDto.setResponseMessage(AppConstant.LIMIT_CROSSED);
		transactionResponseDto.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
		
		return new ResponseEntity<>(transactionResponseDto, HttpStatus.NOT_ACCEPTABLE);
	}
	
	
	/**
	 * This method will handle minimum balance exception
	 * @param exeception
	 * @return TransactionResponseDto
	 */
	@ExceptionHandler(MinimumBalanceException.class)
	public ResponseEntity<TransactionResponseDto> MinimumBalanceException(MinimumBalanceException exeception) {
		
		TransactionResponseDto  transactionResponseDto = new TransactionResponseDto();
		transactionResponseDto.setResponseMessage( AppConstant.MINIMUM_BALANCE);
		transactionResponseDto.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
		
		return new ResponseEntity<>(transactionResponseDto, HttpStatus.NOT_FOUND);
	}

	
	/**
	 * This method will handle beneficiary not found exception
	 * @param exeception
	 * @return TransactionResponseDto
	 */
	@ExceptionHandler(BeneficiaryNotFoundException.class)
	public ResponseEntity<TransactionResponseDto> BeneficiaryNotFoundException(BeneficiaryNotFoundException exeception) {
		
		TransactionResponseDto  transactionResponseDto = new TransactionResponseDto();
		transactionResponseDto.setResponseMessage( AppConstant.BENEFICIARY_NOT_FOUND);
		transactionResponseDto.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
		
		return new ResponseEntity<>(transactionResponseDto, HttpStatus.NOT_FOUND);
	}

	/**
	 * This method will handle invalid transaction exception
	 * @param exeception
	 * @return TransactionResponseDto
	 */
	@ExceptionHandler(InvalidTransactionException.class)
	public ResponseEntity<TransactionResponseDto> InvalidTransactionException(InvalidTransactionException exeception) {
		
		TransactionResponseDto  transactionResponseDto = new TransactionResponseDto();
		transactionResponseDto.setResponseMessage( AppConstant.BENEFICIARY_NOT_FOUND);
		transactionResponseDto.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
		
		return new ResponseEntity<>(transactionResponseDto, HttpStatus.NOT_FOUND);
	}

}

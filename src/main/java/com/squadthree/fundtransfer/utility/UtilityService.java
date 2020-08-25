package com.squadthree.fundtransfer.utility;

import org.springframework.beans.BeanUtils;

import com.squadthree.fundtransfer.constant.AppConstant;
import com.squadthree.fundtransfer.dto.TransactionResponseDto;
import com.squadthree.fundtransfer.dto.TransactionDto;
import com.squadthree.fundtransfer.entity.Transaction;


/**
 * This class is used for common application coding.
 * 
 * @author sweta
 * @since 24-07-2020
 */
public class UtilityService {
	/**
	 * This method is used to retuen the proper response to user.
	 * 
	 * @param message
	 * @return
	 */

	public static TransactionResponseDto responseDto(String message) {
		TransactionResponseDto responseDto = new TransactionResponseDto();
		responseDto.setResponseMessage(message);
		responseDto.setStatusCode(200);
		return responseDto;
	}

	public static Transaction convertTransactionDtoToEntity(TransactionDto transactionDto) {
		Transaction transaction = new Transaction();
		BeanUtils.copyProperties(transactionDto, transaction);
		return transaction;
	}

}

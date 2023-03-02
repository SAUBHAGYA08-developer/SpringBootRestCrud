package com.restcrudapi.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.restcrudapi.exception.CarNotFoundException;
import com.restcrudapi.model.ErrorData;

@RestControllerAdvice
public class CustomExceptionHandlerService {
	
	/*@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<String> handleProductNotFoundException(
			ProductNotFoundException pne)
	{
		return new ResponseEntity<String>(
				pne.getMessage(),HttpStatus.NOT_FOUND
				);
	}*/
	
	//--->> By the use of this method O/P will given in JSON format
	
	@ExceptionHandler(CarNotFoundException.class)
	public ResponseEntity<ErrorData> handleProductNotFoundException(
			CarNotFoundException pne)
	{
		return new ResponseEntity<ErrorData>(
				new ErrorData(
						pne.getMessage(),
						new Date().toString(),
						"Product"
						),
				HttpStatus.NOT_FOUND);
	}

}

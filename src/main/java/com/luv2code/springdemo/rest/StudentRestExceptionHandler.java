package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

	// add Exception Handling code here 
	// add an Exception Handler @ExceptionHandler
	
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exe){
			
			// create a StudentErrorResponse
			StudentErrorResponse error=new StudentErrorResponse();
			
			error.setStatus(HttpStatus.NOT_FOUND.value());
			error.setMessage(exe.getMessage());
			error.setTimeStamp(System.currentTimeMillis());
			
			// return ResponseEntity
			return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		}
		
		// add another exception handler - to catch all exceptions
		
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(Exception exe){
			
			       // create a StudentErrorResponse
					StudentErrorResponse error=new StudentErrorResponse();
					
					error.setStatus(HttpStatus.BAD_REQUEST.value());
					error.setMessage(exe.getMessage());
					error.setTimeStamp(System.currentTimeMillis());
					
					// return ResponseEntity
					return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
					
		}
		
	
}

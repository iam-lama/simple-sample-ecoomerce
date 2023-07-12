package com.ecommerce.learn.exception;

import java.util.List;
import java.util.ArrayList;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {
//	 @SuppressWarnings("rawtypes")
	 @ExceptionHandler(ConstraintViolationException.class)
	 public ResponseEntity<Object> handle(ConstraintViolationException ex) {
	   
		List<String> errors = new ArrayList<String>();
		
	    for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
	        errors.add(violation.getRootBeanClass().getName() + " " + 
	          violation.getPropertyPath() + ": " + violation.getMessage());
	    }

	    ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
	    return new ResponseEntity<Object>(apiError, apiError.getStatus());
	    
//	    return new ResponseEntity<ErrorResponse>(HttpStatus.BAD_REQUEST);
	}
	 
//	    @SuppressWarnings("rawtypes")
	    @ExceptionHandler(InvalidConfigurationPropertyValueException.class)
	    public ResponseEntity<Object> handle(InvalidConfigurationPropertyValueException ex) {
	    	String error = ex.getReason();
	    	
	        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	    }

}

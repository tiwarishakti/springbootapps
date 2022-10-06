package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.exceptions.ProductNotFoundException;

@ControllerAdvice
public class ProductExceptionController {

	@ExceptionHandler(value=ProductNotFoundException.class)
	public ResponseEntity<Object> handleException(ProductNotFoundException ex) {
		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
}
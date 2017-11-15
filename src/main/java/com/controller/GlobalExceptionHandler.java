package com.controller;

import java.io.IOException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

//@ControllerAdvice
public class GlobalExceptionHandler { 
	
	@InitBinder
	public void setInitBinder(WebDataBinder result){
		result.setDisallowedFields(new String[]{"city"});
	}
	
	@ExceptionHandler(value = NullPointerException.class)
	public String handleNullPointerException(Exception e){
		return "NullPointerException";	
	}
	@ExceptionHandler(value = IOException.class)
	public String handleIOException(Exception e){
		return "IOException";	
	}	
}
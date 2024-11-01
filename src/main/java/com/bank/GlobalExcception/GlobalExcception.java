package com.bank.GlobalExcception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExcception {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex)
	{
		Map<String, String> error = new HashMap<>();
		
		ex.getBindingResult().getFieldErrors().forEach(e->error.put(e.getField(),e.getDefaultMessage()));
		
		return new ResponseEntity<Map<String,String>>(error,HttpStatus.BAD_GATEWAY);
		
	}
}

package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

		@ExceptionHandler({MethodArgumentNotValidException.class})
		public ResponseEntity<Map<String,String>> validData(MethodArgumentNotValidException e){
			Map<String,String> exception = new HashMap<>();
			
			e.getBindingResult().getFieldErrors().forEach(x ->{
				exception.put(x.getField(), x.getDefaultMessage());
			});
			
			return ResponseEntity.status(700).body(exception);
		}
}

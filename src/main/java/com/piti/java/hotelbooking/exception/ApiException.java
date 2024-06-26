package com.piti.java.hotelbooking.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@SuppressWarnings("serial")
@Getter
@AllArgsConstructor
public class ApiException extends RuntimeException{
	 private HttpStatus status;
	 private String message;
}

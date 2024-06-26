package com.piti.java.hotelbooking.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {
	 private LocalDateTime timeStamp;
	 private String message;
	 private String details;
	 private String errorCode;
}

package com.yash.resumemailer.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ApiResponse<T> {
	private int status;
	private String message;
	private T data;
	private String errorDetails;
	private LocalDateTime timestamp;

	// Constructors
	public ApiResponse() {
		this.timestamp = LocalDateTime.now();
	}

	public ApiResponse(int status, String message, T data) {
		this.status = status;
		this.message = message;
		this.data = data;
		this.timestamp = LocalDateTime.now();
	}

	public ApiResponse(int status, String message, String errorDetails) {
		this.status = status;
		this.message = message;
		this.errorDetails = errorDetails;
		this.timestamp = LocalDateTime.now();
	}

}

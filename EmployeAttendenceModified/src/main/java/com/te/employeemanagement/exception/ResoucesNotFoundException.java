package com.te.employeemanagement.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ResoucesNotFoundException extends RuntimeException{

	private String message;
}

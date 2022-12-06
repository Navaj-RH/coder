package com.te.employeemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDto {

	private boolean error;
	private String message;
	private Object object;
}

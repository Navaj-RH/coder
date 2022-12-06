package com.te.employeemanagement.dto;

import java.util.List;

import com.te.employeemanagement.entity.Attendence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

private Integer slno;
	
	private String empId;
	private String empName;
	
	private List<Attendence> attendences;
}

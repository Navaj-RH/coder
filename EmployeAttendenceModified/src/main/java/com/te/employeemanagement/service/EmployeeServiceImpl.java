package com.te.employeemanagement.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.employeemanagement.dao.EmployeeDao;
import com.te.employeemanagement.dto.EmployeeDto;
import com.te.employeemanagement.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao dao;


	@Override
	public EmployeeDto register(EmployeeDto dto) {
		Employee employee = new Employee();
		BeanUtils.copyProperties(dto, employee);
	
		employee.getAttendences().stream().forEach((atten)->{atten.setEmployee(employee);
		if(atten.getDate().getDayOfMonth()==0) {
			atten.setAfternoon("");
			atten.setMorning("");
		}
		
		}); 
		dao.save(employee);
		return dto;
		
	}

	
}

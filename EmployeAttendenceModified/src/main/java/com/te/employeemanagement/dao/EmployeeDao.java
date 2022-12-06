package com.te.employeemanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.employeemanagement.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{

	Employee findByEmpId(String empId);
	
}

package com.te.springloggerdemo.dao;

import org.springframework.data.repository.CrudRepository;

import com.te.springloggerdemo.entity.Employee;

public interface EmployeeDao extends CrudRepository<Employee,String>{

	Employee findByEmpId(String empId);
}

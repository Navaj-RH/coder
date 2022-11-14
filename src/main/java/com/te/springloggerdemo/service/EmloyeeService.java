package com.te.springloggerdemo.service;

import com.te.springloggerdemo.LogibDto;
import com.te.springloggerdemo.entity.Employee;
import com.te.springloggerdemo.entity.FileEntity;

public interface EmloyeeService {

	Employee register(Employee employee);
	
	Employee login(LogibDto dto);
	
	void storeFile(FileEntity entity);
	
	public byte[] getFile(String fileName);
}

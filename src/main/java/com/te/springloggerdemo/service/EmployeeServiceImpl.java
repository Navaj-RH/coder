package com.te.springloggerdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springloggerdemo.FileUtils;
import com.te.springloggerdemo.LogibDto;
import com.te.springloggerdemo.dao.EmployeeDao;
import com.te.springloggerdemo.dao.FileDao;
import com.te.springloggerdemo.entity.Employee;
import com.te.springloggerdemo.entity.FileEntity;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class EmployeeServiceImpl implements EmloyeeService{
	@Autowired
	private EmployeeDao dao;
	@Autowired
	private FileDao fileDao;
@Override
public Employee login(LogibDto dto) {
    Employee employee = dao.findByEmpId(dto.getEmpId());
    if(employee!=null) {
    	if(employee.getPassword().equals(dto.getPassword())) {
    		
    		return employee;
    	}
    }
	return null;
	
	
}

@Override
public Employee register(Employee employee) {
	return dao.save(employee);
}

@Override
public byte[] getFile(String fileName) {
	FileEntity fileEntity = fileDao.findByFileName(fileName);
	byte[] decompressImage = FileUtils.decompressImage(fileEntity.getFile());
	return decompressImage;
}

@Override
public void storeFile(FileEntity entity) {
	log.info("entered the store method");
fileDao.save(entity);	
log.info("file stored");
}
}

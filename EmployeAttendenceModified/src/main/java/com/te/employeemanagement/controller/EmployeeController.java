package com.te.employeemanagement.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.employeemanagement.dto.EmployeeDto;
import com.te.employeemanagement.dto.ResponseDto;
import com.te.employeemanagement.service.EmployeeService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@Autowired
	DataSource dataSource;

	@GetMapping("/getByMonth/{month}")
	public ResponseEntity<?> getAll(@PathVariable String month) throws JRException, FileNotFoundException, SQLException {
		String[] arr= {" ","jan","feb","mar","apr","may","jun","jul","aug","sep","oct","nov","dec"};
		int x=0;
		for(int i=0;i<arr.length;i++) {
			if(month.equalsIgnoreCase(arr[i])) {
				x=i;
			}
		}
		JasperReport compileReport = JasperCompileManager.compileReport(new FileInputStream(
				"C:\\Users\\i c c\\Desktop\\JasperReportsProjects\\EmployeAttendence\\src\\main\\resources\\Task9.jrxml"));

		HashMap<String, Object> map = new HashMap<>();
		map.put("Parameter1", x);
		JasperPrint fillReport = JasperFillManager.fillReport(compileReport, map, dataSource.getConnection());
		JasperExportManager.exportReportToPdfFile(fillReport,
				"C:\\Users\\i c c\\Desktop\\JasperReportsProjects\\Task9Month.pdf");
		
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody EmployeeDto dto) {
		if(dto!=null) {
			EmployeeDto register = service.register(dto);
			if(register!=null) {
				return new ResponseEntity<>(new ResponseDto(false, "Registered successfully", register), HttpStatus.ACCEPTED);
			}
		}
		return new ResponseEntity<>(new ResponseDto(true, "please check your credentials once", dto), HttpStatus.BAD_REQUEST);
	}
	
		
	
	
}

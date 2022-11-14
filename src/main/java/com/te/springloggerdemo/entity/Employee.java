package com.te.springloggerdemo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	@Id
	private String empId;
	private String empName;
	private String password;
	private String empEmail;
	
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "employee")
	@JsonManagedReference
	private EmployeeSecondary secondary;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "employee")
	@JsonManagedReference
	private List<EmployeeAdress> adresses;
	
}

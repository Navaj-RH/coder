package com.te.springloggerdemo.entity;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Data
public class EmployeeAdress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addId;
	private String addType;
	private String address;
	private String pincode;
	private String state;
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	private Employee employee;
}

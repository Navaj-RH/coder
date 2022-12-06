package com.te.employeemanagement.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Attendence {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer slno;
	private String morning;
	private String afternoon;
	private LocalDate date;

	@ManyToOne(cascade = CascadeType.ALL)
	private Employee employee;

	
}

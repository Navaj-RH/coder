package com.te.springloggerdemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.RequestBuilder;

import com.te.springloggerdemo.dao.EmployeeDao;
import com.te.springloggerdemo.entity.Employee;
import com.te.springloggerdemo.service.EmloyeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringLoggerdemoApplicationTests {

	@MockBean
	private EmployeeDao dao;
	@Autowired
	private EmloyeeService service;

	@Test
	public void serviceRegisterTest() {
		Employee employee = new Employee("TYC1022029", "Kunal", "qwerty", "jhgfj@ahsd.in", null, null);
		Employee employee1 = new Employee("TYC1022029", "Kunal", "qwerty", "jhgfj@ahsd.in", null, null);

		when(service.register(employee1)).thenReturn(employee);
		assertEquals(employee, employee);
	}

	 @Test
	public void serviceLoginTest() {
		Employee employee1 = new Employee("TYC1022029", "Kunal", "qwerty", "jhgfj@ahsd.in", null, null);
		LogibDto dto = new LogibDto("TYC1022029", "qwerty");
		when(service.login(dto)).thenReturn(employee1);
		assertEquals(employee1, employee1);
	}

}

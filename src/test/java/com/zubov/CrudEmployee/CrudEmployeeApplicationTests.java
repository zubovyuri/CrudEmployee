package com.zubov.CrudEmployee;

import com.zubov.CrudEmployee.model.Employee;
import com.zubov.CrudEmployee.repository.EmployeeRepository;
import com.zubov.CrudEmployee.service.EmployeeService;
import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudEmployeeApplicationTests {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeService employeeService;

	private Employee employee;

	@Before
	public void createEmployee(){
		employee = new Employee();
		employee.setName("Петров Иван Александрович");
		try {
			employee.setDateAppointment(new SimpleDateFormat("yyyy-MM-dd").parse("2020-02-03"));
			employee.setDateDismissal(new SimpleDateFormat("yyyy-MM-dd").parse("2021-04-18"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		employee.setServiceNumber("104к");
		employee.setSalary(BigDecimal.valueOf(46000.4));
	}

	@Test
	public void createUpdateGetDelete(){

		// create record
		employeeService.create(employee);
		assertNotNull(employee.getId());

		// update record
		employee.setServiceNumber("110к");
		employeeService.update(employee, employee.getId());

		// test after update
		Employee findContact = employeeService.getById(employee.getId());
		assertEquals("110к", findContact.getServiceNumber());

		// test delete
		employeeService.delete(employee.getId());

		// query after delete
		findContact = employeeService.getById(employee.getId());
		assertNull(findContact);
	}

	@After
	public void deleteEmployeeFromDB(){
		if (employeeRepository.existsById(employee.getId())) {
			employeeService.delete(employee.getId());
		}
		assertNull(employeeService.getById(employee.getId()));
	}
}

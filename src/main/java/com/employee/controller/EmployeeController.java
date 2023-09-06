package com.employee.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.customexception.SalaryNotFoundException;
import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
	public static Logger log = Logger.getLogger(EmployeeController.class);
	@Autowired
	EmployeeService es;

	@PostMapping(value = "/setAllDetails")
	public String setAllDetails(@RequestBody List<Employee> e) throws SalaryNotFoundException {
		return es.setAllDetails(e);
	}

	@GetMapping(value = "/getAllDetails")
	public List<Employee> getAllDetails() {
		return es.getAllDetails();
	}

	@GetMapping(value = "/getAllEmpDetails")
	public List<Employee> getAllEmpDetails() {
		PropertyConfigurator.configure("EmployeeLog");
		log.info(es.getAllEmpDetails());
		return es.getAllEmpDetails();
	}
}

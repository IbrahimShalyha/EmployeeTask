package com.employee.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.customexception.SalaryNotFoundException;
import com.employee.dao.EmployeeDao;
import com.employee.entity.Employee;

@Service
public class EmployeeService {
	public static Logger log = Logger.getLogger(EmployeeService.class);
	@Autowired
	EmployeeDao ed;

	public String setAllDetails(List<Employee> e) throws SalaryNotFoundException {
		List<Employee> z = e.stream().filter(x -> x.getSalary() >= 75000).toList();
		if (z.isEmpty()) {
			throw new SalaryNotFoundException("GIVEN SALARY IS INVALID");
		} else {
			return ed.setAllDetails(z);
		}

	}

	public List<Employee> getAllDetails() {
		return ed.getAllDetails();
	}

	public List<Employee> getAllEmpDetails() {
		PropertyConfigurator.configure("EmployeeLog");
		log.info(ed.getAllEmpDetails());
		return ed.getAllEmpDetails();
	}

}

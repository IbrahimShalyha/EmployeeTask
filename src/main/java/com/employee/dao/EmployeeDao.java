package com.employee.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;

@Repository
public class EmployeeDao {
	public static Logger log = Logger.getLogger(EmployeeDao.class);
	@Autowired
	EmployeeRepository er;

	public String setAllDetails(List<Employee> e) {
		er.saveAll(e);
		return "ALL DATA'S SAVED SUCCESSFULLY";
	}

	public List<Employee> getAllDetails() {
		return er.findAll();
	}

	public List<Employee> getAllEmpDetails() {
		PropertyConfigurator.configure("EmployeeLog");
		log.info(er.findAll());
		return er.findAll();
	}

}

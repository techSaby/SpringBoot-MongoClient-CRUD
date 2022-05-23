package com.techsaby.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techsaby.springboot.entity.Employee;
import com.techsaby.springboot.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getAll() {
		return employeeRepository.getAll();
	}

	public String save(Employee emp) {
		return employeeRepository.save(emp);
	}

	public String update(Employee emp) {
		return employeeRepository.update(emp);
	}

	public String delete(String id) {
		return employeeRepository.delete(id);
	}

}

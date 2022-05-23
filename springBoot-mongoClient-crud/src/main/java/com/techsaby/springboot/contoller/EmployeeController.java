package com.techsaby.springboot.contoller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techsaby.springboot.entity.Employee;
import com.techsaby.springboot.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping("/")
	public List<Employee> getAll(){
		return employeeService.getAll();
	}
	
	@PostMapping("/")
	public String save(@RequestBody Employee emp){
		return employeeService.save(emp);
	}
	
	@PutMapping("/")
	public String update(@RequestBody Employee emp){
		return employeeService.update(emp);
	}
	
	@DeleteMapping("/")
	public String delete(@PathParam("id") String id){
		return employeeService.delete(id);
	}
	
}

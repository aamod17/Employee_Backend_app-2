package com.AmodIT.Service;

import java.util.List;

import com.AmodIT.Model.Employee;

public interface EmployeeService {
	
	// save an employee
	public abstract Employee saveEmployee(Employee employee);
	
	// get an employee
	public abstract Employee getEmployeeById(Long id);
	
	// get all employee
	public abstract List<Employee> getallEmployees();
	
	// update an employee
	public abstract Employee updateEmployee(Long id, Employee employee);
	
	// delete an employee
	public abstract String deleteEmployeeById(Long id);

}

package com.AmodIT.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.AmodIT.Exception.ResourceNotFoundException;
import com.AmodIT.Model.Employee;
import com.AmodIT.Repository.EmployeeRepository;
import com.AmodIT.Service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	// injecting object with constructor dependency injection
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public Employee saveEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		Optional<Employee> findById = employeeRepository.findById(id);
		Employee employee = findById.orElseThrow(() -> {return new ResourceNotFoundException("employee","Id",id);});
		return employee;
	}

	@Override
	public List<Employee> getallEmployees() {
		List<Employee> allEmployee = employeeRepository.findAll();
		return allEmployee;
	}

   /*	@Override
	public Employee updateEmployee(Long id, Employee employee) {
		//Optional<Employee> findByIdOpt = employeeRepository.findById(id);
		//Employee existingEmployee = findByIdOpt.orElseThrow(() -> {throw new ResourceNotFoundException("employee", "Id", id);});
		//Employee updatedEmployee = employeeRepository.saveAndFlush(existingEmployee);
		return null;
	}*/

	@Override
	public String deleteEmployeeById(Long id) {
		Optional<Employee> findById = employeeRepository.findById(id);
		Employee existingEmployee = findById.orElseThrow(() -> {throw new ResourceNotFoundException("employee","Id", id);});
		employeeRepository.delete(existingEmployee);
		return "employee data deleted successfully";
		
	}

	@Override
	public Employee updateEmployee(Long id, Employee employee) {
		Optional<Employee> findById = employeeRepository.findById(id);
		Employee existingEmployee = findById.orElseThrow(() -> {throw new ResourceNotFoundException("employee", "Id", id);});
		existingEmployee.setFirstname(employee.getFirstname());
		existingEmployee.setLastname(employee.getLastname());
		existingEmployee.setEmail(employee.getEmail());
		
		Employee updatedEmployee = employeeRepository.saveAndFlush(existingEmployee);
		return updatedEmployee;
	}

}

package com.AmodIT.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AmodIT.Model.Employee;
import com.AmodIT.Service.EmployeeService;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/app")
@Tag(name = "employee controller", description = "Employee_Backend_app-2")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	// http://localhost:8080/app/save-employee
	@PostMapping("/save-employee")
	@ApiResponse(description = "save the amployee data",responseCode = "200")
	@Operation(description = "post request",method = "@POSTMapping",requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody)
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}
	
	//http://localhost:8080/app/id
	@GetMapping("/get-employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id){
		Employee employeeById = employeeService.getEmployeeById(id);
		return new ResponseEntity<Employee>(employeeById, HttpStatus.OK);
	}
	
	// http://localhost:8080/app/employees
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> getallEmployees = employeeService.getallEmployees();
		return new ResponseEntity<List<Employee>>(getallEmployees, HttpStatus.OK);
		
	}
	
	// http://localhost:8080/update-employee
	@PutMapping("/update-employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id,@RequestBody Employee employee){
		Employee updateEmployee = employeeService.updateEmployee(id, employee);
		return new ResponseEntity<Employee>(updateEmployee, HttpStatus.OK);
	}
	
	// http://localhost:8080/delete-employee
	@DeleteMapping("/delete-employee/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Long id){
		String msg = employeeService.deleteEmployeeById(id);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
		
	}

}

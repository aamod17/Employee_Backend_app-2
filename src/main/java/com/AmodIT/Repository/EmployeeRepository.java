package com.AmodIT.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AmodIT.Model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}

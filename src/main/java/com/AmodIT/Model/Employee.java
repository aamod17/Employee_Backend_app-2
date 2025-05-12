package com.AmodIT.Model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "empployees")
@Schema(description = "employees table", $comment = "Employee Entity contains Id, First Name, Last Name, Email", name = "Employee Entiy")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(name = "id", title = "primary key ", $comment = "id of employees table")
	private Long id;
	
	@Column(name = "first_name")
	@Schema($comment = "firstname of employees table")
	private String firstname;
	
	@Column(name = "last_name")
	@Schema(name = "lastname")
	private String lastname;
	
	@Column(name = "email")
	@Schema(title = "email of employees table")
	private String email;
	
	public Employee() {
		super();
		
	}

	public Employee(Long id, String firstname, String lastname, String email) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	

}

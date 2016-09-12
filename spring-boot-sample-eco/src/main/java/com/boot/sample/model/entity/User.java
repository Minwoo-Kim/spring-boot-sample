package com.boot.sample.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@Column (name = "id", nullable = false, length = 255)
	private String id;
	
	@Column (name = "password", nullable = false, length = 255)
	private String password;
	
	@Column (name = "name", nullable = false, length = 200)
	private String name;
	
	@Column (name = "email", length = 255)
	private String email;
	
	@Column (name = "department", length = 100)
	private String department;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
}
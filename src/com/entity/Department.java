package com.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {
	@Id
	
	private int department_id;
	private String name;
	
	@OneToMany(mappedBy = "department")
	private Set<Employee> employee;
	
	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(int department_id, String name, Set<Employee> employee) {
		super();
		this.department_id = department_id;
		this.name = name;
		this.employee = employee;
	}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(Set<Employee> employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Department [department_id=" + department_id + ", name=" + name + ", employee=" + employee + "]";
	}
	
	
}

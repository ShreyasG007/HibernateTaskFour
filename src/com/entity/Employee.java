package com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
 

@Entity
public class Employee {
	@Id
	private int id;
	private String name;
	private double salary;
	
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;
	
	@ManyToOne
	@JoinColumn(name = "location_id")
	private Location location;
	
	private String hire_date;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getHire_date() {
		return hire_date;
	}

	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}

	public Employee(int id, String name, double salary, Department department, Location location, String hire_date) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department = department;
		this.location = location;
		this.hire_date = hire_date;
	}


	@Override
	public String toString() {
	    return "Employee [id=" + id +
	            ", name=" + (name != null ? name : "N/A") +
	            ", salary=" + salary +
	            ", department=" + (department != null ? department.getName() : "N/A") +
	            ", location=" + (location != null ? location.getCity() : "N/A") +
	            ", hire_date=" + (hire_date != null ? hire_date.toString() : "N/A") +
	            "]";
	}

	
}

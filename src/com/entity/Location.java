package com.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Location {
	@Id
	private int location_id;
	private String city;
	
	@OneToMany(mappedBy = "location")
	private Set<Employee> employee;
	
	public Location() {
		// TODO Auto-generated constructor stub
	}

	public Location(int location_id, String city, Set<Employee> employee) {
		super();
		this.location_id = location_id;
		this.city = city;
		this.employee = employee;
	}

	public int getLocation_id() {
		return location_id;
	}

	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Set<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(Set<Employee> employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Location [location_id=" + location_id + ", city=" + city + ", employee=" + employee + "]";
	}
	
	
}

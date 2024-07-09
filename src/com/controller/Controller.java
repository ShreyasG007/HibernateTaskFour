package com.controller;

import com.entity.Department;
import com.entity.Employee;
import com.entity.Location;
import com.service.Service;

public class Controller {
	Service service = new Service();
	public void addDepartment(Department d) {
		service.addDepartment(d);
		
	}
	public void addLocation(Location l) {
		service.addLocation(l);
		
	}
	public void addEmployee(Employee e) {
		service.addEmployee(e);
	}
	public void getMarketingDepartmentSalaries() {
		service.MarketingDepartmentSalaries();
	}
	public void getSalariesAboveAverage() {
		service.getSalariesAboveAverage();
		
		
	}
	public void getLowestSalaryTestDepartment() {
		service.getLowestSalaryTestDepartment();
	}
	public void getTotalSalaryExpenditure() {
		service.getTotalSalaryExpenditure();
	}
	public void getAverageSalaryDevDepartment() {
		service.getAverageSalaryDevDepartment();
	}
	public void getTotalSalaryExpenditureDevAndSupportDept() {
		service.getTotalSalaryExpenditureDevAndSupportDept();
		
	}
	public void getEmployeeOverAverageSalaryDevDepartment() {
		service.getEmployeeOverAverageSalaryDevDepartment();
		
	}
	public void getTotalSalaryExpenditurePuneLoc() {
		service.getTotalSalaryExpenditurePuneLoc();
	}
	public void getCountOfEmployeesPuneLocation() {
		service.getCountOfEmployeesPuneLocation();
	}

}

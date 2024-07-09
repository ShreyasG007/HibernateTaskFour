package com.service;

import com.dao.Dao;
import com.entity.Department;
import com.entity.Employee;
import com.entity.Location;

public class Service {
	Dao dao = new Dao();
	public void addDepartment(Department d) {
		dao.addDepartment(d);
		
	}

	public void addLocation(Location l) {
		dao.addLocation(l);
		
	}

	public void addEmployee(Employee e) {
		dao.addEmployee(e);
		
	}

	public void MarketingDepartmentSalaries() {
		dao.MarketingDepartmentSalaries();
		
	}

	public void getSalariesAboveAverage() {
		dao.getSalariesAboveAverage();
	}

	public void getLowestSalaryTestDepartment() {
		dao.getLowestSalaryTestDepartment();
		
	}

	public void getTotalSalaryExpenditure() {
		dao.getTotalSalaryExpenditure();
		
	}

	public void getAverageSalaryDevDepartment() {
		dao.getAverageSalaryDevDepartment();
	}

	public void getTotalSalaryExpenditureDevAndSupportDept() {
		dao.getTotalSalaryExpenditureDevAndSupportDept();
	}

	public void getEmployeeOverAverageSalaryDevDepartment() {
		dao.getEmployeeOverAverageSalaryDevDepartment();
		
	}

	public void getTotalSalaryExpenditurePuneLoc() {
		dao.getTotalSalaryExpenditurePuneLoc();
	}

	public void getCountOfEmployeesPuneLocation() {
		dao.getCountOfEmployeesPuneLocation();
	}

}

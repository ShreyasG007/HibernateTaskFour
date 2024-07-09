package com.frontend;

import com.controller.Controller;
import com.entity.Department;
import com.entity.Employee;
import com.entity.Location;

public class AddEmployee {
	public static void main(String[] args) {
		Controller controller = new Controller();
		
		Department d1 = new Department();
		d1.setDepartment_id(1);
		d1.setName("Marketing");
		
		Department d2 = new Department();
		d2.setDepartment_id(2);
		d2.setName("Development");
		
		Department d3 = new Department();
		d3.setDepartment_id(3);
		d3.setName("Support");
		
		Location l1 =new Location();
		l1.setLocation_id(1);
		l1.setCity("Pune");
		
		Location l2 =new Location();
		l2.setLocation_id(2);
		l2.setCity("Mumbai");
		
		Employee e1 = new Employee(1, "Alice", 25000.00, d1, l1, "2022-01-15");
		Employee e2 = new Employee(2, "Bob", 22000.00, d1, l2, "2022-02-20");
		Employee e3 = new Employee(3, "Charlie", 28000.00, d2, l1, "2022-03-10");
		Employee e4 = new Employee(4, "David", 20000.00, d2, l2, "2022-04-25");
		Employee e5 = new Employee(5, "Eve", 30000.00, d1, l1, "2023-01-07");
		
		controller.addDepartment(d1);
		controller.addDepartment(d2);
		controller.addDepartment(d3);
		
		controller.addLocation(l1);
		controller.addLocation(l2);
		
		controller.addEmployee(e1);
		controller.addEmployee(e2);
		controller.addEmployee(e3);
		controller.addEmployee(e4);
		controller.addEmployee(e5);
		
		
	}
}

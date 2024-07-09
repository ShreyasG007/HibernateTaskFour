package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.config.HibernateConfiguration;
import com.entity.Department;
import com.entity.Employee;
import com.entity.Location;

public class Dao {

	public void addDepartment(Department d) {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();

		openSession.save(d);

		transaction.commit();

		openSession.close();
	}

	public void addLocation(Location l) {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();

		openSession.save(l);

		transaction.commit();

		openSession.close();

	}

	public void addEmployee(Employee e) {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();

		openSession.save(e);

		transaction.commit();

		openSession.close();

	}

	public void MarketingDepartmentSalaries() {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();

		Criteria criteria = openSession.createCriteria(Employee.class, "employee")
				.createAlias("employee.department", "department").add(Restrictions.eq("department.name", "Marketing"))
				.setProjection(Projections.projectionList().add(Projections.property("employee.name"), "name")
						.add(Projections.property("employee.salary"), "salary"));

		List<Object[]> results = criteria.list();
		for (Object[] row : results) {
			System.out.println("Name: " + row[0] + ", Salary: " + row[1]);
		}

		transaction.commit();

		openSession.close();
	}

	public void getSalariesAboveAverage() {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();

		Criteria criteria = openSession.createCriteria(Employee.class, "employee");
		criteria.setProjection(Projections.avg("salary"));
		double avgSalary = (double) criteria.uniqueResult();

		Criteria avgCriteria = openSession.createCriteria(Employee.class, "employee")
				.createAlias("employee.department", "department").add(Restrictions.gt("employee.salary", avgSalary))
				.setProjection(Projections.projectionList().add(Projections.property("employee.name"), "name")
						.add(Projections.property("department.name"), "departmentName"));

		List<Object[]> results = avgCriteria.list();
		for (Object[] row : results) {
			System.out.println("Name: " + row[0] + ", Department: " + row[1]);
		}

		transaction.commit();

		openSession.close();

	}

	public void getLowestSalaryTestDepartment() {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();

		Criteria criteriaMinSalary = openSession.createCriteria(Employee.class, "employee")
				.createAlias("employee.department", "department").add(Restrictions.eq("department.name", "Test"))
				.setProjection(Projections.min("employee.salary"));

		Double minSalary = (Double) criteriaMinSalary.uniqueResult();

		if (minSalary == null) {
			System.out.println("No employees found in the 'Test' department.");
			return;
		}

		Criteria criteria = openSession.createCriteria(Employee.class, "employee")
				.createAlias("employee.department", "department").add(Restrictions.eq("department.name", "Test"))
				.add(Restrictions.eq("employee.salary", minSalary))
				.setProjection(Projections.projectionList().add(Projections.property("employee.name"), "name")
						.add(Projections.property("employee.salary"), "salary"));

		List<Object[]> results = criteria.list();
		for (Object[] row : results) {
			System.out.println("Name: " + row[0] + ", Salary: " + row[1]);
		}

		transaction.commit();

		openSession.close();

	}

	public void getTotalSalaryExpenditure() {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();

		Criteria criteria = openSession.createCriteria(Employee.class, "employee");
		criteria.setProjection(Projections.sum("salary"));
		List list = criteria.list();
		System.out.println("Total Expenditure Salary : " + list);

		transaction.commit();

		openSession.close();

	}

	public void getAverageSalaryDevDepartment() {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();

		Criteria criteria = openSession.createCriteria(Employee.class, "employee")
				.createAlias("employee.department", "department").add(Restrictions.eq("department.name", "Development"))
				.setProjection(Projections.avg("employee.salary"));
		Double averageSalary = (Double) criteria.uniqueResult();

		System.out.println("Average Salary of Development Department : " + averageSalary);

		transaction.commit();

		openSession.close();
	}

	public void getTotalSalaryExpenditureDevAndSupportDept() {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();

		Criteria criteria = openSession.createCriteria(Employee.class, "employee")
				.createAlias("employee.department", "department").add(Restrictions.eq("department.name", "Development"))
				.setProjection(Projections.sum("employee.salary"));
		Double averageSalaryDev = (Double) criteria.uniqueResult();

		Criteria criteriaSupport = openSession.createCriteria(Employee.class, "employee")
				.createAlias("employee.department", "department").add(Restrictions.eq("department.name", "Support"))
				.setProjection(Projections.sum("employee.salary"));
		Double averageSalarySupport = (Double) criteriaSupport.uniqueResult();

		System.out.println("Total Salary of Development Department : " + averageSalaryDev);
		System.out.println("Total Salary of Support Department : " + averageSalarySupport);

		transaction.commit();

		openSession.close();

	}

	public void getEmployeeOverAverageSalaryDevDepartment() {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();

		Criteria criteria = openSession.createCriteria(Employee.class, "employee")
				.createAlias("employee.department", "department")
				.add(Restrictions.eq("department.name", "Development"))
				.setProjection(Projections.avg("employee.salary"));
		Double averageSalary = (Double) criteria.uniqueResult();

		Criteria criteriaDev = openSession.createCriteria(Employee.class, "employee")
				.createAlias("employee.department", "department")
				.add(Restrictions.eq("department.name", "development"))
				.add(Restrictions.gt("employee.salary", averageSalary));
		List<Employee> list = criteriaDev.list();

		for (Employee employee : list) {
			System.out.println(employee);
		}
		openSession.close();
	}

	public void getTotalSalaryExpenditurePuneLoc() {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();

		Criteria criteria = openSession.createCriteria(Employee.class, "employee")
				.createAlias("employee.location", "location")
				.add(Restrictions.eq("location.city", "pune"))
				.setProjection(Projections.sum("employee.salary"));
		Double totalPuneLoc = (Double) criteria.uniqueResult();
		System.out.println("Total Expenditure of Pune Location : "+totalPuneLoc);
		openSession.close();
	}

	public void getCountOfEmployeesPuneLocation() {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();

		Criteria criteria = openSession.createCriteria(Employee.class, "employee")
				.createAlias("employee.location", "location")
				.add(Restrictions.eq("location.city", "pune"))
				.setProjection(Projections.count("employee.id"));
		long countEmployee = (long) criteria.uniqueResult();
		System.out.println("Count of employee in Pune Location : "+countEmployee);
		openSession.close();
		
	}

}

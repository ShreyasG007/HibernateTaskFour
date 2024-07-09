package com.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Department;
import com.entity.Employee;
import com.entity.Location;

public class HibernateConfiguration {
	public static final SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(Employee.class);
		configuration.addAnnotatedClass(Department.class);
		configuration.addAnnotatedClass(Location.class);
		return configuration.buildSessionFactory();
	}
}

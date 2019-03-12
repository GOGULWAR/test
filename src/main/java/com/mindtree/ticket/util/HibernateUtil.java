package com.mindtree.ticket.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mindtree.ticket.entity.Employee;
import com.mindtree.ticket.entity.Ticket;

public class HibernateUtil {

		public static SessionFactory factory;
		static {
		factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Ticket.class)
				.buildSessionFactory();
		}
		
	
	public HibernateUtil() {
		}


	public static SessionFactory getSessionFactory() {
		return factory;
	}
}

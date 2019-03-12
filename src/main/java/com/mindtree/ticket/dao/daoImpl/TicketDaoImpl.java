package com.mindtree.ticket.dao.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.ticket.entity.Employee;
import com.mindtree.ticket.entity.Ticket;
import com.mindtree.ticket.util.HibernateUtil;

@Repository
@Transactional
@EnableTransactionManagement
public class TicketDaoImpl implements TicketDao{
	static Session session;
	//creating a session
   Session getSession() {
	   
	   try {
		   //session=HibernateUtil.getSessionFactory().getCurrentSession();
		   session=HibernateUtil.getSessionFactory().openSession();
	   }catch(HibernateException e){
		   System.out.println("session is not created");   
	   }
	   return session;
   }
// Adding the ticket and employee
   public void add(Ticket ticket, Employee employee) {
		Session session=getSession();
		session.save(ticket);
		//session.save(employee);	
	}
// closing the ticket
	public void closeTicket(Ticket ticket) {

		getSession().update(ticket);
	}
	// for updating the data(part of closing the ticket)
	public Ticket getDetails(int id) {
		Ticket ticket=new Ticket();
		try {
			ticket=getSession().load(Ticket.class, id);
		}catch(ObjectNotFoundException e) {
			System.out.println(e.getMessage());
			throw new ObjectNotFoundException(Ticket.class,"No Ticket Found");
		}
		return ticket;
	}
// viewing the turnaround time
	public List<Ticket> view() {
		Session session=getSession();
		//session.openSession();
			List<Ticket>tickets=session.createQuery("from Ticket").list();
		return tickets;
	}

	//Getting the employee by id
	public Employee getEmployee(String s) {
		Employee employee=new Employee();
		try {
			employee=getSession().load(Employee.class, s);
		}catch(ObjectNotFoundException e) {
			System.out.println(e.getMessage());
			throw new ObjectNotFoundException(Employee.class, "No employee found");
		}
		return employee;
	}

}

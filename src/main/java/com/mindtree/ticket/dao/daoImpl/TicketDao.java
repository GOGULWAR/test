package com.mindtree.ticket.dao.daoImpl;

import java.util.List;

import com.mindtree.ticket.entity.Employee;
import com.mindtree.ticket.entity.Ticket;

public interface TicketDao {
public void add(Ticket ticket,Employee employee);
	public void closeTicket(Ticket ticket);
	 public List<Ticket>view();
	 public Ticket getDetails(int id);
	 public Employee getEmployee(String s);

}

package com.mindtree.ticket.service.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.ticket.dao.daoImpl.TicketDao;
import com.mindtree.ticket.dao.daoImpl.TicketDaoImpl;
import com.mindtree.ticket.dto.TicketCloseDto;
import com.mindtree.ticket.dto.TicketLogDto;
import com.mindtree.ticket.dto.TicketViewDto;
import com.mindtree.ticket.entity.Employee;
import com.mindtree.ticket.entity.Ticket;
import com.mindtree.ticket.exception.FutureTicketDate;
import com.mindtree.ticket.exception.IssdDepartment;
import com.mindtree.ticket.exception.SameLoggerResolver;

@Service
@Transactional
public class TicketServiceImpl implements TicketService{
	//@Autowired
	TicketDao ticketDao=new TicketDaoImpl();
	@Override
	public int log(TicketLogDto ticket)
			throws IssdDepartment, ParseException, FutureTicketDate, ObjectNotFoundException {
		Ticket tickets=new Ticket();
		System.out.println("in");
		Employee emp=ticketDao.getEmployee(ticket.getLoggedBy());
		System.out.println(ticket.getLoggedBy());
		
		if(emp.getDept().equalsIgnoreCase("ISSD"))
			throw new IssdDepartment("Employees with ISSD Department can't log a ticket");
		
		//setting values
		tickets.setLoggedBy(ticket.getLoggedBy().toUpperCase());
		tickets.setSeverity(ticket.getSeverity());
		tickets.setStatus("OPEN");
		tickets.setTicketDesc(ticket.getTicketDesc());
		//tickets.setRaisedDate(ticket.getRaisedDate());
		
//		//checking future date inputs
//		Date current=new Date();
//		SimpleDateFormat simpleDate=new SimpleDateFormat("yyyy-MM-dd HH:mm");
//		simpleDate.setLenient(false);
//		Date date=simpleDate.parse(tickets.getRaisedDate());
//		System.out.println(current+" "+date);
//		if(date.after(current))
//			throw new FutureTicketDate("The date entered is a future date");
		
		//saving the other parameters as null
		tickets.setResolvedBy(null);
		tickets.setResolution(null);
		tickets.setResolvedDate(null);
		emp.addTicket (tickets);
		
		//sending the ticket object to dao layer
		ticketDao.add(tickets, emp);
		return tickets.getTicketId();
		
		
		
		
	}

	@Override
	public int close(TicketCloseDto newTicket) throws ObjectNotFoundException, SameLoggerResolver {
		Ticket ticket=ticketDao.getDetails(newTicket.getTicketId());
		System.out.println(ticket.getResolvedBy());
		Employee employee=ticketDao.getEmployee(newTicket.getResolvedBy());
		System.out.println(employee.getEmployeeName());
		if(ticket.getLoggedBy().equalsIgnoreCase(newTicket.getResolvedBy()))
			throw new SameLoggerResolver("The logger and the resolver can't be same");
		
		//setting the resolved date as current date
		LocalDateTime resolveDate=LocalDateTime.now();
		ticket.setResolvedDate(resolveDate.toLocalDate().toString()+" "+resolveDate.toLocalTime().toString());
		ticket.setResolution(newTicket.getResolution());
		ticket.setResolvedBy(newTicket.getResolvedBy().toUpperCase());
		ticket.setStatus("CLOSED");
		ticket.setTicketId(newTicket.getTicketId());
		
		//sending the ticket to DAO layer for closing the ticket
		ticketDao.closeTicket(ticket);
		return ticket.getTicketId();
	}

	@Override
	public List<TicketViewDto> view() {
		List<Ticket>tickets=ticketDao.view();
		List<TicketViewDto> ticketView = new ArrayList<TicketViewDto>();
		for(Ticket ticket : tickets) {
			if(ticket.getStatus().equalsIgnoreCase("closed")) {
				TicketViewDto local=new TicketViewDto();
				local.setSeverity(ticket.getSeverity());
				local.setTicketDesc(ticket.getTicketDesc());
				local.setTicketId(ticket.getTicketId());
				
				Employee employee=ticketDao.getEmployee(ticket.getLoggedBy());
				local.setLoggedBy(employee.getEmployeeName());
				employee=ticketDao.getEmployee(ticket.getResolvedBy());
				local.setResolvedBy(employee.getEmployeeName());
				local.setTurnAround(123.5f);
				ticketView.add(local);
			}
		}
		return ticketView;
	}
		

	}

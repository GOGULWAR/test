package com.mindtree.ticket.service.serviceImpl;

import java.text.ParseException;
import java.util.List;

import org.hibernate.ObjectNotFoundException;

import com.mindtree.ticket.dto.TicketCloseDto;
import com.mindtree.ticket.dto.TicketLogDto;
import com.mindtree.ticket.dto.TicketViewDto;
import com.mindtree.ticket.entity.Employee;
import com.mindtree.ticket.exception.FutureTicketDate;
import com.mindtree.ticket.exception.IssdDepartment;
import com.mindtree.ticket.exception.SameLoggerResolver;

public interface TicketService {
	public int log(TicketLogDto ticket)throws IssdDepartment, ParseException, FutureTicketDate, ObjectNotFoundException;

	public int close(TicketCloseDto newTicket)throws ObjectNotFoundException,SameLoggerResolver;

	public List<TicketViewDto> view();
}

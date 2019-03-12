package com.mindtree.ticket.controller;

import java.text.ParseException;
import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.ticket.dto.TicketCloseDto;
import com.mindtree.ticket.dto.TicketLogDto;
import com.mindtree.ticket.dto.TicketViewDto;
import com.mindtree.ticket.exception.FutureTicketDate;
import com.mindtree.ticket.exception.IssdDepartment;
import com.mindtree.ticket.exception.SameLoggerResolver;
import com.mindtree.ticket.service.serviceImpl.TicketService;
import com.mindtree.ticket.service.serviceImpl.TicketServiceImpl;

@RestController
@RequestMapping("/tickets")
public class TicketController {

	//@Autowired
	TicketService ticketService=new TicketServiceImpl();
	// Logging a ticket
	@RequestMapping(value = "/log", method=RequestMethod.POST)
	public ResponseEntity<?> log(@RequestBody TicketLogDto ticket) {
		int id = 0;
		try {
			id = ticketService.log(ticket);
		} catch (IssdDepartment e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		} catch (FutureTicketDate e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		} catch (ParseException e) {
			return new ResponseEntity<>("Entered date is in invalid format", HttpStatus.OK);
		} catch (ObjectNotFoundException e) {
			return new ResponseEntity<>("No employee exists with the given mid", HttpStatus.OK);
		}
		if (id >= 0)
			return new ResponseEntity<>("Your issue has been logged with ID: " + id, HttpStatus.CREATED);
		return new ResponseEntity<>("Your issue could not be logged", HttpStatus.OK);
	}

	// closing a ticket
	@RequestMapping("/close")
	public ResponseEntity<?> close(@RequestBody TicketCloseDto ticket) {
		System.out.println(ticket.getTicketId() + ticket.getResolvedBy());
		int id = 0;
		try {
			id = ticketService.close(ticket);
		} catch (SameLoggerResolver e) {
			return new ResponseEntity<>("Ticket " + id + "is not closed as the logger and resolver are same",
					HttpStatus.OK);
		} catch (ObjectNotFoundException e) {
			return new ResponseEntity<>("sorry we don't have that id: " + e.getIdentifier() + " ", HttpStatus.OK);
		}
		return new ResponseEntity<>("Ticket " + id + "is closed", HttpStatus.OK);
	}

	// Viewing turnAround time
	@RequestMapping("/view")
	public ResponseEntity<?> view() {
		List<TicketViewDto> tickets = ticketService.view();
		return new ResponseEntity<List<TicketViewDto>>(tickets, HttpStatus.OK);
	}
}

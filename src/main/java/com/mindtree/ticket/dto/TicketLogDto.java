package com.mindtree.ticket.dto;

public class TicketLogDto {

	String loggedBy;
	//String raisedDate;
	String severity;
	String ticketDesc;
	public String getLoggedBy() {
		return loggedBy;
	}
	public void setLoggedBy(String loggedBy) {
		this.loggedBy = loggedBy;
	}
//	public String getRaisedDate() {
//		return raisedDate;
//	}
//	public void setRaisedDate(String raisedDate) {
//		this.raisedDate = raisedDate;
//	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public String getTicketDesc() {
		return ticketDesc;
	}
	public void setTicketDesc(String ticketDesc) {
		this.ticketDesc = ticketDesc;
	}
	
}

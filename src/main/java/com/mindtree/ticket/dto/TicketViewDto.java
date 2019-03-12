package com.mindtree.ticket.dto;

public class TicketViewDto {
	int ticketId;
	float turnAround;
	String loggedBy;
	String severity;
	String ticketDesc;
	String resolvedBy;
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public float getTurnAround() {
		return turnAround;
	}
	public void setTurnAround(float turnAround) {
		this.turnAround = turnAround;
	}
	public String getLoggedBy() {
		return loggedBy;
	}
	public void setLoggedBy(String loggedBy) {
		this.loggedBy = loggedBy;
	}
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
	public String getResolvedBy() {
		return resolvedBy;
	}
	public void setResolvedBy(String resolvedBy) {
		this.resolvedBy = resolvedBy;
	}
	

}

package com.mindtree.ticket.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ticket")
public class Ticket {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int ticketId;
	@Column
	private String loggedBy ;
	@Column
	private String raisedDate;
	@Column
	private String severity;
	@Column
	private String ticketDesc;
	@Column
	private String resolvedBy;
	@Column
	private String resolution;
	@Column
	private String resolvedDate;
	@Column
	private String status;
	//private Employee employee;
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ticket(int ticketId, String loggedBy, String raisedDate, String severity, String ticketDesc,
			String resolvedBy, String resolution, String resolvedDate, String status) {
		super();
		this.ticketId = ticketId;
		this.loggedBy = loggedBy;
		this.raisedDate = raisedDate;
		this.severity = severity;
		this.ticketDesc = ticketDesc;
		this.resolvedBy = resolvedBy;
		this.resolution = resolution;
		this.resolvedDate = resolvedDate;
		this.status = status;
	}
	
//	public Employee getEmployee() {
//		return employee;
//	}
//	public void setEmployee(Employee employee) {
//		this.employee = employee;
//	}
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public String getLoggedBy() {
		return loggedBy;
	}
	public void setLoggedBy(String loggedBy) {
		this.loggedBy = loggedBy;
	}
	public String getRaisedDate() {
		return raisedDate;
	}
	public void setRaisedDate(String raisedDate) {
		this.raisedDate = raisedDate;
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
	public String getResolution() {
		return resolution;
	}
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
	public String getResolvedDate() {
		return resolvedDate;
	}
	public void setResolvedDate(String resolvedDate) {
		this.resolvedDate = resolvedDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", loggedBy=" + loggedBy + ", raisedDate=" + raisedDate + ", severity="
				+ severity + ", ticketDesc=" + ticketDesc + ", resolvedBy=" + resolvedBy + ", resolution=" + resolution
				+ ", resolvedDate=" + resolvedDate + ", status=" + status + "]";
	}
	

}

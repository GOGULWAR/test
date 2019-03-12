package com.mindtree.ticket.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue
	@Column(name="MID", unique=true)
	private String mid;
	@Column
	private String employeeName;
	@Column
	private String hireDate;
	@Column
	private String dept;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Ticket>tickets;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String mid, String employeeName, String hireDate, String dept) {
		super();
		this.mid = mid;
		this.employeeName = employeeName;
		this.hireDate = hireDate;
		this.dept = dept;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getHireDate() {
		return hireDate;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public List<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	public void addTicket(Ticket theTicket) {
		if(tickets==null) {
			tickets=new ArrayList<>();
			}
		tickets.add(theTicket);
	}
	@Override
	public String toString() {
		return "Employee [mid=" + mid + ", employeeName=" + employeeName + ", hireDate=" + hireDate + ", dept=" + dept
				+ ", tickets=" + tickets + "]";
	}

	
}

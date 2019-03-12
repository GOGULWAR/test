package com.mindtree.ticket.dto;

public class EmployeeDto {

	int mid;
	String employeeName;
	String hireDate;
	public EmployeeDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeDto(int mid, String employeeName, String hireDate) {
		super();
		this.mid = mid;
		this.employeeName = employeeName;
		this.hireDate = hireDate;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
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
	@Override
	public String toString() {
		return "EmployeeDto [mid=" + mid + ", employeeName=" + employeeName + ", hireDate=" + hireDate + "]";
	}
	
}

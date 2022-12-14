package com.MGNREGA.model;

import java.sql.Date;

public class Employee {

	private int empId;
	private String empName;
	private Date joininDate;
	private int wages;
	private int projectId;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int empId, String empName, Date joininDate, int wages, int projectId) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.joininDate = joininDate;
		this.wages = wages;
		this.projectId = projectId;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", joininDate=" + joininDate + ", wages=" + wages
				+ ", projectId=" + projectId + "]";
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Date getJoininDate() {
		return joininDate;
	}

	public void setJoininDate(Date joininDate) {
		this.joininDate = joininDate;
	}

	public int getWages() {
		return wages;
	}

	public void setWages(int wages) {
		this.wages = wages;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
	
	
}

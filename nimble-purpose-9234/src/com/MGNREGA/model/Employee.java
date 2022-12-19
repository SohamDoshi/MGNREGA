package com.MGNREGA.model;

import java.sql.Date;

public class Employee {

	private int empId;
	private int gpmId;
	private int projectId;
	private String empName;
	private Date joininDate;
	private int wages;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int empId, int gpmId, int projectId, String empName, Date joininDate, int wages) {
		super();
		this.empId = empId;
		this.gpmId = gpmId;
		this.projectId = projectId;
		this.empName = empName;
		this.joininDate = joininDate;
		this.wages = wages;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", gpmId=" + gpmId + ", projectId=" + projectId + ", empName=" + empName
				+ ", joininDate=" + joininDate + ", wages=" + wages + "]";
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getGpmId() {
		return gpmId;
	}

	public void setGpmId(int gpmId) {
		this.gpmId = gpmId;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
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

	
	
	
}

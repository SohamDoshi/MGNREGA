package com.MGNREGA.model;

import java.sql.Date;

public class EmployeeDTO {

	private int eid;
	private String name;
	private int projectId;
	private String projectName;
	private Date joiningDate;
	private int noOfDays;
	private int wages;
	private int total;
	
	
	public EmployeeDTO() {
		// TODO Auto-generated constructor stub
	}


	public EmployeeDTO(int eid, String name, int projectId, String projectName, Date joiningDate, int noOfDays,
			int wages, int total) {
		super();
		this.eid = eid;
		this.name = name;
		this.projectId = projectId;
		this.projectName = projectName;
		this.joiningDate = joiningDate;
		this.noOfDays = noOfDays;
		this.wages = wages;
		this.total = total;
	}


	@Override
	public String toString() {
		return "EmployeeDTO [eid=" + eid + ", name=" + name + ", projectId=" + projectId + ", projectName="
				+ projectName + ", joiningDate=" + joiningDate + ", noOfDays=" + noOfDays + ", wages=" + wages
				+ ", total=" + total + "]";
	}


	public int getEid() {
		return eid;
	}


	public void setEid(int eid) {
		this.eid = eid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getProjectId() {
		return projectId;
	}


	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}


	public String getProjectName() {
		return projectName;
	}


	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	public Date getJoiningDate() {
		return joiningDate;
	}


	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}


	public int getNoOfDays() {
		return noOfDays;
	}


	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}


	public int getWages() {
		return wages;
	}


	public void setWages(int wages) {
		this.wages = wages;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	
	
	
	
}

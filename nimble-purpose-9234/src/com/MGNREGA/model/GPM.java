package com.MGNREGA.model;

public class GPM {
	
	private int gmpId;
	private String name;
	private String password;
	private int projectId;
	
	public GPM() {
		// TODO Auto-generated constructor stub
	}

	public GPM(int gmpId, String name, String password, int projectId) {
		super();
		this.gmpId = gmpId;
		this.name = name;
		this.password = password;
		this.projectId = projectId;
	}

	@Override
	public String toString() {
		return "GMP [gmpId=" + gmpId + ", name=" + name + ", password=" + password + ", projectId=" + projectId + "]";
	}

	public int getGmpId() {
		return gmpId;
	}

	public void setGmpId(int gmpId) {
		this.gmpId = gmpId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
	
	
}

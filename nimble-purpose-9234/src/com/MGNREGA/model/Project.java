package com.MGNREGA.model;

public class Project {

	private int projectId;
	private String projecName;
	private String projectDuration;
	
	public Project() {
		// TODO Auto-generated constructor stub
	}

	public Project(int projectId, String projecName, String projectDuration) {
		super();
		this.projectId = projectId;
		this.projecName = projecName;
		this.projectDuration = projectDuration;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projecName=" + projecName + ", projectDuration=" + projectDuration
				+ "]";
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjecName() {
		return projecName;
	}

	public void setProjecName(String projecName) {
		this.projecName = projecName;
	}

	public String getProjectDuration() {
		return projectDuration;
	}

	public void setProjectDuration(String projectDuration) {
		this.projectDuration = projectDuration;
	}
	
	
	
}

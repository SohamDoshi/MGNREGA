package com.MGNREGA.dao;

import java.util.List;

import com.MGNREGA.exception.BDOException;
import com.MGNREGA.exception.EmployeeException;
import com.MGNREGA.exception.GPMException;
import com.MGNREGA.exception.ProjectException;
import com.MGNREGA.model.Employee;
import com.MGNREGA.model.GPM;
import com.MGNREGA.model.Project;

public interface BDODao {

	public void BDOLogin()throws BDOException;
	
	public String CreateNewProject()throws ProjectException;
	
	public List<Project> ViewAllProjects()throws ProjectException;
	
	public String CreateNewGPM()throws GPMException;
	
	public List<GPM> ViewAllGPM()throws GPMException;
	
	public String AllocateProjectToGPM()throws ProjectException;
	
	public List<Employee> EmployeeWorkingOnProject()throws EmployeeException; 
}

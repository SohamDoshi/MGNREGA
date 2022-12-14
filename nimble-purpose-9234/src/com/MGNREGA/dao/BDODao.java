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

	public String BDOLogin(String username, String pass)throws BDOException;
	
	public String CreateNewProject(Project pro)throws ProjectException;
	
	public List<Project> ViewAllProjects()throws ProjectException;
	
	public String CreateNewGPM(GPM member)throws GPMException;
	
	public List<GPM> ViewAllGPM()throws GPMException;
	
	public String AllocateProjectToGPM(int GPMId, int ProjectId)throws ProjectException;
	
	public List<Employee> EmployeeWorkingOnProject(int ProjectId)throws EmployeeException; 
}

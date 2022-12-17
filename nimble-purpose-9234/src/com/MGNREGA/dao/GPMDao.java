package com.MGNREGA.dao;

import java.util.List;

import com.MGNREGA.exception.EmployeeException;
import com.MGNREGA.exception.GPMException;
import com.MGNREGA.model.Employee;
import com.MGNREGA.model.EmployeeDTO;

public interface GPMDao {

	public String GPMLogin()throws GPMException;
	
	public String CrateEmployee() throws EmployeeException; 
	
	public List<Employee> ViewDetailsOfEmployee()throws EmployeeException;
	
	public String AssignProjectToEmployee()throws EmployeeException;
	
	public List<EmployeeDTO> ViewTotalNumberOfDaysOnProjectAndWages ()throws EmployeeException;
}

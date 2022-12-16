package com.MGNREGA.dao;

import com.MGNREGA.exception.EmployeeException;
import com.MGNREGA.exception.GPMException;
import com.MGNREGA.model.Employee;

public interface GPMDao {

	public String GPMLogin()throws GPMException;
	
	public String CrateEmployee() throws EmployeeException; 
	
	public Employee ViewDetailsOfEmployee()throws EmployeeException;
	
	public String AssignProjectToEmployee()throws EmployeeException;
	
	public Employee ViewTotalNumberOfDaysOnProjectAndWages ()throws EmployeeException;
}

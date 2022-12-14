package com.MGNREGA.dao;

import com.MGNREGA.exception.EmployeeException;
import com.MGNREGA.exception.GPMException;
import com.MGNREGA.model.Employee;

public interface GPMDao {

	public String GPMLogin(int GPMId, String password)throws GPMException;
	
	public String CrateEmployee(Employee emp) throws EmployeeException; 
	
	public Employee ViewDetailsOfEmployee(int empId)throws EmployeeException;
	
	public String AssignProjectToEmployee(int empId, int projectId)throws EmployeeException;
	
	public Employee ViewTotalNumberOfDaysOnProjectAndWages (int empId)throws EmployeeException;
}

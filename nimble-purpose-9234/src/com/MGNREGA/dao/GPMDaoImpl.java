package com.MGNREGA.dao;

import com.MGNREGA.exception.EmployeeException;
import com.MGNREGA.exception.GPMException;
import com.MGNREGA.model.Employee;

public class GPMDaoImpl implements GPMDao{

	@Override
	public String GPMLogin(int GPMId, String password) throws GPMException {
		
		String res = "";
		
		return null;
	}

	@Override
	public String CrateEmployee(Employee emp) throws EmployeeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee ViewDetailsOfEmployee(int empId) throws EmployeeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String AssignProjectToEmployee(int empId, int projectId) throws EmployeeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee ViewTotalNumberOfDaysOnProjectAndWages(int empId) throws EmployeeException {
		// TODO Auto-generated method stub
		return null;
	}

	
}

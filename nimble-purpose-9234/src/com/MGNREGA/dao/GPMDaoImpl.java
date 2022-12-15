package com.MGNREGA.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.MGNREGA.exception.EmployeeException;
import com.MGNREGA.exception.GPMException;
import com.MGNREGA.model.Employee;
import com.MGNREGA.utility.DBUtil;

public class GPMDaoImpl implements GPMDao{

	@Override
	public String GPMLogin(int GPMId, String password) throws GPMException {
		
		String res = "Invaild GPMId or Password";
		
		try(Connection conn = DBUtil.proviodConnection()){
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM GPM WHERE GPMId=? AND password=?");
			
			ps.setInt(1, GPMId);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) res = "Login successful, Welcome Back "+rs.getString("name");
			
		}catch (SQLException e) {
			throw new GPMException(e.getMessage());
		}
		
		return res;
	}

	@Override
	public String CrateEmployee(Employee emp) throws EmployeeException {
		
		String res = "Employee is not added to records"; 
		
		try(Connection conn = DBUtil.proviodConnection()){
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Employee(empId,empname,joingDate,wages) VALUES(?,?,?,?)");
			
			ps.setInt(1, emp.getEmpId());
			ps.setString(2, emp.getEmpName());
			ps.setDate(3, emp.getJoininDate());
			ps.setInt(4, emp.getWages());
			
			int x = ps.executeUpdate();
			
			if(x > 0) res = "Employee is added to records with id "+emp.getEmpId();
			
		}catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		return res;
	}

	@Override
	public Employee ViewDetailsOfEmployee(int empId) throws EmployeeException {
		
		Employee emp = null;
		
		try(Connection conn = DBUtil.proviodConnection()){
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Employee WHERE empId=?");
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) emp = new Employee(rs.getInt("empId"), rs.getString("empName"), rs.getDate("joiningDate"), rs.getInt("wages"), rs.getInt("projectId"));
				
				
		}catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		
		return emp;
	}

	@Override
	public String AssignProjectToEmployee(int empId, int projectId) throws EmployeeException {
		
		String res  = "Project is not allocted to Employee"; 
		
		try(Connection conn = DBUtil.proviodConnection()){
			
			PreparedStatement ps = conn.prepareStatement("UPDATE Employee SET projectId=? WHERE empId=?");
			
			ps.setInt(1, projectId);
			ps.setInt(2, empId);
			
			int x  = ps.executeUpdate();
			
			if(x > 0) res = "Project is successfully allocated to Employee!";
			
		}catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		return res;
	}

	@Override
	public Employee ViewTotalNumberOfDaysOnProjectAndWages(int empId) throws EmployeeException {
		// TODO Auto-generated method stub
		return null;
	}

	
}

package com.MGNREGA.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

import javax.xml.crypto.Data;

import com.MGNREGA.exception.EmployeeException;
import com.MGNREGA.exception.GPMException;
import com.MGNREGA.model.Employee;
import com.MGNREGA.utility.DBUtil;

public class GPMDaoImpl implements GPMDao{

	@Override
	public String GPMLogin() throws GPMException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter GPMId");
		int GPMId = sc.nextInt();
		
		System.out.println("Enter Password");
		String pass = sc.next();
		
		String res = "Invaild GPMId or Password";
		
		try(Connection conn = DBUtil.proviodConnection()){
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM GPM WHERE GPMId=? AND password=?");
			
			ps.setInt(1, GPMId);
			ps.setString(2, pass);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) res = "Login successful, Welcome Back "+rs.getString("name");
			
		}catch (SQLException e) {
			throw new GPMException(e.getMessage());
		}
		
		return res;
	}

	@Override
	public String CrateEmployee() throws EmployeeException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter new EmpId");
		int id = sc.nextInt();
		
		System.out.println("Enter Employee Name");
		String name = sc.next();
		
		System.out.println("Enter Employee Joining Date[yyyy-mm-dd]");
		String jdate = sc.next();
		Date date = Date.valueOf(jdate);
		
		System.out.println("Enter Employee Wages[w/day]");
		int wages = sc.nextInt();
		
		
		
		String res = "Employee is not added to records"; 
		
		try(Connection conn = DBUtil.proviodConnection()){
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Employee(empId,empname,joingDate,wages) VALUES(?,?,?,?)");
			
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setDate(3, date);
			ps.setInt(4, wages);
			
			int x = ps.executeUpdate();
			
			if(x > 0) res = "Employee is added to records with id "+id;
			
		}catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		return res;
	}

	@Override
	public Employee ViewDetailsOfEmployee() throws EmployeeException {
		
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
	public String AssignProjectToEmployee() throws EmployeeException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Employee Id ");
		int id = sc.nextInt();
		
		System.out.println("Enter Project Id ");
		int pid = sc.nextInt();
		
		String res  = "Project is not allocted to Employee"; 
		
		try(Connection conn = DBUtil.proviodConnection()){
			
			PreparedStatement ps = conn.prepareStatement("UPDATE Employee SET projectId=? WHERE empId=?");
			
			ps.setInt(1,pid);
			ps.setInt(2, id);
			
			int x  = ps.executeUpdate();
			
			if(x > 0) res = "Project is successfully allocated to Employee!";
			
		}catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		return res;
	}

	@Override
	public Employee ViewTotalNumberOfDaysOnProjectAndWages() throws EmployeeException {
		// TODO Auto-generated method stub
		return null;
	}

	
}

package com.MGNREGA.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.MGNREGA.exception.BDOException;
import com.MGNREGA.exception.EmployeeException;
import com.MGNREGA.exception.GPMException;
import com.MGNREGA.exception.ProjectException;
import com.MGNREGA.model.Employee;
import com.MGNREGA.model.GPM;
import com.MGNREGA.model.Project;
import com.MGNREGA.usecases.BDOLoginUseCases;
import com.MGNREGA.utility.DBUtil;

public class BDODaoImpl implements BDODao{

	@Override
	public void BDOLogin() throws BDOException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Username");
		String user = sc.next();
		
		System.out.println("Enter password");
		String pass = sc.next();
		
		String res = "Invaild Username or Password";
		
		try(Connection conn = DBUtil.proviodConnection()){
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM BDO WHERE username=? AND password=?");
			
			ps.setString(1, user);
			ps.setString(2, pass);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				System.out.println("Welcome Back "+rs.getString("username"));
				System.out.println();
				BDOLoginUseCases.BDODashbord();
			}
			else {
				System.out.println(res);
				BDOLogin();
			}
		}catch (SQLException e) {
			throw new BDOException(e.getMessage());
		}
		
	}

	@Override
	public String CreateNewProject() throws ProjectException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Project ID");
		int id = sc.nextInt();
		
		System.out.println("Enter Project Name");
		String name = sc.next();
		
		System.out.println("Enter Project Duration");
		String dur = sc.next();
		
		String res = "Project creation Failed";
		
		try(Connection conn = DBUtil.proviodConnection()){
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Project VALUES(?,?,?)");
			
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, dur);
			
			int x = ps.executeUpdate();
			
			if(x > 0) res = "Project added to records successfully";
			
		}catch (SQLException e) {
			throw new ProjectException(e.getMessage());
		}
		
		return res;
	}

	@Override
	public List<Project> ViewAllProjects() throws ProjectException {
		
		List<Project> pro = new ArrayList<>();
		
		try(Connection conn = DBUtil.proviodConnection()){
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Project");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				pro.add(new Project(rs.getInt("projectId"), rs.getString("projectName"), rs.getString("projectDuration")));
			}
			
			
		}catch (SQLException e) {
			throw new ProjectException(e.getMessage());
		}
		
		return pro;
	}

	@Override
	public String CreateNewGPM() throws GPMException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter new GPM Id :");
		int id = sc.nextInt();
		
		System.out.println("Enter GPM name :");
		String name = sc.next();
		
		System.out.println("Enter Password");
		String pass = sc.next();
		
		String res = "GPM is not added to Records";
		
		try(Connection conn = DBUtil.proviodConnection()){
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO GPM(gpmId, name, password) VALUES(?,?,?)");
			
			ps.setInt(1,id);
			ps.setString(2, name);
			ps.setString(3, pass);
			
			int x = ps.executeUpdate();
			
			if(x > 0) res = "GPM Successfully added to records";
			
		}catch (SQLException e) {
			throw new GPMException(e.getMessage());
		}
		
		return res;
	}

	@Override
	public List<GPM> ViewAllGPM() throws GPMException {
		
		List<GPM> gpm = new ArrayList<>();
		
		try(Connection conn = DBUtil.proviodConnection()){
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM GPM");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				gpm.add(new GPM(rs.getInt("gpmId"), rs.getString("name"), rs.getString("password"), rs.getInt("projectID")));
			}
			
		}catch (SQLException e) {
			throw new GPMException(e.getMessage());
		}
		
		return gpm;
	}

	@Override
	public String AllocateProjectToGPM() throws ProjectException {
		
		Scanner sc = new Scanner(System.in);
	
		System.out.println("Enter GMP ID whom to project being allocated");
		int GPMId = sc.nextInt();
		
		System.out.println("Enter Project Id");
		int ProjectId = sc.nextInt();
		
		String res = "Project is not allocated to employee";
		
		try(Connection conn = DBUtil.proviodConnection()){
			
			PreparedStatement ps = conn.prepareStatement("UPDATE GPM SET projectId=? WHERE gpmId=?");
			
			ps.setInt(1, ProjectId);
			ps.setInt(2, GPMId);
			
			int x = ps.executeUpdate();
			
			if(x > 0) res = "Project is Successfully allocted to GPM with Id "+GPMId;
			
		}catch (SQLException e) {
			throw new ProjectException(e.getMessage());
		}
		
		return res;
	}

	@Override
	public List<Employee> EmployeeWorkingOnProject() throws EmployeeException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Project id :");
		int ProjectId = sc.nextInt();
		
		List<Employee> emp = new ArrayList<>();
		
		try(Connection conn = DBUtil.proviodConnection()){
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Employee WHERE projectId=?");
			
			ps.setInt(1, ProjectId);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
			}
			
		}catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		return emp;
	}

}

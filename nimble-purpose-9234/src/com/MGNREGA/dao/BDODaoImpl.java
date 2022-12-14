package com.MGNREGA.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.MGNREGA.exception.BDOException;
import com.MGNREGA.exception.EmployeeException;
import com.MGNREGA.exception.GPMException;
import com.MGNREGA.exception.ProjectException;
import com.MGNREGA.model.Employee;
import com.MGNREGA.model.GPM;
import com.MGNREGA.model.Project;
import com.MGNREGA.utility.DBUtil;

public class BDODaoImpl implements BDODao{

	@Override
	public String BDOLogin(String username, String pass) throws BDOException {
		
		String res = "Invaild Username or Password";
		
		try(Connection conn = DBUtil.proviodConnection()){
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM BDO WHERE username=? AND password=?");
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) res = "Welcome Back "+rs.getString("username");
			
		}catch (SQLException e) {
			throw new BDOException(e.getMessage());
		}
		
		return res;
	}

	@Override
	public String CreateNewProject(Project pro) throws ProjectException {
		
		String res = "Project creation Failed";
		
		try(Connection conn = DBUtil.proviodConnection()){
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Project VALUES(?,?,?)");
			
			ps.setInt(1, pro.getProjectId());
			ps.setString(2, pro.getProjecName());
			ps.setString(3, pro.getProjectDuration());
			
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
				pro.add(new Project(rs.getInt("projectId"), rs.getString("projectName"), rs.getString("projectDruation")));
			}
			
			
		}catch (SQLException e) {
			throw new ProjectException(e.getMessage());
		}
		
		return pro;
	}

	@Override
	public String CreateNewGPM(GPM member) throws GPMException {
		
		String res = "GPM is not added to Records";
		
		try(Connection conn = DBUtil.proviodConnection()){
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO GPM(gpmId, name, password) VALUES(?,?,?)");
			
			ps.setInt(1, member.getGmpId());
			ps.setString(2, member.getName());
			ps.setString(3, member.getPassword());
			
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
	public String AllocateProjectToGPM(int GPMId, int ProjectId) throws ProjectException {
		
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
	public List<Employee> EmployeeWorkingOnProject(int ProjectId) throws EmployeeException {
		
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

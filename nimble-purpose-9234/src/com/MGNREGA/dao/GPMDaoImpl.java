package com.MGNREGA.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.crypto.Data;

import com.MGNREGA.colors.ConsoleColor;
import com.MGNREGA.exception.EmployeeException;
import com.MGNREGA.exception.GPMException;
import com.MGNREGA.model.Employee;
import com.MGNREGA.model.EmployeeDTO;
import com.MGNREGA.usecases.GPMLoginUseCases;
import com.MGNREGA.utility.DBUtil;

public class GPMDaoImpl implements GPMDao{

	@Override
	public String GPMLogin() throws GPMException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println();
		System.out.println(ConsoleColor.BANANA_YELLOW_BOLD+"Enter GPMId"+ConsoleColor.RESET);
		int GPMId = sc.nextInt();
		
		System.out.println(ConsoleColor.BANANA_YELLOW_BOLD+"Enter Password"+ConsoleColor.RESET);
		String pass = sc.next();
		
		String res = ConsoleColor.RED_BOLD_BRIGHT+"Invaild GPMId or Password"+ConsoleColor.RESET;
		
		try(Connection conn = DBUtil.proviodConnection()){
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM GPM WHERE GPMId=? AND password=?");
			
			ps.setInt(1, GPMId);
			ps.setString(2, pass);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				System.out.println(ConsoleColor.LIGHT_GREEN+"Login successful, Welcome Back "+ConsoleColor.RESET+ConsoleColor.BANANA_YELLOW_BOLD+rs.getString("name")+ConsoleColor.RESET);
				System.out.println();
				GPMLoginUseCases.GPMDashbord();
			}else {
				System.out.println(res);
				GPMLogin();
			}
			
		}catch (SQLException e) {
			throw new GPMException(e.getMessage());
		}
		
		return res;
	}

	@Override
	public String CrateEmployee() throws EmployeeException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(ConsoleColor.BANANA_YELLOW_BOLD+"Enter new EmpId"+ConsoleColor.RESET);
		int id = sc.nextInt();
		
		System.out.println(ConsoleColor.BANANA_YELLOW_BOLD+"Enter Employee Name"+ConsoleColor.RESET);
		String name = sc.next();
		
		System.out.println(ConsoleColor.BANANA_YELLOW_BOLD+"Enter Employee Joining Date[yyyy-mm-dd]"+ConsoleColor.RESET);
		String jdate = sc.next();
		Date date = Date.valueOf(jdate);
		
		System.out.println(ConsoleColor.BANANA_YELLOW_BOLD+"Enter Employee Wages[w/day]"+ConsoleColor.RESET);
		int wages = sc.nextInt();
		
		
		
		String res = ConsoleColor.RED_BOLD_BRIGHT+"Employee is not added to records"+ConsoleColor.RESET; 
		
		try(Connection conn = DBUtil.proviodConnection()){
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Employee(empId,empname,joiningDate,wages) VALUES(?,?,?,?)");
			
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setDate(3, date);
			ps.setInt(4, wages);
			
			int x = ps.executeUpdate();
			
			if(x > 0) res = ConsoleColor.LIGHT_GREEN+"Employee is added to records with id - "+ConsoleColor.RESET+ConsoleColor.BANANA_YELLOW_BOLD+id+ConsoleColor.RESET;
			
		}catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		return res;
	}

	@Override
	public List<Employee> ViewDetailsOfEmployee() throws EmployeeException {
		
		List<Employee> emp = new ArrayList<>();
		
		
		try(Connection conn = DBUtil.proviodConnection()){
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Employee");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) 
				emp.add(new Employee(rs.getInt("empId"), rs.getString("empName"), rs.getDate("joiningDate"), rs.getInt("wages"), rs.getInt("projectId"))); 
				
				
		}catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		
		return emp;
	}

	@Override
	public String AssignProjectToEmployee() throws EmployeeException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(ConsoleColor.BANANA_YELLOW_BOLD+"Enter Employee Id "+ConsoleColor.RESET);
		int id = sc.nextInt();
		
		System.out.println(ConsoleColor.BANANA_YELLOW_BOLD+"Enter Project Id "+ConsoleColor.RESET);
		int pid = sc.nextInt();
		
		String res  = ConsoleColor.RED_BOLD_BRIGHT+"Project is not allocted to Employee"+ConsoleColor.RESET; 
		
		try(Connection conn = DBUtil.proviodConnection()){
			
			PreparedStatement ps = conn.prepareStatement("UPDATE Employee SET projectId=? WHERE empId=?");
			
			ps.setInt(1,pid);
			ps.setInt(2, id);
			
			int x  = ps.executeUpdate();
			
			if(x > 0) res = ConsoleColor.LIGHT_GREEN+"Project is successfully allocated to Employee!"+ConsoleColor.RESET;
			
		}catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		return res;
	}

	@Override
	public List<EmployeeDTO> ViewTotalNumberOfDaysOnProjectAndWages() throws EmployeeException {
		
		List<EmployeeDTO> emp = new ArrayList<>();
		
		try(Connection conn = DBUtil.proviodConnection()){
			
			PreparedStatement ps = conn.prepareStatement("SELECT e.empid, e.empName, e.projectid, p.projectName, e.joiningDate, DATEDIFF(CURDATE(),e.joiningDate) AS No_OF_Days,e.wages,DATEDIFF(CURDATE(),e.joiningDate)*e.wages AS Total_Wages FROM Employee e INNER JOIN Project p ON e.projectId = p.projectId GROUP BY e.empId;");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int eid = rs.getInt("empId");
				String ename = rs.getString("empName");
				int pid = rs.getInt("projectId");
				String pname = rs.getString("projectName");
				Date date = rs.getDate("joiningDate");
				int days = rs.getInt("No_OF_Days");
				int wage = rs.getInt("wages");
				int total = rs.getInt("Total_Wages");
				
				emp.add(new EmployeeDTO(eid, ename, pid, pname, date, days, wage, total));
			}
			
		}catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		return emp;
	}

	
}

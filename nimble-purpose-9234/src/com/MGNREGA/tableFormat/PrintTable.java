package com.MGNREGA.tableFormat;

import java.util.List;

import com.MGNREGA.model.Employee;
import com.MGNREGA.model.EmployeeDTO;
import com.MGNREGA.model.GPM;
import com.MGNREGA.model.Project;

public class PrintTable {

	public static void printProjectTable(List<Project> list) {
		System.out.println();
		System.out.println("------------------------- Project Table -------------------------");
		System.out.println();
		System.out.println("-----------------------------------------------------------------");
		System.out.printf("%5s %15s %15s","ID","NAME","DURATION");
		System.out.println();
		System.out.println("-----------------------------------------------------------------");
		
		for(Project p : list) {
			System.out.format("%5s %15s %15s",p.getProjectId(),p.getProjecName(),p.getProjectDuration());
			System.out.println();
		}
		System.out.println("-----------------------------------------------------------------");
	}
	
	public static void printGPMTable(List<GPM> list) {
		System.out.println();
		System.out.println("------------------------- Gram Panchayat Member Table -------------------------");
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------");
		System.out.printf("%5s %15s %15s %15s","ID","NAME","PASSWORD","PROJECT ID");
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------");
		
		for(GPM p : list) {
			System.out.format("%5s %15s %15s %15s",p.getGmpId(),p.getName(),p.getPassword(),p.getProjectId());
			System.out.println();
		}
		System.out.println("-------------------------------------------------------------------------------");
	}
	
	
	public static void printEmployeeTable(List<Employee> list) {
		System.out.println();
		System.out.println("------------------------ Employee Table -------------------------");
		System.out.println();
		System.out.println("-----------------------------------------------------------------");
		System.out.printf("%5s %10s %15s %10s %15s","ID","NAME","JOINING DATE","WAGES","PROJECT ID");
		System.out.println();
		System.out.println("-----------------------------------------------------------------");
		
		for(Employee p : list) {
			System.out.format("%5s %10s %15s %10s %10s",p.getEmpId(),p.getEmpName(),p.getJoininDate(),p.getWages(),p.getProjectId());
			System.out.println();
		}
		System.out.println("-----------------------------------------------------------------");
	}
	
	
	public static void printEmployeeWagesTable(List<EmployeeDTO> list) {
		System.out.println();
		System.out.println("              ---------------------------------- Employee Wages Table ----------------------------------");
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%5s %12s %15s %15s %15s %15s %18s %15s","ID","NAME","PROJECT ID","PROJECT NAME","JOINING DATE","NO. OF DAYS","WAGES[PER/DAY]","TOTAL WAGES");
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------------------------------------");
		
		for(EmployeeDTO p : list) {
			System.out.format("%5s %12s %11s %15s %19s %15s %15s %15s",p.getEid(),p.getName(),p.getProjectId(),p.getProjectName(),p.getJoiningDate(),p.getNoOfDays(),p.getWages(),p.getTotal());
			System.out.println();
		}
		System.out.println("------------------------------------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("*Note -> Total wages are calculted on joining date to current date");
		System.out.println();
	}
	
}

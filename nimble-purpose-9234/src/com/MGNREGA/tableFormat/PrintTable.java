package com.MGNREGA.tableFormat;

import java.util.List;

import com.MGNREGA.colors.ConsoleColor;
import com.MGNREGA.model.Employee;
import com.MGNREGA.model.EmployeeDTO;
import com.MGNREGA.model.GPM;
import com.MGNREGA.model.Project;

public class PrintTable {

	public static void printProjectTable(List<Project> list) {
		System.out.println();
		System.out.println(ConsoleColor.GREEN_BRIGHT+"   ------ "+ConsoleColor.RESET+ConsoleColor.GREEN_BACKGROUND+ConsoleColor.BANANA_YELLOW_BOLD+" Project Table "+ConsoleColor.RESET+ConsoleColor.GREEN_BRIGHT+" ------"+ConsoleColor.RESET);
		System.out.println();
		System.out.println(ConsoleColor.GREEN_BRIGHT+"----------------------------------------"+ConsoleColor.RESET);
		System.out.printf("%26s %10s %20s",ConsoleColor.BANANA_YELLOW_BOLD+"ID","NAME","DURATION"+ConsoleColor.RESET);
		System.out.println();
		System.out.println(ConsoleColor.GREEN_BRIGHT+"----------------------------------------"+ConsoleColor.RESET);
		
		for(Project p : list) {
			System.out.format("%5s %10s %15s",p.getProjectId(),p.getProjecName(),p.getProjectDuration());
			System.out.println();
		}
		System.out.println(ConsoleColor.GREEN_BRIGHT+"----------------------------------------"+ConsoleColor.RESET);
	}
	
	public static void printGPMTable(List<GPM> list) {
		System.out.println();
		System.out.println(ConsoleColor.GREEN_BRIGHT+"  ----- "+ConsoleColor.RESET+ConsoleColor.GREEN_BACKGROUND+ConsoleColor.BANANA_YELLOW_BOLD+" Gram Panchayat Member Table "+ConsoleColor.RESET+ConsoleColor.GREEN_BRIGHT+" -----"+ConsoleColor.RESET);
		System.out.println();
		System.out.println(ConsoleColor.GREEN_BRIGHT+"----------------------------------------------"+ConsoleColor.RESET);
		System.out.printf("%26s %10s %11s %17s",ConsoleColor.BANANA_YELLOW_BOLD+"ID","NAME","PASSWORD","PROJECT ID"+ConsoleColor.RESET);
		System.out.println();
		System.out.println(ConsoleColor.GREEN_BRIGHT+"----------------------------------------------"+ConsoleColor.RESET);
		
		for(GPM p : list) {
			System.out.format("%5s %10s %10s %10s",p.getGmpId(),p.getName(),p.getPassword(),p.getProjectId());
			System.out.println();
		}
		System.out.println(ConsoleColor.GREEN_BRIGHT+"----------------------------------------------"+ConsoleColor.RESET);
	}
	
	
	public static void printEmployeeTable(List<Employee> list) {
		System.out.println();
		System.out.println(ConsoleColor.GREEN_BRIGHT+"     ----------------- "+ConsoleColor.RESET+ConsoleColor.GREEN_BACKGROUND+ConsoleColor.BANANA_YELLOW_BOLD+" Employee Table "+ConsoleColor.RESET+ConsoleColor.GREEN_BRIGHT+" -----------------"+ConsoleColor.RESET);
		System.out.println();
		System.out.println(ConsoleColor.GREEN_BRIGHT+"-----------------------------------------------------------------"+ConsoleColor.RESET);
		System.out.printf("%26s %10s %17s %11s %20s",ConsoleColor.BANANA_YELLOW_BOLD+"ID","NAME","JOINING DATE","WAGES","PROJECT ID"+ConsoleColor.RESET);
		System.out.println();
		System.out.println(ConsoleColor.GREEN_BRIGHT+"-----------------------------------------------------------------"+ConsoleColor.RESET);
		
		for(Employee p : list) {
			System.out.format("%5s %10s %16s %10s %12s",p.getEmpId(),p.getEmpName(),p.getJoininDate(),p.getWages(),p.getProjectId());
			System.out.println();
		}
		System.out.println(ConsoleColor.GREEN_BRIGHT+"-----------------------------------------------------------------"+ConsoleColor.RESET);
	}
	
	
	public static void printEmployeeWagesTable(List<EmployeeDTO> list) {
		System.out.println();
		System.out.println(ConsoleColor.GREEN_BRIGHT+"             --------------------------------- "+ConsoleColor.RESET+ConsoleColor.GREEN_BACKGROUND+ConsoleColor.BANANA_YELLOW_BOLD+" Employee Wages Table "+ConsoleColor.RESET+ConsoleColor.GREEN_BRIGHT+" ---------------------------------"+ConsoleColor.RESET);
		System.out.println();
		System.out.println(ConsoleColor.GREEN_BRIGHT+"------------------------------------------------------------------------------------------------------------------------"+ConsoleColor.RESET);
		System.out.printf("%26s %12s %15s %15s %15s %15s %18s %18s",ConsoleColor.BANANA_YELLOW_BOLD+"ID","NAME","PROJECT ID","PROJECT NAME","JOINING DATE","NO. OF DAYS","WAGES[PER/DAY]","TOTAL WAGES"+ConsoleColor.RESET);
		System.out.println();
		System.out.println(ConsoleColor.GREEN_BRIGHT+"------------------------------------------------------------------------------------------------------------------------"+ConsoleColor.RESET);
		
		for(EmployeeDTO p : list) {
			System.out.format("%5s %12s %11s %15s %19s %13s %16s %16s",p.getEid(),p.getName(),p.getProjectId(),p.getProjectName(),p.getJoiningDate(),p.getNoOfDays(),p.getWages(),p.getTotal());
			System.out.println();
		}
		System.out.println(ConsoleColor.GREEN_BRIGHT+"------------------------------------------------------------------------------------------------------------------------"+ConsoleColor.RESET);
		System.out.println();
		System.out.println(ConsoleColor.BANANA_YELLOW_BOLD+"*Note ->"+ConsoleColor.RESET +" Total wages are calculted from joining date to current date");
		System.out.println();
	}
	
}

package com.MGNREGA.usecases;

import java.util.Scanner;

import com.MGNREGA.colors.ConsoleColor;
import com.MGNREGA.dao.GPMDao;
import com.MGNREGA.dao.GPMDaoImpl;
import com.MGNREGA.exception.EmployeeException;
import com.MGNREGA.main.Home;
import com.MGNREGA.tableFormat.PrintTable;

public class GPMLoginUseCases {

	
	public static void GPMDashbord() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println(ConsoleColor.BANANA_YELLOW_BOLD+"Enter option number to perform the following oprations"+ConsoleColor.RESET);
		System.out.println();
		System.out.println("1. Create an Employee");
		System.out.println("2. View the details of employee");
		System.out.println("3. Assign Employee to a Project");
		System.out.println("4. View total number of days Employee worked in a project and also their wages.");
		System.out.println("5. Logout");
		System.out.println();
		System.out.println(ConsoleColor.BANANA_YELLOW_BOLD+"Enter Option Number :"+ConsoleColor.RESET);
		
		int opt = sc.nextInt();
		while(opt < 0 || opt > 5) {
			System.out.println(ConsoleColor.BANANA_YELLOW_BOLD+"Enter vaild Option number"+ConsoleColor.RESET);
			opt = sc.nextInt();
		}
		
		
		GPMDao dao = new GPMDaoImpl();
		
		
		if(opt == 1) {
			try {
				System.out.println();
				System.out.println(dao.CrateEmployee());
			} catch (EmployeeException e) {
				System.out.println(ConsoleColor.RED_BOLD_BRIGHT+e.getMessage()+ConsoleColor.RESET);
			} finally {
				GPMDashbord();
			}
		}else if(opt == 2) {
			try {
				System.out.println();
				PrintTable.printEmployeeTable(dao.ViewDetailsOfEmployee());
			} catch (EmployeeException e) {
				System.out.println();
				System.out.println(ConsoleColor.RED_BOLD_BRIGHT+e.getMessage()+ConsoleColor.RESET);
			} finally {
				GPMDashbord();
			}
		}else if (opt == 3) {
			try {
				System.out.println();
				System.out.println(dao.AssignProjectToEmployee());
			} catch (EmployeeException e) {
				System.out.println();
				System.out.println(ConsoleColor.RED_BOLD_BRIGHT+e.getMessage()+ConsoleColor.RESET);
			} finally {
				GPMDashbord();
			}
		}else if(opt == 4) {
			try {
				System.out.println();
				PrintTable.printEmployeeWagesTable(dao.ViewTotalNumberOfDaysOnProjectAndWages());
			} catch (EmployeeException e) {
				System.out.println();
				System.out.println(ConsoleColor.RED_BOLD_BRIGHT+e.getMessage()+ConsoleColor.RESET);
			} finally {
				GPMDashbord();
			}
		}else if(opt == 5) {
			Home.HomePage();
		}
	}
}

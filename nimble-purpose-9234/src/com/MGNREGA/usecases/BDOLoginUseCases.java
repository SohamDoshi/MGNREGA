package com.MGNREGA.usecases;

import java.util.Scanner;

import com.MGNREGA.colors.ConsoleColor;
import com.MGNREGA.dao.BDODao;
import com.MGNREGA.dao.BDODaoImpl;
import com.MGNREGA.exception.EmployeeException;
import com.MGNREGA.exception.GPMException;
import com.MGNREGA.exception.ProjectException;
import com.MGNREGA.main.Home;
import com.MGNREGA.tableFormat.PrintTable;

public class BDOLoginUseCases {

	public static void BDODashbord() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println();
		System.out.println(ConsoleColor.BANANA_YELLOW_BOLD+"Enter option number to perform the following oprations"+ConsoleColor.RESET);
		System.out.println();
		System.out.println("1. Create new Project");
		System.out.println("2. View all Projects");
		System.out.println("3. Create new Gram Panchayat Member(GPM).");
		System.out.println("4. View all the GPM.");
		System.out.println("5. Allocate  Project to GPM");
		System.out.println("6. See List of Employee working on that Project and their wages.");
		System.out.println("7. Go Back");
		System.out.println();
		System.out.println(ConsoleColor.BANANA_YELLOW_BOLD+"Enter Option Number :"+ConsoleColor.RESET);
		
		
		int opt = sc.nextInt();
		
		while(opt < 0 || opt > 7) {
			System.out.println("Enter vaild Option number");
			opt = sc.nextInt();
		}
		
		BDODao dao = new BDODaoImpl();
		
		if(opt == 1) {
			try {
				System.out.println();
				System.out.println(dao.CreateNewProject());
			} catch (ProjectException e) {
				System.out.println();
				System.out.println(ConsoleColor.RED_BOLD_BRIGHT+e.getMessage()+ConsoleColor.RESET);
			} finally {
				BDODashbord();
			}
		}else if(opt == 2) {
			try {
				System.out.println();
				PrintTable.printProjectTable(dao.ViewAllProjects());  ;
			} catch (ProjectException e) {
				System.out.println();
				System.out.println(ConsoleColor.RED_BOLD_BRIGHT+e.getMessage()+ConsoleColor.RESET);
			} finally {
				BDODashbord();
			}
		}else if(opt == 3) {
			try {
				System.out.println();
				System.out.println(dao.CreateNewGPM());
			} catch (GPMException e) {
				System.out.println();
				System.out.println(ConsoleColor.RED_BOLD_BRIGHT+e.getMessage()+ConsoleColor.RESET);
			} finally {
				BDODashbord();
			}
		}else if(opt == 4) {
			try {
				System.out.println();
				PrintTable.printGPMTable(dao.ViewAllGPM());
			} catch (GPMException e) {
				System.out.println();
				System.out.println(ConsoleColor.RED_BOLD_BRIGHT+e.getMessage()+ConsoleColor.RESET);
			} finally {
				BDODashbord();
			}
		}else if(opt == 5) {
			try {
				System.out.println();
				System.out.println(dao.AllocateProjectToGPM());
			} catch (ProjectException e) {
				System.out.println();
				System.out.println(ConsoleColor.RED_BOLD_BRIGHT+e.getMessage()+ConsoleColor.RESET);
			} finally {
				BDODashbord();
			}
		}else if(opt == 6) {
			try {
				System.out.println();
				PrintTable.printEmployeeTable(dao.EmployeeWorkingOnProject());
			} catch (EmployeeException e) {
				System.out.println();
				System.out.println(ConsoleColor.RED_BOLD_BRIGHT+e.getMessage()+ConsoleColor.RESET);
			} finally {
				BDODashbord();
			}
		}else if(opt == 7) {
			Home.HomePage();
		}
	}
}

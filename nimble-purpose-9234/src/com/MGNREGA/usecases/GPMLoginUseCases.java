package com.MGNREGA.usecases;

import java.util.Scanner;

import com.MGNREGA.dao.GPMDao;
import com.MGNREGA.dao.GPMDaoImpl;
import com.MGNREGA.exception.EmployeeException;
import com.MGNREGA.main.Home;

public class GPMLoginUseCases {

	
	public static void GPMDashbord() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. Create an Employee");
		System.out.println("2. View the details of employee");
		System.out.println("3. Assign Employee to a Project");
		System.out.println("4. View total number of days Employee worked in a project and also their wages.");
		System.out.println("5. Go Back");
		
		int opt = sc.nextInt();
		while(opt < 0 || opt > 5) {
			System.out.println("Enter vaild Option number");
			opt = sc.nextInt();
		}
		
		
		GPMDao dao = new GPMDaoImpl();
		
		
		if(opt == 1) {
			try {
				System.out.println(dao.CrateEmployee());
			} catch (EmployeeException e) {
				System.out.println(e.getMessage());
			} finally {
				GPMDashbord();
			}
		}else if(opt == 2) {
			try {
				System.out.println(dao.ViewDetailsOfEmployee());
			} catch (EmployeeException e) {
				System.out.println(e.getMessage());
			} finally {
				GPMDashbord();
			}
		}else if (opt == 3) {
			try {
				System.out.println(dao.AssignProjectToEmployee());
			} catch (EmployeeException e) {
				System.out.println(e.getMessage());
			} finally {
				GPMDashbord();
			}
		}else if(opt == 4) {
			try {
				System.out.println(dao.ViewTotalNumberOfDaysOnProjectAndWages());
			} catch (EmployeeException e) {
				System.out.println(e.getMessage());
			} finally {
				GPMDashbord();
			}
		}else if(opt == 5) {
			Home.HomePage();
		}
	}
}

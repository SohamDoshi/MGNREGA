package com.MGNREGA.usecases;

import java.util.Scanner;

import com.MGNREGA.dao.BDODao;
import com.MGNREGA.dao.BDODaoImpl;
import com.MGNREGA.exception.EmployeeException;
import com.MGNREGA.exception.GPMException;
import com.MGNREGA.exception.ProjectException;
import com.MGNREGA.main.Home;

public class BDOLoginUseCases {

	public static void BDODashbord() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println();
		System.out.println("1. Create new Project");
		System.out.println("2. View all Projects");
		System.out.println("3. Create new Gram Panchayat Member(GPM).");
		System.out.println("4. View all the GPM.");
		System.out.println("5. Allocate  Project to GPM");
		System.out.println("6. See List of Employee working on that Project and their wages.");
		System.out.println("7. Go Back");
		
		
		int opt = sc.nextInt();
		
		BDODao dao = new BDODaoImpl();
		
		if(opt == 1) {
			try {
				System.out.println(dao.CreateNewProject());
			} catch (ProjectException e) {
				System.out.println(e.getMessage());
			} finally {
				BDODashbord();
			}
		}else if(opt == 2) {
			try {
				System.out.println(dao.ViewAllProjects());
			} catch (ProjectException e) {
				System.out.println(e.getMessage());
			} finally {
				BDODashbord();
			}
		}else if(opt == 3) {
			try {
				System.out.println(dao.CreateNewGPM());
			} catch (GPMException e) {
				System.out.println(e.getMessage());
			} finally {
				BDODashbord();
			}
		}else if(opt == 4) {
			try {
				System.out.println(dao.ViewAllGPM());
			} catch (GPMException e) {
				System.out.println(e.getMessage());
			} finally {
				BDODashbord();
			}
		}else if(opt == 5) {
			try {
				System.out.println(dao.AllocateProjectToGPM());
			} catch (ProjectException e) {
				System.out.println(e.getMessage());
			} finally {
				BDODashbord();
			}
		}else if(opt == 6) {
			try {
				System.out.println(dao.EmployeeWorkingOnProject());
			} catch (EmployeeException e) {
				System.out.println(e.getMessage());
			} finally {
				BDODashbord();
			}
		}else if(opt == 7) {
			Home.HomePage();
		}
	}
}

package com.MGNREGA.main;

import java.util.Scanner;

import com.MGNREGA.colors.ConsoleColor;
import com.MGNREGA.dao.BDODao;
import com.MGNREGA.dao.BDODaoImpl;
import com.MGNREGA.dao.GPMDao;
import com.MGNREGA.dao.GPMDaoImpl;
import com.MGNREGA.exception.BDOException;
import com.MGNREGA.exception.GPMException;

public class Home {

	public static void HomePage(){
		
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println(ConsoleColor.GREEN_BOLD_BRIGHT+"** Welcome to MNREGA(The Mahatma Gandhi National Rural Employment Guarantee Act)"+ConsoleColor.RESET);
		System.out.println(ConsoleColor.GREEN_BRIGHT+"(application version 1.5)"+ConsoleColor.RESET);
		System.out.println();
		System.out.println(ConsoleColor.BANANA_YELLOW_BOLD+"Select option number"+ConsoleColor.RESET);
		System.out.println();
		System.out.println("1. Login as BDO (Block Development Officer)");
		System.out.println("2. Login as GPM (Gram Panchayat Member)");
		System.out.println("3. Exit");
		System.out.println();
		System.out.println(ConsoleColor.BANANA_YELLOW_BOLD+"Enter option number :"+ConsoleColor.RESET);
		int opt = sc.nextInt();
		
		if(opt ==1) {
			BDODao dao = new BDODaoImpl();
			try {
				dao.BDOLogin();
			} catch (BDOException e) {
				System.out.println(e.getMessage());
			}
		}else if(opt == 2) {
			GPMDao dao = new GPMDaoImpl();
			try {
				dao.GPMLogin();
			} catch (GPMException e) {
				System.out.println(e.getMessage());
			}
		}else if(opt ==3) {
			System.out.println(ConsoleColor.GREEN_BOLD+"Application Closed!"+ConsoleColor.RESET);
			sc.close();
			System.exit(0);
		}
	}
}

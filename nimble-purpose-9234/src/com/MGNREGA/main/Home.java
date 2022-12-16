package com.MGNREGA.main;

import java.util.Scanner;

import com.MGNREGA.dao.BDODao;
import com.MGNREGA.dao.BDODaoImpl;
import com.MGNREGA.dao.GPMDao;
import com.MGNREGA.dao.GPMDaoImpl;
import com.MGNREGA.exception.BDOException;
import com.MGNREGA.exception.GPMException;

public class Home {

	public static void HomePage(){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to MGNREGA");
		System.out.println("select to login as BDO");
		System.out.println("2. Login as GPM");
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
		}
	}
}

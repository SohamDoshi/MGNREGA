package com.MGNREGA.main;

import java.util.Scanner;

import com.MGNREGA.dao.BDODao;
import com.MGNREGA.dao.BDODaoImpl;
import com.MGNREGA.exception.BDOException;

public class Home {

	public static void HomePage(){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to MGNREGA");
		System.out.println("select to login as BDO");
		int opt = sc.nextInt();
		
		if(opt ==1) {
			BDODao dao = new BDODaoImpl();
			try {
				dao.BDOLogin();
			} catch (BDOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}

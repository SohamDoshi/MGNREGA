package com.MGNREGA.utility;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtil {

	private static String url;
	private static String username;
	private static String password;
	
	
	static {
		
		ResourceBundle rb = ResourceBundle.getBundle("dbdetails");
		
		url = rb.getString("db.url");
		username = rb.getString("db.username");
		password = rb.getString("db.password");
	}
	
	
	public static Connection proviodConnection() {
		
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	} 
}

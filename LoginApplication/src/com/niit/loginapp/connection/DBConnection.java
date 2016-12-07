package com.niit.loginapp.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static String userName = "sa";
	private static String password = "";
	private static String url = "jdbc:h2:tcp://localhost/~/testDemo";
	private static String driver = "org.h2.Driver";
	
	private static Connection connection = null;
	
	public DBConnection() {
		// TODO Auto-generated constructor stub
	}
	
	public static Connection getConnection(){
		try {
			Class.forName(driver);
			System.out.println("Driver Loaded!");
			connection = DriverManager.getConnection(url, userName, password);
			System.out.println("Connection Established!");
		} catch (ClassNotFoundException e) {
		
			System.out.println("Class Not Found: "+e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQL Error: "+e.getMessage());
		}
		
		return connection;
	}
	public static void main(String[] args) {
		if(getConnection()==null){
			System.out.println("Could not established the connection");
		}else{
			System.out.println("Connection Successfully Established");
		}
	}
}

package com.niit.loginapp.userdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.niit.loginapp.connection.DBConnection;

public class UserDAO {
	
	private Connection con = null;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet = null;
	public boolean isValidUser (String userName, String password){
		//Get the db connection
		try {
			con = DBConnection.getConnection();
			String query = "SELECT * FROM users WHERE id = ? AND password = ?";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
			resultSet =  preparedStatement.executeQuery();			
			if(resultSet.next()){
				return true;
			}
		} catch (Exception e) {
			
		}finally{
			try {
				preparedStatement.close();
				resultSet.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return false;
		
	}
}

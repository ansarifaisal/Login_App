package com.niit.loginapp.userdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.niit.loginapp.connection.DBConnection;
import com.niit.loginapp.model.User;

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
	
	//Create, Retrieve, Update, Delete
	
	public User getUser(String id){
		con = DBConnection.getConnection();
		String query = "select * from users where id = ?";
		try{
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();
			User user;	
			if(resultSet.next()){
				user = new User();
				user.setId(resultSet.getString("id"));
				user.setPassword(resultSet.getString("password"));
				return user;
			}
		}catch(SQLException e){
			System.out.println("SQL Error: "+e.getMessage());
			}
		return null;
	}

	public List<User> getAllUsers(){
		List<User> users = new ArrayList<>();
		String query = "SELECT * FROM users";
		try {
			preparedStatement = con.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			User user;
			while(resultSet.next()){
				user = new User();
				user.setId(resultSet.getString("id"));
				user.setPassword(resultSet.getString("password"));
				users.add(user);
			}
			return users;
		} catch (SQLException e) {
			System.out.println("SQL Error: "+e.getMessage());
			return null;
		}
	}
	
}

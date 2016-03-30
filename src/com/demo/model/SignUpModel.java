package com.demo.model;

import java.sql.Statement;

public class SignUpModel {
	public String doSignUp(String username, String password, String gender, String vehicle, String country, String image) {
		try {
			DatabaseConnectivity databaseConnectivity = new DatabaseConnectivity();
			Statement statement = databaseConnectivity.doDBConnection();
			
			statement.execute("insert into user values('"+ username+"','"+password+"','"+gender+"','"+vehicle+"','"+country+"','"+image+"')");
			return "Sign Up Succesffuly...";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Something went wrong please try again!!!";
		}
	}
}

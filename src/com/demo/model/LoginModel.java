package com.demo.model;

import java.sql.ResultSet;
import java.sql.Statement;

public class LoginModel {

	public String doLoginProcess(String username, String password) {
		try {
			DatabaseConnectivity dConnectivity = new DatabaseConnectivity();
			Statement statement = dConnectivity.doDBConnection();

			ResultSet rs = statement.executeQuery(
					"select count(*) from user where username='" + username + "' and password = '" + password + "'");
			int count = 0;
			while (rs.next()) {
				count = rs.getInt(1);
			}
			rs.close();
			if (count == 1) {
				return "login success";
			} else {
				return "username or password does not match";
			}
		} catch (Exception e) {
			// TODO: handle exception
			return "Something went wrong... Please try agian!!";
		}
	}
}

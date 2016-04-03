package com.demo.model;

import java.sql.Statement;
import java.util.List;

import org.hibernate.Session;

import com.demo.pojo.User;

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
	
	public String doHibernateSigup(User user) {
		try {
			Session session = HibernateConnection.doHibernateConnection().openSession();
			session.beginTransaction();
			session.save(user);
			
			// hibernate will do this session depend on primary key
			//session.update(user); //update user
			//session.delete(user); //delete user
			
			// insert, update, delete multiple user by using List of User
			List<User> users = null;
			session.save(users);
			
			//this if no user > save, else update user depend of primary key
			//session.saveOrUpdate(user);
			
			session.getTransaction().commit();
			session.close();
			return "Sign Up Seccessfully...";
			
		} catch (Exception e) {
			// TODO: handle exception
			return "User is already there with this username";
		}
	}
}

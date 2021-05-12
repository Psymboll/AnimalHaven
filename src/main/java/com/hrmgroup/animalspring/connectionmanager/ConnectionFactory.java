package com.hrmgroup.animalspring.connectionmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionFactory 
{
	private static ConnectionFactory instance = null;
	
	public static synchronized ConnectionFactory getInstance()
	{
		if(instance==null)
			instance = new ConnectionFactory();
		return instance;
		
	}
	
	
	private ConnectionFactory()
	
	{		
		
	}
	
	public Connection make()
	{
	
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Congrats - Seems your MySQL JDBC Driver Registered!");
		} 
		catch (ClassNotFoundException e) 
		{
			System.out.println("Sorry, couldn't found JDBC driver. Make sure you have added JDBC Maven Dependency Correctly");
			e.printStackTrace();
			return null;
		}
	
		try 
		{		
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/animal", "root", "Blackdiamond52@!");
			if (connection != null) 
			{
				System.out.println("Connection Successful! Enjoy. Now it's time to push data");
				return connection;
			} 
			else 
			{
				System.out.println("Failed to make connection!");
				return null;
			}
		}
		catch (SQLException e) 
		{
			System.out.println("MySQL Connection Failed!");
			e.printStackTrace();
			return null;
		}
	}
	}


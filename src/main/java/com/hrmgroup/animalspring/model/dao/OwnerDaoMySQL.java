package com.hrmgroup.animalspring.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hrmgroup.animalspring.connectionmanager.ConnectionFactory;
import com.hrmgroup.animalspring.entities.Animal;
import com.hrmgroup.animalspring.entities.Owner;

public class OwnerDaoMySQL implements OwnerDao
{

	Connection ownerConn;
	PreparedStatement ownerPrepareStat;	
 
	
	public OwnerDaoMySQL() 
	{
		
		this.ownerConn = ConnectionFactory.getInstance().make();
		
	}




	@Override
	public void save(Owner owner) throws SQLException 
	{
 
		try 
		{
			String insertQueryStatement = "INSERT  INTO  owner  VALUES  (?,?,?,?)";
			
			ownerPrepareStat = ownerConn.prepareStatement(insertQueryStatement);
			ownerPrepareStat.setInt(1,0);
			ownerPrepareStat.setString(2,owner.getUsername() );
			ownerPrepareStat.setString(3, owner.getPassword());
			ownerPrepareStat.setString(4, owner.getEmail());
		
		
 
			
			ownerPrepareStat.executeUpdate();
			
			
		} 
		catch 
		(SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			ownerPrepareStat.close();
		}
	}
 
	
	
	
	@Override
	public List<Owner> load() 
	{
		
		try 
		{
			
			String getQueryStatement = "SELECT * FROM owner";
 
			ownerPrepareStat = ownerConn.prepareStatement(getQueryStatement);
 
			
			ResultSet rs = ownerPrepareStat.executeQuery();
			
			List<Owner> res = new ArrayList<>();
			
			while (rs.next()) 
			{
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String email = rs.getString("email");
				
			
				Owner owner = new Owner(id,username,password,email);
				
				res.add(owner);
			}
			ownerPrepareStat.close();
			
			return res;
 
		} 
		catch 
		(SQLException e) 
		{
			e.printStackTrace();
			return null;
		}
		
	
	}
	
	@Override
	public Owner read(int idToFind) throws SQLException 
	{
		
		String queryStatement = "select * from owner where id =? ";
		ownerPrepareStat = ownerConn.prepareStatement(queryStatement);
		ownerPrepareStat.setInt(1, idToFind);
		ResultSet rs = ownerPrepareStat.executeQuery();
		Owner owner = new Owner();
		while (rs.next()) 
		{
			int id = rs.getInt("id");
			String username = rs.getString("username");
			String password = rs.getString("password");
			String email = rs.getString("email");
				
			owner.setId(id);
			owner.setEmail(email);
			owner.setPassword(password);
			owner.setUsername(username);
			
		
			
			
		}
		ownerPrepareStat.close();
		return owner;
		
		
		
	}
	

	@Override
	public void delete(int id) throws SQLException 
	{
		
		
		try 
		{
			String deleteStatement = "DELETE * from owner where id = ?";
			ownerPrepareStat = ownerConn.prepareStatement(deleteStatement);
			ownerPrepareStat.setInt(1, id);
			ownerPrepareStat.executeUpdate();
			ownerPrepareStat.close();
			
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			ownerPrepareStat.close();
		}
		
	}




	@Override
	public Owner find(String emailToFind, String passwordToFind) throws SQLException 
	{
		String searchStatement = "select * from owner where email= ? and password = ? ";
		
		ownerPrepareStat = ownerConn.prepareStatement(searchStatement);
		ownerPrepareStat.setString(1, emailToFind);
		ownerPrepareStat.setString(2, passwordToFind);
		
		ResultSet rs = ownerPrepareStat.executeQuery();
		Owner owner = new Owner();
		while (rs.next()) 
		{
			int id = rs.getInt("id");
			String username = rs.getString("username");
			String password = rs.getString("password");
			String email = rs.getString("email");
				
			owner.setId(id);
			owner.setEmail(email);
			owner.setPassword(password);
			owner.setUsername(username);
			
		
			
			
		}
		ownerPrepareStat.close();
		return owner;
		
		
		
		
		
	}
	
	
	
}

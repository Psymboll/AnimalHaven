package com.hrmgroup.animalspring.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hrmgroup.animalspring.connectionmanager.ConnectionFactory;
import com.hrmgroup.animalspring.entities.Animal;
import com.hrmgroup.animalspring.entities.Owner;

public class AnimalDaoMySQL implements AnimalDao
{

	Connection animalConn;
	PreparedStatement animalPrepareStat;
	
 
	
 
	
	public AnimalDaoMySQL() 
	{
		
		this.animalConn = ConnectionFactory.getInstance().make();
		
	}




	@Override
	public void save(Animal animal) throws SQLException 
	{
 
		try 
		{
			String insertQueryStatement = "INSERT  INTO  animal  VALUES  (?,?,?,?,?)";
			
			animalPrepareStat = animalConn.prepareStatement(insertQueryStatement);
			animalPrepareStat.setInt(1,0);
			animalPrepareStat.setString(2,animal.getAnimalname() );
			animalPrepareStat.setInt(3, animal.getAnimalage());
			animalPrepareStat.setString(4, animal.getAnimaltype());
			animalPrepareStat.setInt(5, animal.getOwner().getId());
		
 
			
			animalPrepareStat.executeUpdate();
			animalPrepareStat.close();
			
		} 
		catch 
		(SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			animalPrepareStat.close();
		}
	}
 
	
	
	
	@Override
	public List<Animal> load() throws SQLException 
	{
		
		try 
		{
			
			String getQueryStatement = "SELECT * FROM animal inner join owner on animal.ownerid = owner.id";
 
			animalPrepareStat = animalConn.prepareStatement(getQueryStatement);
			
		
			
			
			ResultSet rs = animalPrepareStat.executeQuery();
		
			List<Animal> res = new ArrayList<>();
			
			while (rs.next()) 
			{
				int id = rs.getInt("animal.id");
				String animalname = rs.getString("animalname");
				int animalage = rs.getInt("animalage");
				String animaltype = rs.getString("animaltype");
				
				int ownerid = rs.getInt("owner.id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String email = rs.getString("email");
				
			
				Owner owner = new Owner(ownerid,username,email,password);
				Animal newanimal = new Animal(id,animalname,animalage,animaltype,owner);
				res.add(newanimal);
			}
			
			return res;
 
		} 
		catch 
		(SQLException e) 
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			animalPrepareStat.close();
		}
	
	}
	
	
	@Override
	public void delete(int id) throws SQLException 
	{
		
		
		try 
		{
			String deleteStatement = "DELETE * from animal where id = ?";
			animalPrepareStat = animalConn.prepareStatement(deleteStatement);
			animalPrepareStat.setInt(1,id);
			animalPrepareStat.executeUpdate();
			animalPrepareStat.close();
			
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			animalPrepareStat.close();
		}
		
		
	}




	@Override
	public List<Animal> load(String animalType) throws SQLException 
	{
		try 
		{
			
			String getQueryStatement = "SELECT * FROM animal inner join owner on animal.ownerid = owner.id where animal.animaltype = ?";
 
			animalPrepareStat = animalConn.prepareStatement(getQueryStatement);
			animalPrepareStat.setString(1,animalType );
		
			
			
			ResultSet rs = animalPrepareStat.executeQuery();
		
			List<Animal> res = new ArrayList<>();
			
			while (rs.next()) 
			{
				int id = rs.getInt("animal.id");
				String animalname = rs.getString("animalname");
				int animalage = rs.getInt("animalage");
				String animaltype = rs.getString("animaltype");
				
				int ownerid = rs.getInt("owner.id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String email = rs.getString("email");
				
			
				Owner owner = new Owner(ownerid,username,email,password);
				Animal newanimal = new Animal(id,animalname,animalage,animaltype,owner);
				res.add(newanimal);
			}
			
			return res;
 
		} 
		catch 
		(SQLException e) 
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			animalPrepareStat.close();
		}
	}




	@Override
	public List<String> loadAllAnimalTypes() throws SQLException 
	{
		String preparedStat = "select * from animaltypes";
		animalPrepareStat = animalConn.prepareStatement(preparedStat);
		
		ResultSet rs = animalPrepareStat.executeQuery();
		List<String> animalTypes = new ArrayList<>();
		while(rs.next())
		{
			String animalType = rs.getString("animaltype");
			animalTypes.add(animalType);
		}
		rs.close();
		return animalTypes;
	}




	
	
	
	
}

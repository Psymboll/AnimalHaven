package com.hrmgroup.animalspring.bl;

import java.sql.Connection;

import com.hrmgroup.animalspring.connectionmanager.ConnectionFactory;
import com.hrmgroup.animalspring.model.dao.AnimalDao;
import com.hrmgroup.animalspring.model.dao.AnimalDaoMySQL;
import com.hrmgroup.animalspring.model.dao.OwnerDao;
import com.hrmgroup.animalspring.model.dao.OwnerDaoMySQL;

public class AnimalDBBLFactory 
{

	public static AnimalDBBL make()
	{
	
		
		OwnerDao ownerDao = new OwnerDaoMySQL();
		AnimalDao animalDao = new AnimalDaoMySQL();
		
		return new AnimalDBBLMySQL(animalDao,ownerDao);
		
		
	}
	
	
	
}

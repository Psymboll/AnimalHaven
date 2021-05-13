package com.hrmgroup.animalspring.model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.hrmgroup.animalspring.connectionmanager.ConnectionFactory;
import com.hrmgroup.animalspring.entities.Animal;



class AnimalDaoTest {
	
	static AnimalDao dao;

	@BeforeAll
	static void setUpBeforeClass() throws Exception 
	{
		dao = new AnimalDaoMySQL();
	}
	

	@Test
	void testLoadFilter() throws SQLException 
	{
		List<Animal> res = dao.load("Cat");
		System.out.println(res);
		if(res.size()!=1)
		{
			System.out.println(res);
			fail("Not yet implemented");
		}
			
	}
	
	
	@Test
	void testLoadAnimalTypes() throws SQLException 
	{
		List<String> res = dao.loadAllAnimalTypes();
		System.out.println(res);
		if(res.size()!=6)
		{
			System.out.println(res);
			fail("Not yet implemented");
		}
			
	}
}
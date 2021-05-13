package com.hrmgroup.animalspring.bl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hrmgroup.animalspring.entities.Animal;
import com.hrmgroup.animalspring.entities.Owner;
import com.hrmgroup.animalspring.model.dao.AnimalDao;
import com.hrmgroup.animalspring.model.dao.OwnerDao;

public class AnimalDBBLMySQL implements AnimalDBBL
{
	AnimalDao animalDao;
	OwnerDao ownerDao;
	
	
	
	
	public AnimalDBBLMySQL(AnimalDao animalDao, OwnerDao ownerDao) 
	{
		super();
		this.animalDao = animalDao;
		this.ownerDao = ownerDao;
	}

	@Override
	public Owner login(String email, String password) throws SQLException 
	{
		return ownerDao.find(email, password);
	}

	@Override
	public void register(Owner owner) throws SQLException 
	{
		ownerDao.save(owner);
		
	}

	@Override
	public void saveAnimal(Animal animal) throws SQLException 
	{
		animalDao.save(animal);
		
	}

	@Override
	public List<Animal> loadAnimals(String filter) throws SQLException 
	{
		return filter.isBlank() ? animalDao.load() : animalDao.load(filter);
	}

	

	@Override
	public void deleteOwner(int id) throws SQLException 
	{
		ownerDao.delete(id);
		
	}

	
	
	
	@Override
	public List<Owner> prettyList() throws SQLException 
	{
		
		List<Owner> prettyList = new LinkedList<>();
		for(Owner o : ownerDao.load())
		{	
			for(Animal a : animalDao.load())
				if(a.getOwner().equals(o))	
					o.addAnimal(a);
			if(!o.getAnimals().isEmpty())
				prettyList.add(o);
		}	
		return prettyList;
	}

	@Override
	public List<Animal> loadAnimalByOwner(Owner owner) throws SQLException 
	{
		List<Animal> ownedAnimals = new ArrayList<>();
		for(Animal a : animalDao.load())
			if(a.getOwner().equals(owner))
					ownedAnimals.add(a);
		return ownedAnimals;
	}

	@Override
	public Owner findOwner(int id) throws SQLException 
	{
		
		return ownerDao.read(id);
	}

	@Override
	public List<String> getAllAnimalTypes() throws SQLException 
	{
		
		return animalDao.loadAllAnimalTypes();
	}

}

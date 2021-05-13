package com.hrmgroup.animalspring.bl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hrmgroup.animalspring.entities.Animal;
import com.hrmgroup.animalspring.entities.Owner;

public interface AnimalDBBL 
{

	Owner login ( String email,String password) throws SQLException;
	Owner findOwner(int id) throws SQLException;
	void register(Owner owner) throws SQLException ;
	void saveAnimal(Animal animal) throws SQLException ;
	List<Animal> loadAnimals(String filter) throws SQLException ;

	void deleteOwner(int id) throws SQLException ;
	List<Owner> prettyList() throws SQLException ;
	List<Animal> loadAnimalByOwner(Owner owner) throws SQLException ;
	
	List<String> getAllAnimalTypes() throws SQLException;
	
	
	
	
}

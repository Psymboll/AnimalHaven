package com.hrmgroup.animalspring.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.hrmgroup.animalspring.entities.Animal;
import com.hrmgroup.animalspring.entities.Owner;

public interface AnimalDao 
{

	void save(Animal animal) throws SQLException ;
	List<Animal> load() throws SQLException ;
	List<Animal> load(String filter) throws SQLException ;
	
	void delete(int id) throws SQLException ;
	List<String> loadAllAnimalTypes() throws SQLException;
	
}

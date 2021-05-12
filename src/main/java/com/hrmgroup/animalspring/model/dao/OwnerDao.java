package com.hrmgroup.animalspring.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.hrmgroup.animalspring.entities.Owner;
import com.mysql.jdbc.PreparedStatement;

public interface OwnerDao 
{

	void save(Owner owner) throws SQLException;
	
	List<Owner> load();
	
	Owner find(String email,String password)throws SQLException ;
	
	
	Owner read (int id) throws SQLException;
	void delete(int id) throws SQLException ;
	
}

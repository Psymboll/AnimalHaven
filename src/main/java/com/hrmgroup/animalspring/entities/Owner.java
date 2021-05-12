package com.hrmgroup.animalspring.entities;

import java.util.ArrayList;
import java.util.List;

public class Owner 
{
	
	public static Owner GUEST = new Owner ( -1,"GUEST",null,null);
	private int id;
	private String username;
	private String email;
	private String password;
	
	private List<Animal> animals = new ArrayList<>();


	
	public Owner(int id, String username, String email, String password) 
	{
		
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		
	}

	public Owner()
	{
		
	}
	
	@Override
	public String toString() {
		return "Owner [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + "]";
	}

	public Owner(String username, String email, String password) 
	{
	
		this.username = username;
		this.email = email;
		this.password = password;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() 
	{
		return username;
	}

	public void setUsername(String username) 
	{
		this.username = username;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public List<Animal> getAnimals() 
	{
		return animals;
	}

	public void setAnimals(List<Animal> animals) 
	{
		this.animals = animals;
	}
	

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	
	
	public void addAnimal(Animal animal)
	{
		
		animals.add(animal);
		
		
	}
	
	public boolean isGuest()
	{
		if(this.getUsername().equals("GUEST") && this.getEmail()==null)
			return true;
		return false;
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Owner other = (Owner) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	public Boolean isEmpty()
	{
		return (username==null || password==null || email==null );
	}
	
	
	
	
}

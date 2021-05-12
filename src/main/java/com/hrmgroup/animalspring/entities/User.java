package com.hrmgroup.animalspring.entities;

public class User 
{
	private Owner loggeduser;
	
	private String test;
	
	public User()
	{
		loggeduser = Owner.GUEST;
		test = "user is present";
	}

	
	
	public Owner getLoggeduser() 
	{
		return loggeduser;
	}



	public void setLoggeduser(Owner loggeduser) 
	{
		this.loggeduser = loggeduser;
	}



	public String getTest() 
	{
		return test;
	}



	public void setTest(String test) 
	{
		this.test = test;
	}



	public boolean isGuest()
	{
		if(loggeduser.getUsername().equals("GUEST") && loggeduser.getEmail()==null)
			return true;
		return false;
		
	}
	
}

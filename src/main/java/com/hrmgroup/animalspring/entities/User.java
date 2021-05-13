package com.hrmgroup.animalspring.entities;

public class User 
{
	private Owner loggeduser;
	
	
	public User()
	{
		loggeduser = Owner.GUEST;
		
	}

	
	
	public Owner getLoggeduser() 
	{
		return loggeduser;
	}



	public void setLoggeduser(Owner loggeduser) 
	{
		this.loggeduser = loggeduser;
	}



	


	public boolean isGuest()
	{
		if(loggeduser.getUsername().equals("GUEST") && loggeduser.getEmail()==null)
			return true;
		return false;
		
	}
	
}

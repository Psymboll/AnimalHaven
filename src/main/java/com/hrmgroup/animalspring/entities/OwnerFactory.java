package com.hrmgroup.animalspring.entities;
import static com.hrmgroup.util.ValidityChecker.*;

import java.util.Map;

public class OwnerFactory 
{

	public static Owner make ( Map<String,String> map) throws Exception
	{
		String username = isNotNull(map.get("username"));
		String password1 = isNotNull(map.get("password1"));
		String password2 = isNotNull(map.get("password2"));
		String email = isNotNull(map.get("email"));
		
		if(password1.equals(password2))
			throw new Exception("the passwords do not match");
		
		Owner owner = new Owner(username,email,password1);
		return owner;
	}
	
}

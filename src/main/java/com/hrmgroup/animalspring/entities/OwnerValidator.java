package com.hrmgroup.animalspring.entities;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class OwnerValidator implements Validator
{

	@Override
	public boolean supports(Class<?> clazz) 
	{
		// TODO Auto-generated method stub
		return Owner.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) 
	{
		Owner owner = (Owner) target;
		
		if(owner.getId()==0 || owner.getEmail()==null || owner.getPassword()==null || owner.getUsername()==null)
			errors.reject("owner.failedLogin");
		
	}

}

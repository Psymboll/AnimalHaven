package com.hrmgroup.animalspring.entities;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class AnimalValidator implements Validator
{

	@Override
	public boolean supports(Class<?> clazz) 
	{
		// TODO Auto-generated method stub
		return Animal.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) 
	{
		Animal animal= (Animal) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "animalname", "animalName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "animalage", "animalAge.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "animaltype", "animalType.required");
		
		int age = animal.getAnimalage();
		
		if(age<=0 || age >100)
			errors.rejectValue("animalage","animalAge.invalid");
		//avrebbe senso qui usare la bl per determinare che l'id dell'utente debba corrispondere ad un oggetto presente nel database?
		if(animal.getOwner().getId()==0)
			errors.reject("ownerId.notFound");
			// TODO Auto-generated method stub
		
	}

}

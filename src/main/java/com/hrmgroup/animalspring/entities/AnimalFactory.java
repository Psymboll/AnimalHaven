package com.hrmgroup.animalspring.entities;

import java.util.Map;
import static com.hrmgroup.util.ValidityChecker.*;

public class AnimalFactory 
{

	public  static Animal make (Map<String,String> map,Owner owner)
	{
		
			
			String animalname = isNotNull(map.get("animalname"));
			int animalage = safeParsing(map.get("animalage"));
			String animaltype = isNotNull(map.get("animaltype"));
		
			if(animalage<=0)
				throw new RuntimeException("the age is not valid");
			
			Animal newAnimal = new Animal();
			newAnimal.setAnimalname(animalname);
			newAnimal.setAnimalage(animalage);
			newAnimal.setAnimaltype(animaltype);
			newAnimal.setOwner(owner);
			
			return newAnimal;
			
		
			
	
		
		
	}
}


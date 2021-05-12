package com.hrmgroup.animalspring.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.hrmgroup.animalspring.bl.AnimalDBBL;
import com.hrmgroup.animalspring.bl.AnimalDBBLFactory;
import com.hrmgroup.animalspring.entities.User;
import com.hrmgroup.animalspring.entities.Owner;


@Component
public class Beans 
{

	@Bean
	public AnimalDBBL getBL()
	{
		return AnimalDBBLFactory.make();
	}
	
	@Bean
	@SessionScope
	public User getUser()
	{
		return new User();
	}
	
	
}

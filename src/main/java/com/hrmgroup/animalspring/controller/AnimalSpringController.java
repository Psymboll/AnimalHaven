package com.hrmgroup.animalspring.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


import com.hrmgroup.animalspring.bl.AnimalDBBL;
import com.hrmgroup.animalspring.entities.User;
import com.hrmgroup.animalspring.entities.Animal;
import com.hrmgroup.animalspring.entities.AnimalValidator;
import com.hrmgroup.animalspring.entities.Owner;
import com.hrmgroup.animalspring.entities.OwnerValidator;

@Controller
@SessionAttributes("user")
public class AnimalSpringController 
{
	//TODO
	//IMPLEMENTARE REDIRECT CON TUTTI I METODI CHE SALVANO SUL DB fatto
	//CAPIRE COME USARE ORGANICAMENTE LE FORM DI SPRING PER GESTIRE GLI ERRORI fatto
	//HTML  usare label for e fieldset per sistemare la visualizzazione della pagina vedi anche table per renderizzare una lista fatto
	//usare tag select e option di spring bene fatto
	//jscript resa dinamica degli errori, checkbox show password. 
	
	@Autowired
	AnimalDBBL bl;
	
	@Autowired
	User loggedUser;
	
	@Autowired
	AnimalValidator av;
	
	@Autowired
	OwnerValidator ov;
	
	@ModelAttribute("user")
	public User loggedUserAttribute()
	{
		return loggedUser;	
	}
	
	
	
	
	@ModelAttribute("animalTypes")
	public List<String> animalTypes()
	{
		try 
		{
			return bl.getAllAnimalTypes();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	@RequestMapping(value = {"","/","/index"}, method = RequestMethod.GET)
	public String MainPage (@ModelAttribute("animaltype") String animaltype,Model model)
	{
		//model.addAttribute("user",loggedUser.getUser());
		return "mainpage";
	}

	@RequestMapping("search")
	public String SearchFunction (@ModelAttribute("animaltype")String animalType, Model model) throws SQLException
	{
		//model.addAttribute("user",loggedUser.getUser());
		List<Animal> animals = bl.loadAnimals(animalType);
		model.addAttribute("animals",animals);
		return animals.isEmpty() ? "noresults" : "animallist";
		
		
	}
	
	@RequestMapping("formlogin")
	public String LoginRedirect ( @ModelAttribute("logginguser") Owner loggingUser,Model model)
	{
		//forse da combinare con il metodo che fa login vero e proprio
		//model.addAttribute("user",loggedUser.getUser());
		return "formlogin";
	}
	
	@RequestMapping("login")
	public String Login (@ModelAttribute("newanimal") Animal newanimal, @ModelAttribute("logginguser") Owner loggingUser,BindingResult br,Model model)
	{
		Owner user = new Owner();
		try
		{
			System.out.println(loggingUser.getEmail());
			System.out.println(loggingUser.getPassword());
			
			
			user = bl.login(loggingUser.getEmail(),loggingUser.getPassword());
			System.out.println(user);
		}
		catch(SQLException e )
		{
			e.getMessage();
		}
		ov.validate(user, br);
			if(br.hasErrors())
			{
				//loggedUser.setLoggeduser(Owner.GUEST);
				return "formlogin";
			}	
				
				loggedUser.setLoggeduser(user);
			
			//model.addAttribute("user",loggedUser.getUser());
			model.addAttribute("profileOwner",loggedUser.getLoggeduser());
			try 
			{
				model.addAttribute("ownedAnimals",bl.loadAnimalByOwner(user));
			} 
			catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
			//in teoria si può mantere così, però la stessa jsp è mappata con due combinazioni diverse, forse non è da fare
			return "profile";
	}

	
	@RequestMapping("logout")
	public String Logout(Model model)
	{
		loggedUser.setLoggeduser(Owner.GUEST);
		//model.addAttribute("user",loggedUser.getUser());
		return "mainpage";
		
		
	}
	
	@RequestMapping("register")
	public String registerUser(Model model)
	{
		model.addAttribute("newuser",new Owner());
		return "formnewuser";
	}
	
	
	@RequestMapping("saveuser")
	public String saveUser(@Valid @ModelAttribute("newuser") Owner newUser, BindingResult br, Model model)
	{
	
			if(br.hasErrors())
				return "formnewuser";
			Owner savedUser = new Owner();
			try 
			{
				bl.register(newUser);
				savedUser = bl.login(newUser.getEmail(), newUser.getPassword());
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			loggedUser.setLoggeduser(savedUser);
			
			return "redirect:/profile/"+ savedUser.getId();
			//model.addAttribute("profileOwner",savedUser);
			//return "profile";
			
		}
		
	
	
	@RequestMapping(value="savenewanimal", method = RequestMethod.POST)
	public String saveAnimal(@ModelAttribute("newanimal") Animal newAnimal,BindingResult br,Model model)
	{
		List<Animal> animalList = new ArrayList<>();
		av.validate(newAnimal, br);
		if(br.hasErrors())
		{	
			model.addAttribute("profileOwner",loggedUser.getLoggeduser());
			
			
			try 
			{
				model.addAttribute("ownedAnimals",bl.loadAnimalByOwner(loggedUser.getLoggeduser()));
			} 
			catch (SQLException e) 
			{
				
				e.printStackTrace();
			
			}
			return "profile";
		}	
		try
		{
		bl.saveAnimal(newAnimal);
		 animalList = bl.loadAnimalByOwner(loggedUser.getLoggeduser());
		}
		catch(SQLException e)
		{
			e.getMessage();
		}
		
		model.addAttribute("profileOwner",newAnimal.getOwner());
		model.addAttribute("ownedAnimals",animalList);
		return "redirect:/profile/"+ loggedUser.getLoggeduser().getId();
		
	}
	
	@RequestMapping("/profile/{userid}")
	public String goToProfile( @ModelAttribute("newanimal") Animal newanimal,@PathVariable("userid") int userid,Model model)
	{
		try
		{
			 Owner profileOwner = bl.findOwner(userid);
			
			 model.addAttribute("profileOwner",profileOwner);
			 model.addAttribute("ownedAnimals",bl.loadAnimalByOwner(profileOwner));
			 return "profile";
		}
		catch(Exception e)
		{
			e.getMessage();
			return null;
		}
		
	}

	public AnimalDBBL getBl() 
	{
		return bl;
	}

	public void setBl(AnimalDBBL bl) 
	{
		this.bl = bl;
	}

	public User getLoggedUser() 
	{
		return loggedUser;
	}

	public void setLoggedUser(User loggedUser) 
	{
		this.loggedUser = loggedUser;
	}




	public AnimalValidator getAv() {
		return av;
	}




	public void setAv(AnimalValidator av) {
		this.av = av;
	}




	public OwnerValidator getOv() {
		return ov;
	}




	public void setOv(OwnerValidator ov) {
		this.ov = ov;
	}
	
	
	
}

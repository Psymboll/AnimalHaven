package com.hrmgroup.animalspring.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hrmgroup.animalspring.bl.AnimalDBBL;
import com.hrmgroup.animalspring.entities.User;
import com.hrmgroup.animalspring.entities.Animal;
import com.hrmgroup.animalspring.entities.Owner;

@Controller
@SessionAttributes("user")
public class AnimalSpringController 
{
	//TODO
	//IMPLEMENTARE REDIRECT CON TUTTI I METODI CHE SALVANO SUL DB
	//CAPIRE COME USARE ORGANICAMENTE LE FORM DI SPRING PER GESTIRE GLI ERRORI
	//HTML  usare label for e fieldset per sistemare la visualizzazione della pagina
	//usare tag select e option di spring bene
	//jscript resa dinamica degli errori, checkbox show password. vedi anche table per renderizzare una lista
	
	@Autowired
	AnimalDBBL bl;
	
	@Autowired
	User loggedUser;
	
	
	@ModelAttribute("user")
	public User loggedUserAttribute()
	{
		return loggedUser;	
	}
	
	
	@RequestMapping(value = {"","/","/index"}, method = RequestMethod.GET)
	public String MainPage (Model model)
	{
		//model.addAttribute("user",loggedUser.getUser());
		return "mainpage";
	}

	@RequestMapping("search")
	public String SearchFunction (@RequestParam("animaltype")String animalType, Model model) throws SQLException
	{
		//model.addAttribute("user",loggedUser.getUser());
		model.addAttribute("animals",bl.loadAnimals(animalType));
		return "animallist";
		
		
	}
	
	@RequestMapping("formlogin")
	public String LoginRedirect (Model model)
	{
		//forse da combinare con il metodo che fa login vero e proprio
		//model.addAttribute("user",loggedUser.getUser());
		return "formlogin";
	}
	
	@RequestMapping("login")
	public String Login (@ModelAttribute("newanimal") Animal newanimal,@RequestParam("email") String email,@RequestParam("password") String password,Model model)
	{
		Owner user = new Owner();
		try
		{
			user = bl.login(email, password);
		}
		catch(SQLException e )
		{
			e.getMessage();
		}
			if(user !=null)
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
			return "profile";
	}

	
	@RequestMapping("logout")
	public String Logout(Model model)
	{
		loggedUser.setLoggeduser(Owner.GUEST);
		//model.addAttribute("user",loggedUser.getUser());
		return "mainpage";
		
		
	}
	
	
	
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("newuser") Owner newUser,Model model)
	{
		if(newUser.isEmpty())
			return "formnewuser";
		else
		{
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
			model.addAttribute("profileOwner",savedUser);
			return "profile";
			
		}
		
	}
	
	@RequestMapping(value="savenewanimal", method = RequestMethod.POST)
	public String saveAnimal(@ModelAttribute("newanimal") Animal newAnimal,Model model)
	{
		List<Animal> animalList = new ArrayList<>();
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
		return "profile";
		
	}
	
	@RequestMapping("profile")
	public String goToProfile(@RequestParam("userid") int userid,Model model)
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
	
	
	
}

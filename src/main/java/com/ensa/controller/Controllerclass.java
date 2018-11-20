package com.ensa.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ensa.dao.ShopRepository;
import com.ensa.dao.UserRepository;
import com.ensa.entities.Shop;
import com.ensa.entities.User;



@RestController
@SessionAttributes("user")
public class Controllerclass {
	
	@Autowired 
	private UserRepository userrepository;

	@Autowired 
	private ShopRepository shoprepository;
	
	
	  @RequestMapping("/")
	  public ModelAndView home() {
		ModelAndView modelandview = new ModelAndView();
		modelandview.setViewName("index");
		return modelandview;
	    }
	  
	 @RequestMapping(value="/registration")
     public ModelAndView reg(){
	    ModelAndView modelandview = new ModelAndView();
		modelandview.setViewName("register");
		return modelandview;
			}
	  
	 @GetMapping("/user/{EmailID}")
	 public Object getUser(@PathVariable String EmailID){
		return userrepository.findById(EmailID);
		}
	 
	 @PostMapping("/user")
	 public User CreateUser(@RequestBody User user){
	    return userrepository.save(user);
		}
	 
	 @RequestMapping(value="/adduser")
	 public ModelAndView adduser(@RequestParam("nom") String nom,
				                 @RequestParam("prenom") String prenom ,
				                 @RequestParam("login") String login,
				                 @RequestParam("password") String password){
		
		 ModelAndView modelandview = new ModelAndView();
		 User user=new User(login, nom, prenom, password);
		 userrepository.save(user);
		 List<Shop> l=shoprepository.findAll();
		 modelandview.addObject("user", user);
		 modelandview.addObject("lshop", l);
	     modelandview.setViewName("InterfaceClient");
		 return modelandview;
			} 
	 
	 @RequestMapping(value="/chechuser")
		public ModelAndView authentification(@RequestParam("email") String login,@RequestParam("password") String password){
	    ModelAndView modelandview;
	    ModelAndView modelandview1;	    
	    if(userrepository.existsById(login)) {
	    	User user=userrepository.getOne(login);
	      if(user.getPassword().equals(password)) {
	        modelandview= new ModelAndView();
		    modelandview.setViewName("InterfaceClient");
			modelandview.addObject("user", user);
			return modelandview;
		   }
	      else { 
	    	modelandview1= new ModelAndView();
	 	    modelandview1.setViewName("index");
		    return modelandview1;
	       }
			
	    }
	    else {
	    	modelandview1= new ModelAndView();
	 	    modelandview1.setViewName("index");
		    return modelandview1;
	    }}
}

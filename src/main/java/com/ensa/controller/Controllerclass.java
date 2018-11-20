package com.ensa.controller;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ensa.dao.ShopRepository;
import com.ensa.dao.UserRepository;
import com.ensa.dao.User_Shop_Repositoiry;
import com.ensa.entities.Shop;
import com.ensa.entities.User;
import com.ensa.entities.User_Shop;





@RestController
@SessionAttributes("user")
public class Controllerclass {
	
	@Autowired 
	private UserRepository userrepository;

	@Autowired 
	private ShopRepository shoprepository;
	
	@Autowired 
	private User_Shop_Repositoiry u_sh_repository;
	
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
		    List<Shop> l=shoprepository.findAll();
			modelandview.addObject("lshop", l);
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
	 

		@RequestMapping(value="/Add_to_mypreferred")
		public ModelAndView addtomypreferred(@SessionAttribute("user") User user,@RequestParam("idp") int id){
		User_Shop u_sh=new User_Shop();
		Shop shop=shoprepository.getOne(id);
		u_sh.setDescription("add to my favorite");
		u_sh.getPk().setShop(shop);
		u_sh.getPk().setUser(user);
		u_sh_repository.save(u_sh);
	    ModelAndView modelandview = new ModelAndView();
	    modelandview.setViewName("InterfaceClient");
	    List<Shop> l=shoprepository.findAll();
		modelandview.addObject("lshop", l);
		modelandview.addObject("user",user);
		return modelandview;
			}
		

		@RequestMapping(value="/back")
		public ModelAndView back(@SessionAttribute("user") User user){
	    ModelAndView modelandview = new ModelAndView();
		modelandview.addObject("lshop",shoprepository.findAll());
		modelandview.addObject("user",user);
		modelandview.setViewName("InterfaceClient");
		return modelandview;
		}

		@RequestMapping(value="/mypreferred")
		public ModelAndView myfavorite(@SessionAttribute("user") User user){
	    List<User_Shop>lp = new ArrayList();
	    ModelAndView modelandview = new ModelAndView();
	    List<User_Shop>l =u_sh_repository.findAll();
	    for(User_Shop lc : l) {
	    	if(lc.getPk().getUser().getLogin().equals(user.getLogin())) {
	    		lp.add(lc);
	    	}
	    }
		modelandview.addObject("lshop",lp);
		modelandview.addObject("user",user);
		modelandview.setViewName("Mypreferred");
		return modelandview;
			}
		
		
		@RequestMapping(value="/deletefavorite")
		public ModelAndView delete(@SessionAttribute("user") User user,@RequestParam("id") int id){
	    ModelAndView modelandview = new ModelAndView();
	    
	    for(User_Shop lc : u_sh_repository.findAll()) {
	    	if(lc.getPk().getUser().getLogin().equals(user.getLogin())
	    			&& lc.getPk().getShop().getIdshop()==id) {
	    		u_sh_repository.delete(lc);
	    	}
	    }
	    
		modelandview.addObject("lshop",shoprepository.findAll());
		modelandview.addObject("user",user);
		modelandview.setViewName("InterfaceClient");
		return modelandview;
		}
}

package com.ensa.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity 
@Table(name="User_Shop") 
public class User_Shop {

	@Id
	private User_Shop_PK pk; 
	private String description;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User_Shop() {
		pk=new User_Shop_PK();
	} 
	public User_Shop(Shop shop, User user,String description) { 
		this.pk = new User_Shop_PK(shop,user); 
		this.description=description;}
	
	@Transient
	public User getUser() {
		return pk.getUser();
	}
	@Transient
	public Shop getShop() {
		return pk.getShop();
	}
	public User_Shop_PK getPk() {
		return pk;
	}
	public void setPk(User_Shop_PK pk) {
		this.pk = pk;
	}

	
	
	
	
}

package com.ensa.entities;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class User_Shop_PK implements Serializable {


	private static final long serialVersionUID = 1L;
	@ManyToOne 
	@JoinColumn(name="login_user") 
	private  User user; 
	@ManyToOne 
	@JoinColumn(name="id") 
	private Shop shop; 

	public User_Shop_PK(Shop shop, User user) {
		super();
		this.shop = shop;
		this.user = user;
	}
	public User_Shop_PK() {
		super();
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	

	
	
	
	
}

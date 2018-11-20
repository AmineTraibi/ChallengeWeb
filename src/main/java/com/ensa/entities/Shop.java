package com.ensa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shop")
public class Shop {

	@Id  
	@Column(name="id") 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idshop; 
	@Column(name="Nom_shop", length=30) 
	private String nom_shop;
	
	public Shop(String nom_shop) {
		super();
		this.nom_shop = nom_shop;
	}
	
	public Shop() {
		super();
	}

	public long getIdshop() {
		return idshop;
	}
	public void setIdshop(long idshop) {
		this.idshop = idshop;
	}
	public String getNom_shop() {
		return nom_shop;
	}
	public void setNom_shop(String nom_shop) {
		this.nom_shop = nom_shop;
	}

	
	
}

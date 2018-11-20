package com.ensa.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="user")
public class User {

	@Id  
	@Column(name="login_user") 
	private String login; 
	@Column(name="Nom", length=30) 
	private String nom; 
	@Column(name="Prenom", length=30) 
	private String prenom; 
	@Column(name="password", length=30) 
	private String password;
	public User(String login, String nom, String prenom, String password) {
		super();
		this.login = login;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
	}
	public User() {
		super();
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(mappedBy="pk.user")
	private List<User_Shop>cnt;
	
	public List<User_Shop> getCnt() {
		return cnt;
	}
	public void setCnt(List<User_Shop> cnt) {
		this.cnt = cnt;
	}
	
	
}

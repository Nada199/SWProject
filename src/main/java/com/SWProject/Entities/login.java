package com.SWProject.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class login {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    //private Integer id;
	//private String name;
	private String email;
	private String password;
	
	public login()
	{
		email="";
		password="";
	}
	
	public login(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}

package com.SWProject.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Store {
	@Id	 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private String Storeid;
	private String location;
	private String type;
	
	public Store() {
		id=0;
		name="";
		Storeid="";
		location="";
		type="";
	}

	public Store(Integer id, String name, String storeid, String location, String type) {
		super();
		this.id = id;
		this.name = name;
		Storeid = storeid;
		this.location = location;
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStoreid() {
		return Storeid;
	}

	public void setStoreid(String storeid) {
		Storeid = storeid;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

}

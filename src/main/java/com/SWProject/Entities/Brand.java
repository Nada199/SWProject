package com.SWProject.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Brand {
	
	@Id	 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private String Brandid;
	private String category;
	
	public Brand()
	{
		id=0;
		name="";
		Brandid="";
		category="";
	}
	
	

	public Brand(Integer id, String name, String brandid, String category) {
		super();
		this.id = id;
		this.name = name;
		this.Brandid = brandid;
		this.category = category;
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

	public String getBrandid() {
		return Brandid;
	}

	public void setBrandid(String brandid) {
		Brandid = brandid;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
	

}

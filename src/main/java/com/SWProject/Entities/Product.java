package com.SWProject.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	@Id	 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private String Productid;
	private String category;
	private String type;
	private double price;
	private Integer amount;

	//protected Brand brand;




	public Integer getAmount() {
		return amount;
	}


	public void setAmount(Integer amount) {
		this.amount = amount;
	}


	public Product() {
		super();
		id = 0;
		name="";
		Productid = "";
		price = 0.0;
		category="";
		type="";
amount =0;
		//brand=new Brand();
		}
	
	
	public Product(Integer id, String name, String productid, String category, String type, double price,int amount) {
		super();
		this.id = id;
		this.name = name;
		Productid = productid;
		this.category = category;
		this.type = type;
		this.price = price;
		this.amount=amount;
		//this.brand = brand;
	}


	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



/*	public Brand getBrand() {
		return brand;
	}



	public void setBrand(Brand brand) {
		this.brand = brand;
	}
*/

	
	

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
	public String getProductid() {
		return Productid;
	}
	public void setProductid(String productid) {
		Productid = productid;
	}
	

}

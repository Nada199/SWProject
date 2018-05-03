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
	private String action;
	private String offer;

	//protected Brand brand;


	public Product() {
		super();
		id = 0;
		name="";
		Productid = "";
		price = 0.0;
		category="";
		type="";
        amount =0;
        action="";
        offer="";
		//brand=new Brand();
		}

	public Product(Integer id, String name, String productid, String category, String type, double price,
			Integer amount, String action, String offer) {
		super();
		this.id = id;
		this.name = name;
		Productid = productid;
		this.category = category;
		this.type = type;
		this.price = price;
		this.amount = amount;
		this.action = action;
		this.offer = offer;
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

	public String getProductid() {
		return Productid;
	}

	public void setProductid(String productid) {
		Productid = productid;
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

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getOffer() {
		return offer;
	}

	public void setOffer(String offer) {
		this.offer = offer;
	}

	
}

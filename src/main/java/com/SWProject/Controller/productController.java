package com.SWProject.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.SWProject.Entities.Product;
import com.SWProject.Repository.ProductRepository;

import antlr.collections.List;

@Controller
public class productController {
	@Autowired
	private ProductRepository repo;
	
	@GetMapping("/addProduct")
	public String addProduct(Model model) {
		model.addAttribute("Product", new Product());
		return "addProduct";
	}
	
	

	@PostMapping("/addProduct")
	public String addNewProduct(Model model,@ModelAttribute Product product) {
		product.setAction("added");
		repo.save(product);
		model.addAttribute("Product", new Product());
		return "addProduct";
	}
	
	@GetMapping("/home")
	public String showAllProduct(Model model)
	{
		Iterable<Product>productiterable=repo.findAll();
		ArrayList<Product> productlist =new ArrayList<Product>();
		for(Product product:productiterable)
		{
			productlist.add(product);
		}
		model.addAttribute("products", productlist);
		return "home";
	}
	
	@GetMapping("/ShowActionOfProduct")
	public String showAllProduct1(Model model)
	{
		Iterable<Product>productiterable=repo.findAll();
		ArrayList<Product> productlist =new ArrayList<Product>();
		for(Product product:productiterable)
		{
			productlist.add(product);
		}
		model.addAttribute("products", productlist);
		return "ShowActionOfProduct";
	}
	
	@GetMapping("/EditProduct")
	public String EditProduct(Model model)
	{
		model.addAttribute("Product", new Product());
		return "EditProduct";
	}
	
	@PostMapping("/EditProduct")
	public String EditProduct1(Model model,@ModelAttribute Product product)
	{
		Iterable<Product>getProducts=repo.findAll();
		  for(Product product1:getProducts)
		  {
			  if(product.getProductid().equals(product1.getProductid()))
			  {
				  repo.delete(product1);
				  product.setAction("edit");
				  repo.save(product);
				  model.addAttribute("Product", new Product());
			  }
		  }
		  
		return "EditProduct";
	}
	
	@GetMapping("/DeleteProduct")
	public String DeleteProduct(Model model)
	{
		model.addAttribute("Product", new Product());
		return "DeleteProduct";
	}
	
	@PostMapping("/DeleteProduct")
	public String DeleteProduct(Model model,@ModelAttribute Product product)
	{
		Iterable<Product>getProducts=repo.findAll();
		  for(Product product1:getProducts)
		  {
			  if(product.getProductid().equals(product1.getProductid()))
			  {
				  product1.setAction("Deleted");
				  repo.save(product1);
				  model.addAttribute("Product", new Product());
			  }
		  } 
		return "DeleteProduct";
	}
	
	@GetMapping("/addOffer")
	public String addOffer(Model model)
	{
		model.addAttribute("Product", new Product());
		return "addOffer";
	}
	@PostMapping("/addOffer")
	public String addOffer1(Model model,@ModelAttribute Product product)
	{
		Iterable<Product>getProducts=repo.findAll();
		  for(Product product1:getProducts)
		  {
			  if(product.getProductid().equals(product1.getProductid()))
			  {
				  product1.setOffer(product.getOffer());
				  repo.save(product1);
				  model.addAttribute("Product", new Product());
			  }
		  } 
		return "addOffer";
	}
	
	@GetMapping("/editOffer")
	public String editOffer(Model model)
	{
		model.addAttribute("Product", new Product());
		return "editOffer";
	}
	@PostMapping("/editOffer")
	public String editOffer1(Model model,@ModelAttribute Product product)
	{
		Iterable<Product>getProducts=repo.findAll();
		  for(Product product1:getProducts)
		  {
			  if(product.getProductid().equals(product1.getProductid()))
			  {
				  product1.setOffer(product.getOffer());
				  repo.save(product1);
				  model.addAttribute("Product", new Product());
			  }
		  } 
		return "editOffer";
	}
	
	@GetMapping("/deleteOffer")
	public String deleteOffer(Model model)
	{
		model.addAttribute("Product", new Product());
		return "deleteOffer";
	}
	@PostMapping("/deleteOffer")
	public String deleteOffer1(Model model,@ModelAttribute Product product)
	{
		Iterable<Product>getProducts=repo.findAll();
		  for(Product product1:getProducts)
		  {
			  if(product.getProductid().equals(product1.getProductid()))
			  {
				  product1.setOffer("");
				  repo.save(product1);
				  model.addAttribute("Product", new Product());
			  }
		  } 
		return "deleteOffer";
	}
	


}

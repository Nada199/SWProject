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

}

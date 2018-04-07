package com.SWProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.SWProject.Entities.Brand;
import com.SWProject.Repository.BrandRepository;


@Controller
public class BrandController {
	@Autowired
	private BrandRepository repo;
	
	@GetMapping("/addBrand")
	public String addBrand(Model model) {
		model.addAttribute("Brand", new Brand());
		return "addBrand";
	}
	
	@PostMapping("/addBrand")
	public String addNewProduct(Model model,@ModelAttribute Brand brand) {
		
		repo.save(brand);
		model.addAttribute("Brand", new Brand());


		return "addBrand";
	}
	
	
	
	
	

}

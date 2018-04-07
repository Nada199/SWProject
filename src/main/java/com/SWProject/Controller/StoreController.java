package com.SWProject.Controller;

import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.SWProject.Entities.Store;
import com.SWProject.Repository.StoreRepository;

@Controller
public class StoreController {
	@Autowired
	private StoreRepository repo;
	
	@GetMapping("/addStore")
	public String addstore(Model model) {
		model.addAttribute("store", new Store());
		return "addStore";
	}

	@PostMapping("/addStore")
	public String addNewStore(Model model,@ModelAttribute Store store) {
		repo.save(store);
		model.addAttribute("store", new Store());
		return "addStore";
	}

}



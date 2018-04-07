package com.SWProject.Controller;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.SWProject.Entities.Product;
import com.SWProject.Entities.User;
import com.SWProject.Repository.ProductRepository;
import com.SWProject.Repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository repo;
	
	@GetMapping("/addUser")
	public String showaddUserForm(Model model) {
		model.addAttribute("user", new User());
		return "addUser";
	} 
	
	@PostMapping("/addUser")
	public String addUser(Model model,@ModelAttribute User user ) {
		
		repo.save(user);
		model.addAttribute("user", new User());
		if( user.getType().equals("Customer")) {
		   return"/home";
		}
		else if(user.getType().equals("StoreOwner"))
		{
			return"/homeStoreowner";
		}
		else if(user.getType().equals("Admin"))
		{
			return"/homeAdmin";
		}
		return "addUser";
	}

	@RequestMapping(value="/buy",method= RequestMethod.GET)
	public String getproduct(@RequestParam("id") String id )
	
	{
		System.out.println("ID = " + id);
		return "home";
		//localhost:8080/home?id=2
	}

	
}

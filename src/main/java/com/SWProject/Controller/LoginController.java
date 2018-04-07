package com.SWProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.SWProject.Entities.User;
import com.SWProject.Repository.UserRepository;


@Controller
public class LoginController {
	
	@Autowired
	private UserRepository repo;
	
	@GetMapping("/Login")
	public String showget(Model model) {
		model.addAttribute("user", new User());
		return "Login";
	}
	
	@PostMapping("/Login")
	public String LoginPost(Model model,@ModelAttribute User user)
	{
	  Iterable<User>getUsers=repo.findAll();
	  for(User user1:getUsers)
	  {
	  if(user1.getEmail().equals(user.getEmail())&&user1.getPassword().equals(user.getPassword())&&user1.getType().equals("Customer"))
	    {
		return "/home";
		}
	    else if(user1.getEmail().equals(user.getEmail())&&user1.getPassword().equals(user.getPassword())&&user1.getType().equals("StoreOwner"))
		{
		return "/homeStoreowner";
		}
		else if(user1.getEmail().equals(user.getEmail())&&user1.getPassword().equals(user.getPassword())&&user1.getType().equals("Admin"))
		{
		return "/homeAdmin";
		}
	  }
	  model.addAttribute("user",new User());
	  return "Login";
	  
	  }

}

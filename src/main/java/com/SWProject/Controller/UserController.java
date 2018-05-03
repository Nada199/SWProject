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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.SWProject.Entities.Product;
import com.SWProject.Entities.User;
import com.SWProject.Repository.ProductRepository;
import com.SWProject.Repository.UserRepository;

@Controller
@SessionAttributes("user")
public class UserController {
	
	@Autowired
	private UserRepository repo;
	@Autowired
	private ProductRepository repos;
	
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
		/*else if(user.getType().equals("Collaborator"))
		{
			return"/homeStoreowner";
		}*/
		return "addUser";
	}
/*// /buy/12345
	@RequestMapping(value="/buy",method= RequestMethod.GET)
	public String getproduct(@RequestParam (value = "id", required = false)Integer id)
	{
		System.out.println("ID = " + id);
		return "buy";
		//localhost:8080/buy?id=2
	}*/
	
	
	/*@GetMapping("/buyConfirmation")
	public String showConfirmation(Model model) {
		model.addAttribute("user", new User());
		return "buyConfirmation";
	}
	
	@PostMapping("/buyConfirmation")
	public String Buy1(Model model,@ModelAttribute User user, Double price)
	{
		Iterable<User>getUser=repo.findAll();
		for(User user1:getUser)
		{
			if(user1.getEmail().equals(user.getEmail()))
			{
				if(user.getType().equals("StoreOwner"))
				{
					price=price-(price*0.15);
					System.out.println(price);							
				}

			}
			
		}
		
		return "buyConfirmation";
		
	}*/
	
	@GetMapping("/buy")
	public String showget1(Model model) {
		model.addAttribute("product", new Product());
		return "buy";
	}
	
	@PostMapping("/buy")
	public String Buy(Model model,@ModelAttribute Product product,@ModelAttribute User user)
	{
		Iterable<Product>getProducts=repos.findAll();
		
		for(Product product1:getProducts)
		{
			if(product1.getId().equals(product.getId()))
		    {
				int amountUser=product.getAmount();
				int amountData=product1.getAmount();
				double price=product1.getPrice();
				if(amountData>=amountUser)
				{
					amountData-=amountUser;
					product1.setAmount(amountData);
					repos.save(product1);
					if(amountUser>=2)
					{
						price=price-(price*0.1);
						System.out.println(price);
					}
					Iterable<User>getUser=repo.findAll();
					for(User user1:getUser)
					{
						if(user1.getEmail().equals(user.getEmail()))
						{
							if(user.getType().equals("StoreOwner"))
							{
								price=price-(price*0.15);
								System.out.println(price);							
							}

						}
						
					}
					//Buy1( model, user, price);
					
			        return "/buy";
			    }
		     }
		}
		
		
		
		
		
		
		return "buy";
 }
	
	
}

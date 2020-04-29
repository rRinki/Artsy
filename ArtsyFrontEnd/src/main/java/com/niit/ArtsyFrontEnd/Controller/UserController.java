package com.niit.ArtsyFrontEnd.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.ArtsyBackEnd.DAO.ICustomerDAO;
import com.niit.ArtsyBackEnd.Model.Customer;

@Controller
public class UserController {
	
	@Autowired
	ICustomerDAO customerdao;
	

	@RequestMapping("/Register")
	String registerPage(Model model)
	{
		model.addAttribute("registerpage",true);
		model.addAttribute("customerobject",new Customer());
		model.addAttribute("title","Register");
		return "index";
	}

	@RequestMapping("/addcustomer")
	String addregisterPage(@ModelAttribute( "customerobject")Customer customer,Model model)
	{
		try
		{
		if(customerdao.addCustomer(customer))
		{
			model.addAttribute("info", true);
			model.addAttribute("message", "Customer Added");
			System.out.println("Done");
		}
		else
		{
			model.addAttribute("info", true);
			model.addAttribute("message", "Check Data");
			System.out.println("Failure");
		}
		}
		catch(Exception e)
		{
			model.addAttribute("info", true);
			model.addAttribute("message", "Check Data");
			System.out.println("Failure");
			
		}
		model.addAttribute("registerpage",true);
		model.addAttribute("customerobject",new Customer());
		model.addAttribute("title","Register");
		return "index";
	}
}

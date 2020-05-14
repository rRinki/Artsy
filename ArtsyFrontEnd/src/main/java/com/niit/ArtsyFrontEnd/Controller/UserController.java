package com.niit.ArtsyFrontEnd.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.ArtsyBackEnd.DAO.ICustomerDAO;
import com.niit.ArtsyBackEnd.Model.Category;
import com.niit.ArtsyBackEnd.Model.Customer;

@Controller
public class UserController {

	@Autowired
	ICustomerDAO customerdao;

	@RequestMapping("/Register")
	String registerPage(Model model) {
		model.addAttribute("registerpage", true);
		model.addAttribute("customerobject", new Customer());
		model.addAttribute("title", "Register");
		return "index";

	}

	@RequestMapping("/addcustomer")
	String addregisterPage(@Valid @ModelAttribute("customerobject") Customer customer, BindingResult br, Model model) {
		try {
			if (br.hasErrors()) {
				model.addAttribute("error1", true);
				model.addAttribute("success", false);
				model.addAttribute("error2", false);
				model.addAttribute("message", "Please Check Again");
				model.addAttribute("customerobject", customer);// this line will help in populating errors
				System.out.println("Done");

			} else {
				if (customerdao.addCustomer(customer)) {
					model.addAttribute("customerobject", new Customer());

					model.addAttribute("success", true);
					model.addAttribute("error2", false);
					model.addAttribute("error1", false);
					model.addAttribute("message", "Customer Added");
					System.out.println("Done");
				} else {
					model.addAttribute("customerobject", customer);// this line will help in populating errors
					model.addAttribute("error2", true);
					model.addAttribute("success", false);
					model.addAttribute("error2", false);
					model.addAttribute("message", "Check Data");
					System.out.println("Failure");
				}
			}
		}

		catch (Exception e) {
			model.addAttribute("error2", true);
			model.addAttribute("message", "Check Data once again");
			System.out.println("Failure");
			model.addAttribute("customerobject", customer);// this line will help in populating errors

		}

		model.addAttribute("registerpage", true);
		model.addAttribute("title", "Register");
		return "index";
	}
}

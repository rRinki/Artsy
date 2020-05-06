package com.niit.ArtsyFrontEnd.Controller;


import org.springframework.ui.Model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.ArtsyBackEnd.Model.Category;

@Controller
public class HomeController {

	

		@RequestMapping(value= {"/","/Home"})
		String IndexPage(Model model) {
			
			model.addAttribute("indexpage",true);
			model.addAttribute("title","Artsy");
			return "index";
		}
		
		@RequestMapping("/AboutUS")
		String abouotusPage(Model model)
		{
			model.addAttribute("aboutuspage",true);
			model.addAttribute("title","AboutUs");
			return "index";
		}
		

		@RequestMapping("/ContactUS")
		String contactusPage(Model model)
		{
			model.addAttribute("contactus",true);
			model.addAttribute("title","ContactUs");
			return "index";
		}
		

		@RequestMapping("/Login")
		String loginPage(Model model)
		{
			model.addAttribute("loginpage",true);
			model.addAttribute("title","Login");
			return "index";
		}
		
		
	}

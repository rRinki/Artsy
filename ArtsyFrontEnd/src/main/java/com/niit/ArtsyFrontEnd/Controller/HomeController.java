package com.niit.ArtsyFrontEnd.Controller;


import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.ArtsyBackEnd.DAO.CartDAOImpl;
import com.niit.ArtsyBackEnd.DAO.ICartDAO;
import com.niit.ArtsyBackEnd.DAO.IProductDAO;
import com.niit.ArtsyBackEnd.DAO.ProductDAOImpl;
import com.niit.ArtsyBackEnd.Model.Category;

@Controller
public class HomeController {
	
	@Autowired
	IProductDAO productdao;
	
	@Autowired
	ICartDAO cartdao;

	

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
		String loginPage(@RequestParam(value="error",required=false,defaultValue="false")boolean error,Model model)
		{
			if(error) {
				model.addAttribute("error1", true);
				model.addAttribute("message", "Email or Password Incorrect");
			}
			else
			{
				model.addAttribute("error1", false);
				model.addAttribute("message", "");
			}
			model.addAttribute("loginpage",true);
			model.addAttribute("title","Login");
			return "index";
		}
		
		
		@RequestMapping("/allproducts")
		String DisplayData(Model model)
		{
			model.addAttribute("productlist", productdao.allProduct());
			model.addAttribute("cust_productpage", true);
			 return "index";
		}
	
		@RequestMapping("/oneproduct")
		String DisplayProductDetails(Model model,@RequestParam("pro_id")int pro_id)
		{
			model.addAttribute("product",productdao.oneProduct(pro_id));
			model.addAttribute("one_productpage", true);
			model.addAttribute("title", "Artsy-Products");
			 return "index";
		
		}
		
		}

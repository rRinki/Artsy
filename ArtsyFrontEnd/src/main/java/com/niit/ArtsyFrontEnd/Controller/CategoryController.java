package com.niit.ArtsyFrontEnd.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.ArtsyBackEnd.DAO.ICategoryDAO;
import com.niit.ArtsyBackEnd.Model.Category;

@Controller
public class CategoryController {
	
	@Autowired
	ICategoryDAO categorydao;
	
	@RequestMapping("/Category")
	String categoryPage(Model model)
	{
		model.addAttribute("categorypage",true);
		model.addAttribute("categoryobject",new Category());
		model.addAttribute("title","category");
		return "index";
	}

	@RequestMapping("/addcategory")
	String addCategoryPage(@ModelAttribute( "categoryobject")Category category,Model model)
	{
		try
		{
		if(categorydao.addCategory(category))
		{
			model.addAttribute("info", true);
			model.addAttribute("message", "Category Added");
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
		model.addAttribute("categorypage",true);
		model.addAttribute("categoryobject",new Category());
		model.addAttribute("title","Artsy--Category");
		return "index";
	}
}

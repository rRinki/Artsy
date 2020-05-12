package com.niit.ArtsyFrontEnd.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.ArtsyBackEnd.DAO.ICategoryDAO;
import com.niit.ArtsyBackEnd.Model.Category;

@Controller
@RequestMapping("/admin")
public class CategoryController {

	@Autowired
	ICategoryDAO categorydao;

	@RequestMapping("/Category")
	String categoryPage(Model model) {
		
		model.addAttribute("categorypage", true);
		model.addAttribute("categorylist",categorydao.allCategory());
		model.addAttribute("categoryobject", new Category());
		model.addAttribute("title", "category");
		model.addAttribute("edit", false);
		model.addAttribute("success", false);
		model.addAttribute("message", "");
		return "index";
	}
	
	@RequestMapping("/addcategory")
	String addCategory(@Valid @ModelAttribute("categoryobject")Category category,BindingResult br,Model model)
	{
		try
		{
			if(br.hasErrors())
			{
				model.addAttribute("error1", true);
				model.addAttribute("message", "Please Enter Data In Correct Format");
				model.addAttribute("categoryobject", category);//this line will help in populating errors
				System.out.println("Done");
				
			
			}
			else
			{
				if(categorydao.addCategory(category))
				{
					
					model.addAttribute("success", true);
					model.addAttribute("message", "Category Added");
					System.out.println("Done");
					model.addAttribute("categoryobject",new Category());
				}
				else
				{
					model.addAttribute("error2", true);
					model.addAttribute("message", "Check Data");
					System.out.println("Failure");
					model.addAttribute("categoryobject",category);
				}
				
			}
		}
		catch(Exception e)
		{
			model.addAttribute("error2", true);
			model.addAttribute("message", "Check Data");
			System.out.println("Failure");
			model.addAttribute("categoryobject",category);
			
		}
		model.addAttribute("edit", false);
		model.addAttribute("categorypage",true);
		model.addAttribute("categorylist",categorydao.allCategory());
		model.addAttribute("title","Artsy--Category");
		return "index";
	}
	
	

	@RequestMapping("/deletecategory")
	String deleteCategory(@RequestParam("catname")String cat_Name,Model model)
	{
		try {
			//to fetch
			Category category=categorydao.oneCategory(cat_Name);
			
			
			if(categorydao.deleteCategory(category))
			{
				model.addAttribute("success", true);
				model.addAttribute("message", "Data deleted");
				
		}
			else {
				model.addAttribute("error1", true);
				model.addAttribute("message", "Data not deleted");
			}
			}
		catch(Exception e) {
			model.addAttribute("error1", true);
			model.addAttribute("message", "Data deleted");
			
		}
		model.addAttribute("edit", false);
		model.addAttribute("categorypage", true);
		model.addAttribute("categorylist",categorydao.allCategory());
		model.addAttribute("categoryobject", new Category());
		model.addAttribute("title", "category");
		return "index";
	}
	@RequestMapping("/getdatatoedit")
	String getOneCategoryToEdit(@RequestParam("catname")String catname,Model model) {
		
		model.addAttribute("edit", true);
		model.addAttribute("categorypage", true);
		model.addAttribute("categorylist",categorydao.allCategory());
		model.addAttribute("categoryobject", categorydao.oneCategory(catname));
		model.addAttribute("title", "category");
		model.addAttribute("success", true);
		model.addAttribute("message", "Please Edit the Data that you want to change");
		return "index";
	}

@RequestMapping("/updatecategory")
String updateCategory(@Valid @ModelAttribute("categoryobject")Category category,BindingResult br,Model model)
{
	try
	{
		if(br.hasErrors())
		{
			model.addAttribute("edit", true);
			model.addAttribute("error1", true);
			model.addAttribute("message", "Please Enter Data In Correct Format");
			model.addAttribute("categoryobject", category);//this line will help in populating errors
			System.out.println("Done");
			
		
		}
		else
		{
			if(categorydao.updateCategory(category))
			{
				model.addAttribute("success", true);
				model.addAttribute("message", "Category Added");
				System.out.println("Done");
				model.addAttribute("categoryobject",new Category());
				model.addAttribute("edit", false);
			}
			else
			{
				model.addAttribute("error2", true);
				model.addAttribute("message", "Check Data");
				System.out.println("Failure");
				model.addAttribute("categoryobject",category);
				model.addAttribute("edit", true);
			}
			
		}
	}
	catch(Exception e)
	{
		model.addAttribute("error2", true);
		model.addAttribute("message", "Check Data");
		System.out.println("Failure");
		model.addAttribute("categoryobject",category);
		model.addAttribute("edit", true);
		
	}
	model.addAttribute("categorypage",true);
	model.addAttribute("categorylist",categorydao.allCategory());
	model.addAttribute("title","Artsy--Category");
	return "index";
}
}

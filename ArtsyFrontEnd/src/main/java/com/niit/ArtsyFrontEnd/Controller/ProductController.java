package com.niit.ArtsyFrontEnd.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.Buffer;

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
import com.niit.ArtsyBackEnd.DAO.IProductDAO;
import com.niit.ArtsyBackEnd.Model.Product;
import com.niit.ArtsyBackEnd.Model.Category;

@Controller
@RequestMapping("/admin")
public class ProductController {

	@Autowired
	IProductDAO productdao;
	@Autowired
	ICategoryDAO categorydao;

	@RequestMapping("/products")

	String ProductPage(Model model) {
		model.addAttribute("productpage", true);
		model.addAttribute("productlist", productdao.allProduct());
		model.addAttribute("productobject", new Product());
		model.addAttribute("edit", false);
		model.addAttribute("error1", false);
		model.addAttribute("success", false);
		model.addAttribute("error2", false);
		model.addAttribute("message", "");
		model.addAttribute("catlist", categorydao.allCategory());
		model.addAttribute("title", "Product");
		return "index";
	}

	@RequestMapping("/addproducts")
	String addProductPage(@Valid @ModelAttribute("productobject") Product product, BindingResult br, Model model) {

		try {
			if (br.hasErrors()) {

				model.addAttribute("error1", true);
				model.addAttribute("success", false);
				model.addAttribute("error2", false);
				model.addAttribute("message", "Please Enter Data In correct order");
				model.addAttribute("productobject", product);
				System.out.println("Errrrorrrr");

			} else {
				if (productdao.addProduct(product)) {
					addImage(product.getPro_id(), product.getPro_images());
					model.addAttribute("productobject", new Product());
					model.addAttribute("error1", false);
					model.addAttribute("success", true);
					model.addAttribute("message", "Added");
					model.addAttribute("error2", false);
					System.out.println("Done");
				} else {
					model.addAttribute("productobject", product);
					model.addAttribute("error1", false);
					model.addAttribute("error2", true);
					model.addAttribute("success", false);
					model.addAttribute("message", "checkData");
					System.out.println("Failure");
				}
			}
		} catch (Exception e) {

			model.addAttribute("productobject", product);
			model.addAttribute("error1", false);
			model.addAttribute("error2", true);
			model.addAttribute("success", false);
			model.addAttribute("message", "checkData");
			System.out.println("Failure");

		}

		model.addAttribute("productpage", true);
		model.addAttribute("productlist", productdao.allProduct());
		model.addAttribute("edit", false);
		model.addAttribute("info", false);
		model.addAttribute("message", "");
		model.addAttribute("catlist", categorydao.allCategory());
		model.addAttribute("title", "Product");
		return "index";
	}

	private void addImage(int pro_id, MultipartFile pro_images) {
		String path = "D:\\Eclipse\\15April\\ArtsyFrontEnd\\src\\main\\webapp\\resources\\productimages\\";
		// Create image file URL
		try {
			
			if(pro_images.getSize()!=0)
			path = path + String.valueOf(pro_id) + ".jpg";
			File f = new File(path);
			

			if (f.exists()) {
				f.delete();
			}
			BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream(f));
			bs.write(pro_images.getBytes());
			bs.close();
			Thread.sleep(5000);
		} 
		catch (Exception e) {
		}

	}

	@RequestMapping("/deleteproduct")
	String deleteproduct(@RequestParam("proid") int pro_id, Model model) {
		try {
			System.out.println(pro_id);
			
			// Step 1: fetch the cat object from database
			Product product = productdao.oneProduct(pro_id);

			if (productdao.deleteProduct(product)) {
				String path = "D:\\Eclipse\\15April\\ArtsyFrontEnd\\src\\main\\webapp\\resources\\productimages\\";
				path = path + String.valueOf(pro_id) + ".jpg";
				File f = new File(path);
				if (f.exists()) {
						f.delete();
					}
				model.addAttribute("error1", false);
				model.addAttribute("success", true);
				model.addAttribute("error2", false);
				model.addAttribute("message", "Data Deleted");
			} else {
				model.addAttribute("error1", true);
				model.addAttribute("success", false);
				model.addAttribute("error2", false);
				model.addAttribute("message", "Data Not Deleted");
			}

		} catch (Exception e) {
			model.addAttribute("error1", true);
			model.addAttribute("success", false);
			model.addAttribute("error2", false);
			model.addAttribute("message", "Data Not Deleted");
		}

		model.addAttribute("edit", false);
		model.addAttribute("productpage", true);
		model.addAttribute("productobject", new Product());
		model.addAttribute("productlist", productdao.allProduct());
		model.addAttribute("catlist", categorydao.allCategory());
		model.addAttribute("title", "Product");

		return "index";
	}

	@RequestMapping("/getproducttoedit")
	String getOneProductToEdit(@RequestParam("proid") int pro_id, Model model) {
		model.addAttribute("edit", true);
		model.addAttribute("productpage", true);
		model.addAttribute("productlist", productdao.allProduct());
		model.addAttribute("productobject", productdao.oneProduct(pro_id));
		model.addAttribute("title", "Product");
		model.addAttribute("success", false);
		model.addAttribute("error2", false);
		model.addAttribute("error1", false);
		model.addAttribute("catlist", categorydao.allCategory());
		model.addAttribute("message", "Please Edit the Data that you want to change");
		return "index";
	}

	@RequestMapping("/updateproduct")
	String updateProduct(@Valid @ModelAttribute("productobject") Product product, BindingResult br, Model model) {
		try {
			if (br.hasErrors()) {
				model.addAttribute("edit", true);
				model.addAttribute("error1", true);
				model.addAttribute("success", false);
				model.addAttribute("error2", false);
				model.addAttribute("message", "Please Enter Data In correct Format");
				model.addAttribute("productobject", product);
				System.out.println("Done");
			} else {

				if (productdao.updateProduct(product)) {
					model.addAttribute("productobject", new Product());
					model.addAttribute("edit", false);
					model.addAttribute("error1", false);
					model.addAttribute("success", true);
					model.addAttribute("error2", false);
					model.addAttribute("message", "CategoryAdded");
					System.out.println("Done");

				} else {

					model.addAttribute("error2", true);
					model.addAttribute("message", "checkData");
					System.out.println("Failure");
					model.addAttribute("productobject", product);
					model.addAttribute("edit", true);
				}
			}
		} catch (Exception e) {
			model.addAttribute("edit", true);
			model.addAttribute("error1", false);
			model.addAttribute("error2", true);
			model.addAttribute("success", false);
			model.addAttribute("message", "checkData");
			System.out.println("Failure");
			model.addAttribute("productobject", product);

		}
		model.addAttribute("productpage", true);
		model.addAttribute("productlist", productdao.allProduct());
		model.addAttribute("catlist", categorydao.allCategory());
		model.addAttribute("title", "Product");

		return "index";
	}

}

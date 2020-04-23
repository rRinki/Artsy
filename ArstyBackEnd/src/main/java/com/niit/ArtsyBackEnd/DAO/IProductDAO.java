package com.niit.ArtsyBackEnd.DAO;

import java.util.ArrayList;

import com.niit.ArtsyBackEnd.Model.Category;
import com.niit.ArtsyBackEnd.Model.Product;

public interface IProductDAO {
	
	public boolean addProduct(Product product);
	public boolean updateProduct(Product product);
	public boolean deleteProduct(Product product);
	public ArrayList<Product> allProduct();
	public Product oneProduct(int prodid);
	public ArrayList<Product>allProductByCategory(Category category);

}

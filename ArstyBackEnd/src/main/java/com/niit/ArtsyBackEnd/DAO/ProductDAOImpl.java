package com.niit.ArtsyBackEnd.DAO;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.criteria.CriteriaQuery;


import com.niit.ArtsyBackEnd.Model.Category;
import com.niit.ArtsyBackEnd.Model.Product;

@Repository("productdao")
@Transactional
public class ProductDAOImpl implements IProductDAO {

	@Autowired
	SessionFactory sessionfactory;
	
	@Override
	public boolean addProduct(Product product) { 

		try {
			sessionfactory.getCurrentSession().save(product);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	

	@Override
	public boolean updateProduct(Product product) {
		try {
			sessionfactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteProduct(Product product) {
		try {
			sessionfactory.getCurrentSession().delete(product);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public ArrayList<Product> allProduct() {
		try
	      {
	        ArrayList<Product> product_list = (ArrayList<Product>)sessionfactory.getCurrentSession().createQuery("from Product").list();
	        return product_list;
	      }
	    catch(Exception e)
	     {
	      return null;
	     }
	}

	@Override
	public Product oneProduct(int pro_id) {
		try
	     {
	      Product  product= (Product)sessionfactory.getCurrentSession().createCriteria (Product.class).
	    		  add(Restrictions.eq("pro_id",pro_id)).uniqueResult();
	      System.out.println(product.getPro_name());
	      return product;
	     }
	    catch(Exception e)
	    {
	    return null;
	    }
	}

	@Override
	public ArrayList<Product> allProductByCategory(Category category) {
		try {
			ArrayList<Product> product_list=(ArrayList<Product>)sessionfactory.getCurrentSession().createCriteria(Product.class).
					add(Restrictions.eq("Product Cateogory", category)).list();
			
		return product_list;
	}
		catch (Exception e) {
			return null;
		
	}
	
}

}

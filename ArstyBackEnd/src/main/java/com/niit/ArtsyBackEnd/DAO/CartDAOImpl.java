package com.niit.ArtsyBackEnd.DAO;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ArtsyBackEnd.Model.Cart;
import com.niit.ArtsyBackEnd.Model.Customer;


@Repository("cartdao")
@Transactional
public class CartDAOImpl implements ICartDAO {
	
	@Autowired
	SessionFactory sessionfactory;

	@Override
	public boolean addCart(Cart cart) {
		try {
			sessionfactory.getCurrentSession().save(cart);
			return true;
		}
		catch(Exception e) {
		return false;
	}
	}

	@Override
	public boolean updateCart(Cart cart) {
		try {
			sessionfactory.getCurrentSession().update(cart);
			return true;
		}
		catch(Exception e) {
		return false;
	}
	}

	@Override
	public boolean deleteCart(Cart cart) {
		try {
			sessionfactory.getCurrentSession().delete(cart);
			return true;
		}
		catch(Exception e) {
		return false;
	}
	}

	@Override
	public ArrayList<Cart> allcart(Customer cust) {
		try {
			ArrayList<Cart> cartlist= (ArrayList<Cart>)sessionfactory.getCurrentSession().createCriteria(Cart.class)
					.add(Restrictions.eq("cust_details", cust)).list();
			return cartlist;
		}
		catch(Exception e) {
			return null;
		}
	}

	@Override
	public Cart oneCart(int cartid) {
		try {
			Cart cart= (Cart) sessionfactory.getCurrentSession().createCriteria(Cart.class)
					.add(Restrictions.eq("cart_id", cartid)).uniqueResult();
			return cart;
		}
		catch(Exception e) {
			return null;
		}
	}

}

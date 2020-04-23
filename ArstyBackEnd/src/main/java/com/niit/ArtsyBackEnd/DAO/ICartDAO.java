package com.niit.ArtsyBackEnd.DAO;

import java.util.ArrayList;

import com.niit.ArtsyBackEnd.Model.Cart;
import com.niit.ArtsyBackEnd.Model.Customer;

public interface ICartDAO {
	
	public boolean addCart(Cart cart);
	public boolean updateCart(Cart cart);
	public boolean deleteCart(Cart cart);
	public ArrayList<Cart> allcart(Customer cust);
	public Cart oneCart(int cartid);


}

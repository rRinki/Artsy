package com.niit.ArtsyBackEnd.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int cart_id;
	
	@ManyToOne
	Customer cust_details;
	
	@ManyToOne
	Product pro_details;
	
	@Column(nullable=false)
	int Quantity_list;

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public Customer getCust_details() {
		return cust_details;
	}

	public void setCust_details(Customer cust_details) {
		this.cust_details = cust_details;
	}

	public Product getPro_details() {
		return pro_details;
	}

	public void setPro_details(Product pro_details) {
		this.pro_details = pro_details;
	}

	public int getQuantity_list() {
		return Quantity_list;
	}

	public void setQuantity_list(int quantity_list) {
		Quantity_list = quantity_list;
	}

}

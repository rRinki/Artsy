package com.niit.ArtsyBackEnd.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int pro_id;
	
	@Column(nullable=false,unique=true)
	String pro_name;
	
	@Column(nullable=false,columnDefinition="text")
	String pro_description;
	
	@Column(nullable=false)
	int pro_stock;
	
	@Column(nullable=false)
	float pro_price;
	
	@ManyToOne
	Category pro_Category;

	public Category getPro_Category() {
		return pro_Category;
	}

	public void setPro_Category(Category pro_Category) {
		this.pro_Category = pro_Category;
	}

	public int getPro_id() {
		return pro_id;
	}

	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}

	public String getPro_name() {
		return pro_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	public String getPro_description() {
		return pro_description;
	}

	public void setPro_description(String pro_description) {
		this.pro_description = pro_description;
	}

	public int getPro_stock() {
		return pro_stock;
	}

	public void setPro_stock(int pro_stock) {
		this.pro_stock = pro_stock;
	}

	public float getPro_price() {
		return pro_price;
	}

	public void setPro_price(float pro_price) {
		this.pro_price = pro_price;
	}
	
	
	

}

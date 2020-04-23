package com.niit.ArtsyBackEnd.Model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class MyOrders {
	
	@Id
	String order_Id;
	
	@Column(nullable=false)
	Product pro_Detail;
	
	@Column(nullable=false)
	Customer cus_Detail;
	
	@Column(nullable=false)
	Address address;
	
	@Column(nullable=false)
	float total;
	
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	Date order_date;

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public String getOrder_Id() {
		return order_Id;
	}

	public void setOrder_Id(String order_Id) {
		this.order_Id = order_Id;
	}

	public Product getPro_Detail() {
		return pro_Detail;
	}

	public void setPro_Detail(Product pro_Detail) {
		this.pro_Detail = pro_Detail;
	}

	public Customer getCus_Detail() {
		return cus_Detail;
	}

	public void setCus_Detail(Customer cus_Detail) {
		this.cus_Detail = cus_Detail;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
	
	

}

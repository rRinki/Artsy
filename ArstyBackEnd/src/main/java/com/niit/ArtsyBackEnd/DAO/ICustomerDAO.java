package com.niit.ArtsyBackEnd.DAO;

import com.niit.ArtsyBackEnd.Model.Customer;

public interface ICustomerDAO {
	
	public boolean addCustomer(Customer customer);
	public boolean updateCustomer(Customer customer);
	public Customer selectCustomer(String emailId);

}

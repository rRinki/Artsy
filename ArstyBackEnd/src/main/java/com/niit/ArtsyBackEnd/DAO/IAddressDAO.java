package com.niit.ArtsyBackEnd.DAO;

import java.util.ArrayList;

import com.niit.ArtsyBackEnd.Model.Address;
import com.niit.ArtsyBackEnd.Model.Customer;

public interface IAddressDAO {
	
	public boolean addAddress(Address address);
	public boolean updateAddress(Address address);
	public boolean deleteAddress(Address address);
	public ArrayList<Address> allAddress(Customer cust);
	public Address oneAddress(int addressid);

}

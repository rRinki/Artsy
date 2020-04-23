package com.niit.ArtsyBackEnd.DAO;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ArtsyBackEnd.Model.Address;
import com.niit.ArtsyBackEnd.Model.Customer;


@Repository("addressdao")
@Transactional
public class AddressDAOImpl implements IAddressDAO {

	@Autowired
	SessionFactory sessionfactory;

	@Override
	
	public boolean addAddress(Address address) {
		
		try {
			sessionfactory.getCurrentSession().save(address);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateAddress(Address address) {
		try {
			sessionfactory.getCurrentSession().update(address);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteAddress(Address address) {
		try {
			sessionfactory.getCurrentSession().delete(address);
			return true;
		}
		catch(Exception e) {
		return false;
	                        }
	}
	

	@Override
	public ArrayList<Address> allAddress(Customer cust) {
			try {
				ArrayList<Address> address_list=(ArrayList<Address>)sessionfactory.getCurrentSession().createCriteria(Address.class).
						add(Restrictions.eq("customer", cust)).list();
				
			return address_list;
		}
			catch (Exception e) {
				return null;
			
		}
		
	}

	@Override
	public Address oneAddress(int addressid) {
		try {
			Address address = (Address) sessionfactory.getCurrentSession().createCriteria(Address.class)
					.add(Restrictions.eq("address_Id",addressid)).uniqueResult();
			return address;
		}
		catch (Exception e) {
			return null;
		}
	}

}

package com.niit.ArtsyBackEnd.DAO;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ArtsyBackEnd.Model.Cart;
import com.niit.ArtsyBackEnd.Model.Customer;
import com.niit.ArtsyBackEnd.Model.MyOrders;
import com.niit.ArtsyBackEnd.Model.Product;


@Repository("myordersdao")
@Transactional
public class MyOrdersDAOImpl implements IMyOrdersDAO {
	
	@Autowired
	SessionFactory sessionfactory;

	@Override
	public boolean addMyOrder(MyOrders MyOrder)  {
		try {
			sessionfactory.getCurrentSession().save(MyOrder);
			return true;
		}
		catch(Exception e) {
		return false;
	}
	}

	@Override
	public boolean updateMyOrder(MyOrders MyOrder) {
		try {
			sessionfactory.getCurrentSession().update(MyOrder);
			return true;
		}
		catch(Exception e) {
		return false;
	}
	}

	@Override
	public boolean deleteMyOrder(MyOrders MyOrder) {
		try {
			sessionfactory.getCurrentSession().delete(MyOrder);
			return true;
		}
		catch(Exception e) {
		return false;
	}
	}

	@Override
	public ArrayList<MyOrders> allMyOrder(Customer cust){
		try {
			ArrayList<MyOrders> orderlist = (ArrayList<Myorders>)sessionfactory.getCurrentSession().createCriteria(MyOrders.class)
					.add(Restrictions.eq("cus_Detail", cust)).list();
			return orderlist;
			
		}
		catch(Exception e) {
			return null;
		}
	}

	@Override
	public MyOrders oneMyOrder(String orderid) {
		try {
			MyOrders order = (MyOrders) sessionfactory.getCurrentSession().createCriteria(Cart.class)
					.add(Restrictions.eq("order_Id", orderid)).uniqueResult();
			return order;
		}
		catch(Exception e) {
			return null;
		}
	}
}

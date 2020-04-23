package com.niit.ArtsyBackEnd.DAO;

import com.niit.ArtsyBackEnd.Model.Customer;
import com.niit.ArtsyBackEnd.Model.MyOrders;
import java.util.ArrayList;

public interface IMyOrdersDAO {
	public boolean addMyOrder(MyOrders MyOrder);
	public boolean updateMyOrder(MyOrders MyOrder);
	public boolean deleteMyOrder(MyOrders MyOrder);
	public ArrayList<MyOrders> allMyOrder(Customer cust);
	public MyOrders oneMyOrder(String orderid);

}

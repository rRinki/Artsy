package com.niit.ArtsyFrontEnd.Controller;

import java.util.Date;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.ArtsyBackEnd.DAO.IAddressDAO;
import com.niit.ArtsyBackEnd.DAO.ICartDAO;
import com.niit.ArtsyBackEnd.DAO.IMyOrdersDAO;
import com.niit.ArtsyBackEnd.DAO.IProductDAO;
import com.niit.ArtsyBackEnd.Model.Address;
import com.niit.ArtsyBackEnd.Model.Cart;
import com.niit.ArtsyBackEnd.Model.Customer;
import com.niit.ArtsyBackEnd.Model.MyOrders;
import com.niit.ArtsyBackEnd.Model.Product;



@Controller
public class OrderController {
	
	@Autowired
	IMyOrdersDAO orderdao;
	
	@Autowired
	IAddressDAO addressdao;
	
	@Autowired
	ICartDAO cartdao;
	
	@Autowired
	IProductDAO productdao;
	
	@RequestMapping("/user/placeorder")
	String placeOrder(@RequestParam("addressid") int addressid, HttpSession session, Model m)
	{
		MyOrders myorder =  new MyOrders();
		ArrayList<Cart> cartlist = (ArrayList<Cart>) session.getAttribute("cartinfo");
		 Address address= addressdao.oneAddress(addressid);
		 Customer customer = (Customer) session.getAttribute("custdetails");
		  String orderid = "OD" + UUID.randomUUID().getMostSignificantBits();
		  Iterator<Cart> cartIterator=cartlist.iterator();
			
		  while(cartIterator.hasNext())
		  {
			  Cart cart = (Cart) cartIterator.next();
			  myorder.setAddress(address);
			  myorder.setCus_Detail(customer);
			  myorder.setOrder_Id(orderid);
			  myorder.setProdqty(cart.getPro_Quantity());
			  myorder.setOrder_date(new Date());
			  myorder.setPro_Detail(cart.getPro_details());
			  myorder.setTotal(Float.parseFloat(session.getAttribute("total").toString()));
			  
			  Product p = cart.getPro_details();
			  if(p.getPro_stock() >= cart.getPro_Quantity() && orderdao.addMyOrder(myorder))
			  {
			  
			  p.setPro_stock(p.getPro_stock() - cart.getPro_Quantity()); 
			  productdao.updateProduct(p);
			  cartdao.deleteCart(cart);
		  }
			  float total=0;
			    ArrayList<MyOrders> orderslist = orderdao.allMyOrder(customer);
				Iterator<MyOrders> Ordersiterator=orderslist.iterator();
				while(Ordersiterator.hasNext())
				{
					MyOrders orders=(MyOrders) Ordersiterator.next();
					total=total+(orders.getProdqty()*orders.getPro_Detail().getPro_price());
				}
				session.setAttribute("total",total );
				session.setAttribute("cartinfo",cartlist );
				m.addAttribute("orderpage", true);
			}
			  cartlist=cartdao.allcart(customer);
			  session.setAttribute("total",0);
				session.setAttribute("cartinfo", cartlist);
				session.setAttribute("cartqty", cartlist.size());
		
		return "redirect:/user/viewallorders";
		
	}
	
	@RequestMapping("user/viewallorders")
	
	String viewOrders(HttpSession session , Model m)
	{
		
		Customer cust = (Customer) session.getAttribute("custdetails"); 
		ArrayList<MyOrders> orders = orderdao.allMyOrder(cust);
		m.addAttribute("orderlist", orders);
		m.addAttribute("orderpage", true);
		return "index";
		
	}
	@RequestMapping("user/viewdetails")
	String viewDetails(@RequestParam("oid")String orderid,Model model)
	{
	    System.out.println(orderid);
		ArrayList<MyOrders> orders = orderdao.oneMyOrder(orderid);
		System.out.println(orders);
		model.addAttribute("orderlist", orders);
		model.addAttribute("oneorderspage", true);
		return "index";
	
	}
}

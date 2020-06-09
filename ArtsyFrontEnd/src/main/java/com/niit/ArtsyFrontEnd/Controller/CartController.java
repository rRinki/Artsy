package com.niit.ArtsyFrontEnd.Controller;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.ArtsyBackEnd.DAO.ICartDAO;
import com.niit.ArtsyBackEnd.DAO.IProductDAO;
import com.niit.ArtsyBackEnd.Model.Cart;
import com.niit.ArtsyBackEnd.Model.Customer;
import com.niit.ArtsyBackEnd.Model.Product;

@Controller
public class CartController {

	@Autowired
	IProductDAO productdao;

	@Autowired
	ICartDAO cartdao;

	@RequestMapping("/addtocart")
	String addToCart(@RequestParam("productid") int pid,
			@RequestParam(required = false, value = "quantity", defaultValue = "1") int qty,
			@RequestParam(value = "cartpage", required = false, defaultValue = "false") boolean cartpage, Model m,
			HttpSession session)
	{
		Customer c = (Customer) session.getAttribute("custdetails");

		if (session.getAttribute("cartinfo") == null) 
		{
			session.setAttribute("pid", pid);
			session.setAttribute("qty", qty);
			m.addAttribute("loginpage", true);
		} 
		
		else
		{
			Cart item = new Cart();
			Product p = productdao.oneProduct(pid);
			ArrayList<Cart> cartlist = (ArrayList<Cart>) session.getAttribute("cartinfo");
			if (cartlist.isEmpty()) 
			{
				item.setCust_details(c);
				item.setPro_details(p);
				
				if (p.getPro_stock() >= qty) 
				{
					item.setPro_Quantity(qty);
				}
				else
				{
					item.setPro_Quantity(1);
					m.addAttribute("error", true);
					m.addAttribute("message", "Stock Insufficient");
					m.addAttribute("pid", p.getPro_id());

				}
				cartdao.addCart(item);
			} 
			else {
				int flag = 1;
				Iterator<Cart> cartitem = cartlist.listIterator();
				while (cartitem.hasNext()) {
					Cart cart = (Cart) cartitem.next();
					if (cart.getPro_details().getPro_id() == pid) {
						if (cartpage) {
							if (p.getPro_stock() >= qty) {
								
								m.addAttribute("error", true);
								m.addAttribute("message", "Stock insufficent");
								m.addAttribute("pid", p.getPro_id());
								
							}

							else {
								item.setPro_Quantity(qty);
								cartdao.updateCart(cart);
							}
						}
						else
						{
							int oldqty = cart.getPro_Quantity();
							int newqty = oldqty + qty;
							if (newqty > p.getPro_stock()) {
								m.addAttribute("error", true);
								m.addAttribute("message", "Stock Insufficient");
								m.addAttribute("pid", p.getPro_id());

							} else 
							{
								cart.setPro_Quantity(newqty);
								cartdao.updateCart(cart);
							}
						}
							flag = 0;
							break;
						}

					}
					if (flag == 1) {
						item.setCust_details(c);
						item.setPro_details(p);
						if (p.getPro_stock() >= qty) {
							item.setPro_Quantity(qty);
						} else {
							m.addAttribute("error", true);
							m.addAttribute("message", "Stock Insufficient");
							m.addAttribute("pid", p.getPro_id());

						}
						cartdao.addCart(item);
					}
				}
				float total = 0;
				cartlist = cartdao.allcart(c);
				session.setAttribute("cartinfo", cartlist);
	            m.addAttribute("cartpage", true);

			}

			return "index";
		}
	

	@RequestMapping("/user/viewCart")
	String viewcart(HttpSession session, Model m) 
	{
		if(session.getAttribute("cartinfo")==null) {
		Customer cust = (Customer) session.getAttribute("custdetails");
		float total=0;
		ArrayList<Cart> cartlist = cartdao.allcart(cust);
		 Iterator<Cart> cartIterator=cartlist.iterator();
		 while(cartIterator.hasNext())
		  {
			  Cart cart = (Cart) cartIterator.next();
			  total= total +(cart.getPro_Quantity()*cart.getPro_details().getPro_price());
		  }
		 session.setAttribute("total",total);
		session.setAttribute("cartinfo", cartdao.allcart(cust));
		session.setAttribute("cartqty", cartdao.allcart(cust).size());
		}
		m.addAttribute("cartpage", true);
		return "index";
	
	}

	@RequestMapping("/user/deleteitem")
	String deleteCart(@RequestParam("cartid") int cartid,Model model,HttpSession session)
	{
		System.out.println(cartid);
		Customer cust=(Customer)session.getAttribute("custdetails");
		ArrayList<Cart> cartlist= cartdao.allcart(cust);
		cartdao.deleteCart(cartdao.oneCart(cartid));
		session.setAttribute("cartinfo", cartdao.allcart(cust));
		model.addAttribute("cartpage", true);
		
		 return "index";
	}
	
}

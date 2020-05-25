package com.niit.ArtsyFrontEnd.Controller;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.ArtsyBackEnd.DAO.IAddressDAO;
import com.niit.ArtsyBackEnd.Model.Address;
import com.niit.ArtsyBackEnd.Model.Customer;

@Controller
@RequestMapping("/user")
public class AddressController {

	@Autowired
	IAddressDAO addressdao;

	@RequestMapping("/selectaddress")
	String addressPage(Model m, HttpSession session) {
		Customer cust = (Customer) session.getAttribute("custdetails");
		m.addAttribute("addresspage", true);
		m.addAttribute("addresslist", addressdao.allAddress(cust));
		m.addAttribute("addressobject", new Address());
		return "index";
	}

	@RequestMapping("/addaddress")
	String addAddress(@RequestParam Map<String, String> addressmodel, Model m, HttpSession session) {
		
		
		System.out.println(addressmodel.get("pincode"));
		Customer cust = (Customer) session.getAttribute("custdetails");
		Address address = new Address();
		address.setCustomer(cust);
		address.setLine1(addressmodel.get("line1"));
		address.setLine2(addressmodel.get("line2"));
		address.setArea(addressmodel.get("area"));
		address.setName(addressmodel.get("name"));
		address.setPincode(Integer.parseInt(addressmodel.get("pincode")));
		try {

			if (addressdao.addAddress(address)) {
				m.addAttribute("info", true);
				m.addAttribute("message", "Address Added Successfully");
				//m.addAttribute("addressobject", address);
				System.out.println("Address Added Successfully");
				

			} else {
				m.addAttribute("info", true);
				m.addAttribute("message", "Address Already Added!!");
				//m.addAttribute("addressobject", address);
				System.out.println("Failure Already Added!");

			}
		} catch (Exception e) {
			m.addAttribute("info", true);
			m.addAttribute("message", "Address Already Added!!");
			//m.addAttribute("addressobject", address);
			System.out.println("Catch");
			System.out.println(e.getMessage());

		}
		m.addAttribute("addresslist", addressdao.allAddress(cust));
		m.addAttribute("addresspage", true);
		m.addAttribute("title","Artsy--Address");
		return "index";
	}

	@RequestMapping("/deleteaddress")
	String deleteAddress(@RequestParam("addressid") int id, Model m, HttpSession session) {
		try {
			if (addressdao.deleteAddress(addressdao.oneAddress(id))) {
				m.addAttribute("info", true);
				m.addAttribute("message", "Address deleted");

			} else {
				m.addAttribute("info", true);
				m.addAttribute("message", "Address not deleted");
			}
		} catch (Exception e) {
			m.addAttribute("info", true);
			m.addAttribute("message", "Address not deleted");

		}

		Customer cust = (Customer) session.getAttribute("custdetails");
		m.addAttribute("addresspage", true);
		m.addAttribute("addressobject", new Address());
		m.addAttribute("addresslist", addressdao.allAddress(cust));
		return "index";
	}

	@RequestMapping("/editaddress")
	String editAddress(Model m, HttpSession session, @RequestParam("addressid") int id) {
		Customer cust = (Customer) session.getAttribute("custdetails");
		m.addAttribute("edit", true);
		m.addAttribute("addresslist", addressdao.allAddress(cust));
		m.addAttribute("addresspage", true);
		m.addAttribute("addressobject", addressdao.oneAddress(id));
		System.out.println( addressdao.oneAddress(id).getArea());
		return "index";
	}

	@RequestMapping("/updateaddress")
	String updateAddress(@RequestParam Map<String, String> addressmodel, Model m, HttpSession session)

	{
		Customer cust = (Customer) session.getAttribute("custdetails");
		Address address = new Address();
		address.setAddress_Id(Integer.parseInt(addressmodel.get("addressid")));
		address.setCustomer(cust);
		address.setLine1(addressmodel.get("line1"));
		address.setLine2(addressmodel.get("line2"));
		address.setArea(addressmodel.get("area"));
		address.setName(addressmodel.get("name"));
		address.setPincode(Integer.parseInt(addressmodel.get("pincode")));
		try {
			if (addressdao.updateAddress(address)) {
				m.addAttribute("info", true);
				m.addAttribute("message", "Address Updated Successfully");
				//m.addAttribute("addressobject", address); 
				

			} else {
				m.addAttribute("info", true);
				m.addAttribute("message", "Address Not Updated!!!");
				//m.addAttribute("addressobject", address);
				m.addAttribute("addresspage", true);

			}
		} catch (Exception e) {
			m.addAttribute("info", true);
			//m.addAttribute("addressobject", address);
			m.addAttribute("message", "Address Already Added!!");

		}
		m.addAttribute("addresslist", addressdao.allAddress(cust));
		m.addAttribute("addresspage", true);
		m.addAttribute("title", "Artsy--Address");
		return "index";
	}
}

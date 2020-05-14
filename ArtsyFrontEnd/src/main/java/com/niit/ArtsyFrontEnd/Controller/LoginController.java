package com.niit.ArtsyFrontEnd.Controller;

import javax.resource.spi.work.SecurityContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.ArtsyBackEnd.DAO.ICustomerDAO;
import com.niit.ArtsyBackEnd.Model.Customer;

@Controller
public class LoginController {
	@Autowired
	ICustomerDAO custdao;
	

	String loginPage(@RequestParam(value = "error", required = false, defaultValue = "false") boolean error,
			Model model)

	{
		if (error) {
			model.addAttribute("error1", true);
			model.addAttribute("message", "Email or Password Incorrect");
		} else {
			model.addAttribute("error1", false);
			model.addAttribute("message", "");
		}
		model.addAttribute("loginpage", true);
		model.addAttribute("title", "Login");
		return "index";
	}

@RequestMapping("/loginsuccess")
		String loginSuccess(Model model,HttpSession session)
		{
			String userid = SecurityContextHolder.getContext().getAuthentication().getName();
			String role = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();
			
				if(role.equals("[ROLE_ADMIN]"))
						{
					session.setAttribute("username", "Artsy---Admin");
					session.setAttribute("adminrole",true );
					session.setAttribute("userrole",false );
							}
				else
				{
					Customer customer = custdao.selectCustomer(userid);
					session.setAttribute("username", customer.getCus_Name().toUpperCase());
					session.setAttribute("userrole",true);
					session.setAttribute("adminrole",false);
					
					
				}
				model.addAttribute("indexpage", true);
				return"index";
}

}

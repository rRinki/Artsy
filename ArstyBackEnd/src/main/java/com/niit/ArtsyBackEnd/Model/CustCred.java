package com.niit.ArtsyBackEnd.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustCred {
	
	@Id
	String cust_Email;
	
	
	@Column(nullable=false)
	String cust_Password;
	
	@Column(nullable=false,unique=true)
	String cust_Role;
	
	@Column(nullable=false,unique=true)
	String cust_Status;

	public String getCust_Email() {
		return cust_Email;
	}

	public void setCust_Email(String cust_Email) {
		this.cust_Email = cust_Email;
	}

	public String getCust_Password() {
		return cust_Password;
	}

	public void setCust_Password(String cust_Password) {
		this.cust_Password = cust_Password;
	}

	public String getCust_Role() {
		return cust_Role;
	}

	public void setCust_Role(String cust_Role) {
		this.cust_Role = cust_Role;
	}

	public String getCust_Status() {
		return cust_Status;
	}

	public void setCust_Status(String cust_Status) {
		this.cust_Status = cust_Status;
	}
	
}

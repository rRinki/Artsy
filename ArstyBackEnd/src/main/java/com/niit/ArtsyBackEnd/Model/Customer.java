package com.niit.ArtsyBackEnd.Model;
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

	@Entity
	public class Customer 
	{
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		int cus_Id;
		
		@Column(nullable=false,unique=true)
		@NotBlank(message="Customer Name cannot be blank")
		@Length(min=3,message="Minimum number of characters is 3")
		String cus_Name;
		
		@Column(nullable=false,unique=true)
		@Email()
		String cus_Email;
		
		@Column(nullable=false)
		@Pattern(regexp = "/^[0-9]\\d{2,4}-\\d{6,8}$/",message="Please enter the valid phone number")
		
		String cus_Phone;
		
		@Transient
		@Column(nullable=false)
		String cust_Password;

		public int getCus_Id() {
			return cus_Id;
		}

		public void setCus_Id(int cus_Id) {
			this.cus_Id = cus_Id;
		}

		public String getCus_Name() {
			return cus_Name;
		}

		public void setCus_Name(String cus_Name) {
			this.cus_Name = cus_Name;
		}

		public String getCus_Email() {
			return cus_Email;
		}

		public void setCus_Email(String cus_Email) {
			this.cus_Email = cus_Email;
		}

		public String getCus_Phone() {
			return cus_Phone;
		}

		public void setCus_Phone(String cus_Phone) {
			this.cus_Phone = cus_Phone;
		}

		public String getCust_Password() {
			return cust_Password;
		}

		public void setCust_Password(String cust_Password) {
			this.cust_Password = cust_Password;
		}
		
		
		
	}


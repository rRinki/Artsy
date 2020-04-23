package com.niit.ArtsyBackEnd.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int cat_Id;
	
	@Column(nullable=false,unique=true)
	String cat_Name;

	public int getCat_Id() {
		return cat_Id;
	}

	public void setCat_Id(int cat_Id) {
		this.cat_Id = cat_Id;
	}

	public String getCat_Name() {
		return cat_Name;
	}

	public void setCat_Name(String cat_Name) {
		this.cat_Name = cat_Name;
	}


}

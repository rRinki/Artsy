package com.niit.ArtsyBackEnd.DAO;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ArtsyBackEnd.Model.Category;

@Repository("categorydao")
@Transactional
public class CategoryDAOImpl implements ICategoryDAO {

	@Autowired
	SessionFactory sessionfactory;

	@Override
	public boolean addCategory(Category category) {

		try {
			sessionfactory.getCurrentSession().save(category);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateCategory(Category category) {
		try {
			sessionfactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean deleteCategory(Category category) {
		try {
			sessionfactory.getCurrentSession().delete(category);
			return true;
		}
		catch(Exception e) {
		return false;
	                        }
	}

	@Override
	public ArrayList<Category> allCategory() {
		try {
			ArrayList<Category> catlist= (ArrayList<Category>)sessionfactory.getCurrentSession().
					createQuery("from Category").list();
			return catlist;		
		}
		catch(Exception e)
	{
		return null;
	}
	}

	@Override
	public Category oneCategory(String catname) {
		try {
		Category category=(Category) sessionfactory.getCurrentSession().createCriteria(Category.class).
				add(Restrictions.eq("cat_Name",catname)).uniqueResult();
		return category;
	}
		catch (Exception e)
		{
			return null;
		}
}
}

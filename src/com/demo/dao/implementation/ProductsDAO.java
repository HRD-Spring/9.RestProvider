package com.demo.dao.implementation;

import java.util.List;

import org.hibernate.Session;

import com.demo.dao.implementation.HibernateConnection;
import com.demo.pojo.Products;

public class ProductsDAO implements com.demo.dao.layer.ProductsDAO{
	
	public List<Products> getAllProducts() {
		Session session = HibernateConnection.doHibernateConnection().openSession();
		
		List<Products> allProducts = session.createQuery("From Products").list();
		session.close();
		return allProducts;
		
	}
	
	public List<Object[]> getAllProductsSQL() {
		Session session = HibernateConnection.doHibernateConnection().openSession();
		
		List<Object[]> allProducts = session.createSQLQuery("select * from products").list();
		session.close();
		
		return allProducts;
	}
}

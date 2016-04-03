package com.demo.controllers;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dao.registery.RegisteryDAO;
import com.demo.pojo.Products;
import com.demo.pojo.ProductsList;

@RestController
public class RestProviderController {

	@RequestMapping(value = "/jsonGetProductById/{productId}", method = RequestMethod.GET)
	public String jsonGetProductById(@PathVariable("productId") String productId) {
		Products products = RegisteryDAO.getProductsDAO().getProductByProductId(productId);
		products.setImage("http://localhost:8080/RestProvider/img/" + products.getImage());

		JSONObject jsonObject = new JSONObject(products);
		return jsonObject.toString();
	}

	@RequestMapping(value = "/jsonGetAllProducts", method = RequestMethod.GET)
	private String jsonGetAllProducts() {
		List<Products> products = RegisteryDAO.getProductsDAO().getAllProducts();

		JSONArray jArray = new JSONArray();
		for (Products product : products) {
			product.setImage("http://localhost:8080/RestProvider/img/" + product.getImage());

			JSONObject json = new JSONObject(product);
			jArray.put(json);
		}
		return jArray.toString();
	}
	
	@RequestMapping(value="/xmlGetProductById/{productId}", method=RequestMethod.GET)
	public Products xmlGetProductById(@PathVariable("productId") String productId) {
		Products products = RegisteryDAO.getProductsDAO().getProductByProductId(productId);
		products.setImage("http://localhost:8080/RestProvider/img/" + products.getImage());

		return products;
	}
	
	@RequestMapping(value="/xmlGetAllProducts", method=RequestMethod.GET)
	public ProductsList xmlGetAllProducts() {
		
		ProductsList pList = new ProductsList();
		pList.setProducts(RegisteryDAO.getProductsDAO().getAllProducts());
		
		for (Products product : pList.getProducts()) {
			product.setImage("http://localhost:8080/RestProvider/img/" + product.getImage());
		}
		
		return pList;
		
	}
}

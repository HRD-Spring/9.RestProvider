package com.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.ProductsModel;
import com.demo.pojo.Products;

@Controller
@RequestMapping("/products")
public class ProductsController {
	
	@RequestMapping(name="/producs", method=RequestMethod.GET)
	public ModelAndView loadProducts() {
		ModelAndView modelAndView = new ModelAndView("products_sql");
		
		ProductsModel productsModel = new ProductsModel();
		//modelAndView.addObject("allProducts", productsModel.getAllProducts());
		modelAndView.addObject("allProducts", productsModel.getAllProductsSQL());
		return modelAndView;
	}
}

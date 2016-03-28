package com.demo.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loadLoginPage() {
		ModelAndView modelAndView = new ModelAndView("login");
		System.out.println("call");
		return modelAndView;
	}

	/*
	 * @RequestMapping(value = "/login", method = RequestMethod.GET) public
	 * String loadLoginPage() { return "login"; }
	 */

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLogin(HttpServletRequest request) {
		try {

			String username = request.getParameter("username");
			String password = request.getParameter("password");

			System.out.println(username + " " + password);

			return "login";
		} catch (Exception e) {
			// TODO: handle exception
			return "login";
		}
	}
}

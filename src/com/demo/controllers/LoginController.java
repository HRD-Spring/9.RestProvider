package com.demo.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.realm.LockOutRealm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.LoginModel;

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
	public String doLogin(HttpServletRequest request, Model md, HttpSession session) {
		try {

			String username = request.getParameter("username");
			String password = request.getParameter("password");

			System.out.println(username + " " + password);

			LoginModel lm = new LoginModel();
			String message = lm.doLoginProcess(username, password);
			if (message.equals("login success")) {
				session.setAttribute("username", username);
				return "redirect:/myprofile"; // user redirect to change url
			} else {
				md.addAttribute("errorMsg", message);
			}
			return "login";
		} catch (Exception e) {
			// TODO: handle exception
			return "login";
		}
	}
}

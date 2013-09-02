package com.runningtogov.proV.controllers;
 
import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class LoginController {
 
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String printUserDetails(ModelMap model, Principal principal ) {
 
		String name = principal.getName();
		model.addAttribute("username", name);
//		model.addAttribute("message", "Welcome User");
		return "home";
 
	}
 
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
 
		return "login";
 
	}
 
	@RequestMapping(value="/login_error", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
 
		model.addAttribute("error", "Error: Invalid Credentials");
		return "login";
 
	}
	
	@RequestMapping(value="/sign-up", method = RequestMethod.GET)
	public String signUp(ModelMap model) {
 
		return "sign-up";
 
	}
 
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
 
		return "login";
 
	}
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String register(ModelMap model) {
 
		return "register";
 
	}
 
}
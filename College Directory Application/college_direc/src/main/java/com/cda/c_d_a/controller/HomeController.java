package com.cda.college_direc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	 @GetMapping("/")
	    public String showLoginPage() {
	        return "login";  // This corresponds to login.html in the templates directory
	    }
}

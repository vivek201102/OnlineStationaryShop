package com.stationary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homecontroller {
	
	@RequestMapping("/")
	public String home()
	{
		return "index";
	}
	
	@RequestMapping("/signup")
	public String signup()
	{
		return "signup";
	}
}

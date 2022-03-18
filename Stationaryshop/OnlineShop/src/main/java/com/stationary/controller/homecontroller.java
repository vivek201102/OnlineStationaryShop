package com.stationary.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.stationary.dao.UserDao;
import com.stationary.entities.Address;
import com.stationary.entities.User;

@Controller
public class homecontroller {
	@Autowired
	private UserDao user;
	
	@RequestMapping("/")
	public String home()
	{
		return "login";
	}
	
	@RequestMapping("/index")
	public String index()
	{
		return home();
	}
	
	@RequestMapping("/signup")
	public String signup()
	{
		return "signup";
	}
	
	@RequestMapping("/login")
	public String login()
	{
		return "login";
	}
	
	@RequestMapping(path = "/adduser",method = RequestMethod.POST)
	public String saveUser(@RequestParam("name") String name,
						 @RequestParam("email") String email,
						 @RequestParam("mobile") String mobile,
						 @RequestParam("hNo") String hno,
						 @RequestParam("add1") String add1,
						 @RequestParam("add2") String add2,
						 @RequestParam("city") String city,
						 @RequestParam("pincode") String zip,
						 @RequestParam("password") String psw, Model model)
	{
		User duplicate = user.getOneObj(email);
		if(duplicate == null)
		{
		Address a = new Address(hno,add1,add2,city,zip);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();
		   String date = dtf.format(now);
		User u = new User(name,psw,mobile,email,date,a);
		u.setAddress(a);
		user.insertObj(u);
		return "login";
		}
		else {
			model.addAttribute("error", "user with this email already exists!!!");
			return "signup";
		}
	}
	
	@RequestMapping("/checkuser")
	private String check(@RequestParam("email") String email, @RequestParam("password") String psw, Model model)
	{
		User u = user.getUser(email, psw);
		if(u == null)
		{
			model.addAttribute("error", "User not Found!!!");
			return "login";
		}
		else
		{
		
			model.addAttribute("user", u);
			return "index";
		}
		
	}
}

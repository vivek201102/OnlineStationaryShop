package com.stationary.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.stationary.Items.*;
import com.stationary.dao.*;
import com.stationary.entities.User;

@Controller
public class admincontroller {
	@Autowired
	BookDao bookdao;
	
	@Autowired
	PenDao pendao;
	
	@Autowired
	DeskDao deskdao;
	
	@Autowired
	CalcDao calcdao;
	
	@Autowired
	UserDao userdao;
	
	@Autowired
	Orderdetaildao orderdao;
	

	
	@RequestMapping("/admin-customer")
	public ModelAndView adminCus(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		User u =(User) session.getAttribute("user");
		if(u == null)
		{
			return new ModelAndView("login");
		}
		List<User> users = userdao.getNormal();
		ArrayList<Integer> count = new ArrayList<Integer>();
		for(User us: users)
		{
			count.add(orderdao.getCount(us.getId()));
		}
		ModelAndView model = new ModelAndView("displayCustomer");
		model.addObject("users", users);
		model.addObject("count", count);
		return model;
	}
	
	@RequestMapping(path = "/admin-product")
	public ModelAndView adminprod(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		User u =(User) session.getAttribute("user");
		if(u == null)
		{
			return new ModelAndView("login");
		}
		List<Book> books = this.bookdao.getall();
		List<Pen> pens = this.pendao.getall();
		List<Desk> desks = this.deskdao.getall();
		List<Calc> calc = this.calcdao.getall();
		ModelAndView model = new ModelAndView("displayProd");
		model.addObject("books", books);
		model.addObject("pens", pens);
		model.addObject("desks", desks);
		model.addObject("calcs", calc);
		return model;
	}
	
	@RequestMapping(path = "/addbook", method = RequestMethod.POST)
	public ModelAndView addBook(
			@ModelAttribute("book") Book book
			,HttpServletRequest request) throws IOException
	{
		HttpSession session = request.getSession();
		User u =(User) session.getAttribute("user");
		if(u == null)
		{
			return new ModelAndView("login");
		}
		bookdao.insertObj(book);
		return new ModelAndView("redirect:" + "dashboard");
	}
	
	
	@RequestMapping(path = "/addpen", method = RequestMethod.POST)
	public ModelAndView addPen(
		@ModelAttribute("pen") Pen pen
			,HttpServletRequest request) throws IOException
	{
		HttpSession session = request.getSession();
		User u =(User) session.getAttribute("user");
		if(u == null)
		{
			return new ModelAndView("login");
		}
		pendao.insertObj(pen);
		return new ModelAndView("redirect:" + "dashboard");
	}
	
	@RequestMapping(path = "/adddesk", method = RequestMethod.POST)
	public ModelAndView addDesk(
			@ModelAttribute("desk") Desk desk
		, HttpServletRequest request) throws IOException
	{
		HttpSession session = request.getSession();
		User u =(User) session.getAttribute("user");
		if(u == null)
		{
			return new ModelAndView("login");
		}
		deskdao.insertObj(desk);
		return new ModelAndView("redirect:" + "dashboard");
	}
	
	
	@RequestMapping(path = "/addcalc", method = RequestMethod.POST)
	public ModelAndView addCalc(
			@ModelAttribute("calc") Calc calc
			, HttpServletRequest request) throws IOException
	{
		HttpSession session = request.getSession();
		User u =(User) session.getAttribute("user");
		if(u == null)
		{
			return new ModelAndView("login");
		}
		calcdao.insertObj(calc);
		return new ModelAndView("redirect:" + "dashboard");
	}
	
	@RequestMapping("/deletebook")
	public ModelAndView removeBook(@RequestParam("pid") String pid, HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		User u =(User) session.getAttribute("user");
		if(u == null)
		{
			return new ModelAndView("login");
		}
		int id = Integer.parseInt(pid);
		Book b = bookdao.getOneObj(id);
		bookdao.deleteObj(b);
		return new ModelAndView("redirect:" + "dashboard");
	}
	
	@RequestMapping("/deletepen")
	public ModelAndView removePen(@RequestParam("pid") String pid, HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		User u =(User) session.getAttribute("user");
		if(u == null)
		{
			return new ModelAndView("login");
		}
		int id = Integer.parseInt(pid);
		Pen p = pendao.getOneObj(id);
		pendao.deleteObj(p);
		return new ModelAndView("redirect:" + "dashboard");
	}
	
	@RequestMapping("/deletedesk")
	public ModelAndView removeDesk(@RequestParam("pid") String pid, HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		User u =(User) session.getAttribute("user");
		if(u == null)
		{
			return new ModelAndView("login");
		}
		int id = Integer.parseInt(pid);
		Desk d = deskdao.getOneObj(id);
		deskdao.deleteObj(d);
		return new ModelAndView("redirect:" + "dashboard");
	}
	
	@RequestMapping("/deletecalc")
	public ModelAndView removeCalc(@RequestParam("pid") String pid, HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		User u =(User) session.getAttribute("user");
		if(u == null)
		{
			return new ModelAndView("login");
		}
		int id = Integer.parseInt(pid);
		Calc c = calcdao.getOneObj(id);
		calcdao.deleteObj(c);
		return new ModelAndView("redirect:dashboard");
	}
	
	@RequestMapping("/updatebookform")
	public String updateBookform(@RequestParam("pid") String pid, Model model)
	{
		
		int id = Integer.parseInt(pid);
		Book b = bookdao.getOneObj(id);
		model.addAttribute("book", b);
		return "updatebook";
	}
	
	@RequestMapping("/updatebook")
	public ModelAndView updateBook(@ModelAttribute("book") Book book)
	{
		bookdao.updateObj(book);
		return new ModelAndView("redirect:dashboard");
	}
	
	@RequestMapping("/updatepenform")
	public String updatePenform(@RequestParam("pid") String pid, Model model)
	{
		int id = Integer.parseInt(pid);
		Pen p = pendao.getOneObj(id);
		model.addAttribute("pen", p);
		return "updatepen";
	}
	
	@RequestMapping("/updatepen")
	public ModelAndView updatePen(@ModelAttribute("pen") Pen pen)
	{
		pendao.updateObj(pen);
		return new ModelAndView("redirect:dashboard");
	}
	
	@RequestMapping("/updatedeskform")
	public String updateDeskform(@RequestParam("pid") String pid, Model model)
	{
		int id = Integer.parseInt(pid);
		Desk d = deskdao.getOneObj(id);
		model.addAttribute("desk", d);
		return "updatedesk";
	}
	
	@RequestMapping("/updatedesk")
	public ModelAndView updateDesk(@ModelAttribute("desk") Desk desk)
	{
		deskdao.updateObj(desk);
		return new ModelAndView("redirect:dashboard");
	}
	
	@RequestMapping("/updatecalcform")
	public String updateCalcform(@RequestParam("pid") String pid, Model model)
	{
		int id = Integer.parseInt(pid);
		Calc c = calcdao.getOneObj(id);
		model.addAttribute("calc", c);
		return "updatecalc";
	}
	
	@RequestMapping("/updatecalc")
	public ModelAndView updateCalc(@ModelAttribute("calc") Calc calc)
	{
		calcdao.updateObj(calc);
		return new ModelAndView("redirect:dashboard");
	}
	
	@RequestMapping("/addprod")
	public ModelAndView addprod(@ModelAttribute("prod") String prod)
	{
		ModelAndView model;
		if(prod.equals("book"))
		{
			model = new ModelAndView("add-book");
		}
		else if(prod.equals("pen"))
		{
			model = new ModelAndView("add-pen");
		}
		else if(prod.equals("desk"))
		{
			model = new ModelAndView("add-desk");
		}
		else {
			model = new ModelAndView("add-calc");
		}
		
		return model;
	}
	
	
}

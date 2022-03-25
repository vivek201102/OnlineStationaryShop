package com.stationary.controller;

import java.io.IOException;
import java.util.List;

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
	
	@RequestMapping("/bookform")
	public String bookForm()
	{
		return "add-book";
	}
	
	@RequestMapping("/penform")
	public String penForm()
	{
		return "add-pen";
	}
	
	@RequestMapping("/calcform")
	public String calcForm()
	{
		return "add-calc";
	}
	
	@RequestMapping("/deskform")
	public String deskForm()
	{
		return "add-desk";
	}
	
	@RequestMapping(path = "/admin")
	public ModelAndView admin()
	{
		List<Book> books = this.bookdao.getall();
		List<Pen> pens = this.pendao.getall();
		List<Desk> desks = this.deskdao.getall();
		List<Calc> calc = this.calcdao.getall();
		ModelAndView model = new ModelAndView("admin-product");
		model.addObject("books", books);
		model.addObject("pen", pens);
		model.addObject("desk", desks);
		model.addObject("calc", calc);
		return model;
	}
	
	@RequestMapping(path = "/addbook", method = RequestMethod.POST)
	public ModelAndView addBook(
			@ModelAttribute("book") Book book
			) throws IOException
	{
		bookdao.insertObj(book);
		return new ModelAndView("redirect:" + "admin");
	}
	
	
	@RequestMapping(path = "/addpen", method = RequestMethod.POST)
	public ModelAndView addPen(
		@ModelAttribute("pen") Pen pen
			) throws IOException
	{
		pendao.insertObj(pen);
		return new ModelAndView("redirect:" + "admin");
	}
	
	@RequestMapping(path = "/adddesk", method = RequestMethod.POST)
	public ModelAndView addDesk(
			@ModelAttribute("desk") Desk desk
		) throws IOException
	{
		deskdao.insertObj(desk);
		return new ModelAndView("redirect:" + "admin");
	}
	
	
	@RequestMapping(path = "/addcalc", method = RequestMethod.POST)
	public ModelAndView addCalc(
			@ModelAttribute("calc") Calc calc
			) throws IOException
	{
		calcdao.insertObj(calc);
		return new ModelAndView("redirect:" + "admin");
	}
	
	@RequestMapping("/deletebook")
	public ModelAndView removeBook(@RequestParam("pid") String pid)
	{
		int id = Integer.parseInt(pid);
		Book b = bookdao.getOneObj(id);
		bookdao.deleteObj(b);
		return new ModelAndView("redirect:" + "admin");
	}
	
	@RequestMapping("/deletepen")
	public ModelAndView removePen(@RequestParam("pid") String pid)
	{
		int id = Integer.parseInt(pid);
		Pen p = pendao.getOneObj(id);
		pendao.deleteObj(p);
		return new ModelAndView("redirect:" + "admin");
	}
	
	@RequestMapping("/deletedesk")
	public ModelAndView removeDesk(@RequestParam("pid") String pid)
	{
		int id = Integer.parseInt(pid);
		Desk d = deskdao.getOneObj(id);
		deskdao.deleteObj(d);
		return new ModelAndView("redirect:" + "admin");
	}
	
	@RequestMapping("/deletecalc")
	public ModelAndView removeCalc(@RequestParam("pid") String pid)
	{
		int id = Integer.parseInt(pid);
		Calc c = calcdao.getOneObj(id);
		calcdao.deleteObj(c);
		return new ModelAndView("redirect:admin");
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
		return new ModelAndView("redirect:admin");
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
		return new ModelAndView("redirect:admin");
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
		return new ModelAndView("redirect:admin");
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
		return new ModelAndView("redirect:admin");
	}
	
}

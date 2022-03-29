package com.stationary.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.stationary.Items.Book;
import com.stationary.Items.Calc;
import com.stationary.Items.Desk;
import com.stationary.Items.Pen;
import com.stationary.dao.AdminDao;
import com.stationary.dao.BookDao;
import com.stationary.dao.CalcDao;
import com.stationary.dao.DeskDao;
import com.stationary.dao.PenDao;
import com.stationary.dao.UserCartDao;
import com.stationary.dao.UserDao;
import com.stationary.entities.Address;
import com.stationary.entities.User;
import com.stationary.order.UserCart;



@Controller
public class homecontroller {
	
	@Autowired
	private AdminDao admindao;

	@Autowired
	private UserDao user;
	
	@Autowired
	private BookDao bookdao;
	
	@Autowired
	private DeskDao deskdao;
	
	@Autowired
	private PenDao pendao;
	
	@Autowired
	private CalcDao calcdao;
	
	@Autowired
	private UserCartDao usercartdao;
	
	@RequestMapping("/")
	public String homefun()
	{
		return "login";
	}
	
	@RequestMapping("/admin")
	public ModelAndView adminpage()
	{
		ModelAndView model = new ModelAndView("admin-product");
		List<Book> books = bookdao.getall();
		List<Pen> pens = pendao.getall();
		List<Desk> desks = deskdao.getall();
		List<Calc> calcs = calcdao.getall();
		model.addObject("books", books);
		model.addObject("pens", pens);
		model.addObject("desks", desks);
		model.addObject("calcs", calcs);
		return model;
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
	public ModelAndView saveUser(@RequestParam("name") String name,
						 @RequestParam("email") String email,
						 @RequestParam("mobile") String mobile,
						 @RequestParam("hNo") String hno,
						 @RequestParam("add1") String add1,
						 @RequestParam("add2") String add2,
						 @RequestParam("city") String city,
						 @RequestParam("pincode") String zip,
						 @RequestParam("password") String psw)
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
		ModelAndView model = new ModelAndView("redirect:login");
		return model;
		}
		else {
			ModelAndView model = new ModelAndView("signup");
			model.addObject("error", "user with this email already exists!!!");
			return model;
		}
	}
	
	@RequestMapping("book")
	public ModelAndView prodbook(HttpServletRequest request)
	{
		try {
		ModelAndView model = new ModelAndView("book");
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		
		List<Book> book;
		List<UserCart> usercart;
		usercart = usercartdao.getcart(u.getId());
		book = bookdao.getall();
		model.addObject("cartitem", usercart);
		model.addObject("books", book);
		return model;
		}
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
			return new ModelAndView("login");
		}
	}
	
	@RequestMapping("calc")
	public ModelAndView prodcalc(HttpServletRequest request)
	{
		try {
		ModelAndView model = new ModelAndView("calc");
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		List<Calc> calc;
		List<UserCart> usercart;
		usercart = usercartdao.getcart(u.getId());
		calc = calcdao.getall();
		model.addObject("cartitem", usercart);
		model.addObject("calcs", calc);
		return model;
		}
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
			return new ModelAndView("login");
		}
	}
	
	@RequestMapping("desk")
	public ModelAndView proddesk(HttpServletRequest request)
	{
		try {
			
		ModelAndView model = new ModelAndView("desk");
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");

		List<Desk> desk;
		List<UserCart> usercart;
		usercart = usercartdao.getcart(u.getId());
		desk = deskdao.getall();
		model.addObject("cartitem", usercart);
		model.addObject("desks", desk);
		return model;
		}
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
			return new ModelAndView("login");
		}
	}
	
	@RequestMapping("pen")
	public ModelAndView prodpen(HttpServletRequest request)
	{
		try {
		ModelAndView model = new ModelAndView("pen");
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		
		List<Pen> pen;
		List<UserCart> usercart;
		usercart = usercartdao.getcart(u.getId());
		pen = pendao.getall();
		model.addObject("cartitem", usercart);
		model.addObject("pens", pen);
		return model;
		}
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
			return new ModelAndView("login");
		}
	}
	
	@RequestMapping(path="home")
	public ModelAndView home(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("user");
		if(u == null)
		{
			return new ModelAndView("login");
		}
		ModelAndView model = new ModelAndView("home");

		return model;
	}
	
	@RequestMapping(path="/checkuser", method=RequestMethod.POST)
	private ModelAndView check(@RequestParam("email") String email, @RequestParam("password") String psw, HttpServletRequest request)
	{
		User u = user.getUser(email, psw);
		if(u == null)
		{
			ModelAndView model =new ModelAndView("login");
			model.addObject("error", "User not Found!!!");
			return model;
		}
		else
		{
			
			int ad = admindao.getAdmin(u);
			ModelAndView model;
			if(ad == 1)
			{
				model = new ModelAndView("redirect:dashboard");
			}
			else
			{
				model = new ModelAndView("redirect:home");
			}
			HttpSession session = request.getSession();
			session.setAttribute("user", u);
			return model;
		}
		
	}
	
	@RequestMapping("/allprod")
	private ModelAndView allprod(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		if(u== null)
			return new ModelAndView("login");
		ModelAndView model = new ModelAndView("products");
		List<Book> books = bookdao.getall();
		List<Pen> pens = pendao.getall();
		List<Desk> desks = deskdao.getall();
		List<Calc> calcs = calcdao.getall();
		model.addObject("books", books);
		model.addObject("pens", pens);
		model.addObject("desks", desks);
		model.addObject("calcs", calcs);
		return model;
	}
	
	@RequestMapping("/logout")
	private ModelAndView logout(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		session.invalidate();
		return new ModelAndView("login");
	}
	
	@RequestMapping("/dashboard")
	public ModelAndView dash()
	{
		int usercount = user.countCus();
		int prodcount = bookdao.countBook() + calcdao.countCalc() + deskdao.countDesk() + pendao.countPen();
		ModelAndView model = new ModelAndView("dashboard");
		model.addObject("cuscount", usercount);
		model.addObject("prodcount", prodcount);
		return model;
	}
}

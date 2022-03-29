package com.stationary.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.stationary.Items.Book;
import com.stationary.Items.Calc;
import com.stationary.Items.Desk;
import com.stationary.Items.Pen;
import com.stationary.dao.BookDao;
import com.stationary.dao.CalcDao;
import com.stationary.dao.CartGenerateDao;
import com.stationary.dao.DeskDao;
import com.stationary.dao.Orderdetaildao;
import com.stationary.dao.PenDao;
import com.stationary.dao.UserCartDao;
import com.stationary.entities.User;
import com.stationary.order.CartGenerate;
import com.stationary.order.Orderdetail;
import com.stationary.order.UserCart;

@Controller
public class ordercontroller {
	
	@Autowired
	private CartGenerateDao generatedao;
	
	@Autowired
	private UserCartDao usercartdao;
	
	@Autowired
	private Orderdetaildao orderdao;
	
	@Autowired
	private BookDao bookdao;
	
	@Autowired
	private PenDao pendao;
	
	@Autowired
	private DeskDao deskdao;
	
	@Autowired
	private CalcDao calcdao;
	
	@RequestMapping(path="/addtocart", method=RequestMethod.POST)
	@ResponseBody
	public String addtocart(@RequestParam("name") String name, @RequestParam("id") String id, @RequestParam("price") int price, @RequestParam("qty") int qty, @RequestParam("image") String image,HttpServletRequest request)
	{
		try {
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		CartGenerate cart = generatedao.getCart(u.getId());
		if(cart == null)
		{
			cart = new CartGenerate();
			cart.setUserId(u.getId());
			cart.setCartdate(new Date().toString());
			generatedao.insertCart(cart);
			UserCart usercart = new UserCart();
			usercart.setUserId(u.getId());
			usercart.setCartId(cart.getId());
			usercart.setDatetime(new Date().toString());
			usercart.setProdCount(qty);
			usercart.setProdId(id);
			usercart.setProdName(name);
			usercart.setProdPrice(price);
			usercart.setProdTotal(price);
			usercart.setProdImage(image);
			usercartdao.insertCart(usercart);
			return "done";
		}
		else {
			boolean check = usercartdao.checkCart(cart.getId(),id);
			if(check == true)
			{
				return "in cart";
			}
			
			else
			{	
				UserCart usercart = new UserCart();
				usercart.setUserId(u.getId());
				usercart.setCartId(cart.getId());
				usercart.setDatetime(new Date().toString());
				usercart.setProdCount(qty);
				usercart.setProdId(id);
				usercart.setProdName(name);
				usercart.setProdPrice(price);
				usercart.setProdImage(image);
				usercart.setProdTotal(price);
				usercartdao.insertCart(usercart);
				
				return "done";
			}
		}
		}
		catch(Exception e)
		{
			return "not-done";
		}
	}
	
	
	
	@RequestMapping("/cart")
	public ModelAndView showCart(HttpServletRequest request)
	{
		try {
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		CartGenerate cart = generatedao.getCart(u.getId());
		List<UserCart> usercart;
		if(cart != null)
		{
			session.setAttribute("cartgenerate", cart);
			usercart = usercartdao.getcurrentCart(cart.getId(), u.getId());
		}
		else
		{
			usercart = null;
		}
		ModelAndView model = new ModelAndView("cart");
		model.addObject("usercart", usercart);
		return model;
		}
		
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
			return new ModelAndView("login");
		}
	}
	
	
	@RequestMapping("bill")
	public ModelAndView genratebill(HttpServletRequest request)
	{
		try {
		ModelAndView model = new ModelAndView("invoice");
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		CartGenerate cart = (CartGenerate) session.getAttribute("cartgenerate");
		List<UserCart> usercart = usercartdao.getcurrentCart(cart.getId(), u.getId());
		Orderdetail od = new Orderdetail();
		od.setCartId(cart.getId());
		od.setOrderingDate(new Date().toString());
		od.setUserId(u.getId());
		od.setitemPerOrder(usercart);
		od.setMyOrderId(Integer.toString(cart.getId()), Integer.toString(u.getId()));
		od.calTot();
		od.grandTotaol();
		generatedao.delete(cart);
		orderdao.insertOrder(od);
		Orderdetail nod = orderdao.getcurrent(u.getId(), cart.getId());
		od.setId(nod.getId());
		
		for(UserCart myitem: usercart)
		{
			Book book = bookdao.getById(myitem.getProdId());
			if(book != null)
			{
				int newStock = book.getStock() - myitem.getProdCount();
				book.setStock(newStock);
				bookdao.updateObj(book);
			}
			else {
				Pen pen = pendao.getById(myitem.getProdId());
				if(pen != null)
				{
					int newStock = pen.getStock() - myitem.getProdCount();
					pen.setStock(newStock);
					pendao.updateObj(pen);
				}
				
				else {
					Desk desk = deskdao.getById(myitem.getProdId());
					if(desk != null)
					{
						int newStock = desk.getStock() - myitem.getProdCount();
						desk.setStock(newStock);
						deskdao.updateObj(desk);
					}
					
					else {
						Calc calc = calcdao.getById(myitem.getProdId());
						int newStock = calc.getStock() - myitem.getProdCount();
						calc.setStock(newStock);
						calcdao.updateObj(calc);
					}
				}
			}
		}
		
		model.addObject("bill", od);
		model.addObject("user", u);
		model.addObject("cartItem", usercart);
		return model;
		}
		catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			ModelAndView model = new ModelAndView("invoice");
			HttpSession session = request.getSession();
			User u = (User) session.getAttribute("user");
			CartGenerate cart = (CartGenerate) session.getAttribute("cartgenerate");
			List<UserCart> usercart = usercartdao.getcurrentCart(cart.getId(), u.getId());
			Orderdetail od = new Orderdetail();
			od.setCartId(cart.getId());
			od.setOrderingDate(new Date().toString());
			od.setUserId(u.getId());
			od.setitemPerOrder(usercart);
			od.setMyOrderId(Integer.toString(cart.getId()), Integer.toString(u.getId()));
			od.calTot();
			od.grandTotaol();
			Orderdetail nod = orderdao.getcurrent(u.getId(), cart.getId());
			od.setId(nod.getId());
			model.addObject("bill", od);
			model.addObject("user", u);
			model.addObject("cartItem", usercart);
			return model;
			
		}
	}
	
	@RequestMapping("/changeQty")
	@ResponseBody
	public String increment(@RequestParam("id") String id, @RequestParam("qty") int qty, @RequestParam("price") int price, HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		CartGenerate cart = (CartGenerate) session.getAttribute("cartgenerate");
		System.out.println(cart.getId());
		int x = usercartdao.incrementItem(cart.getId(), id, qty, price);
		if(x==1)
		{
		return "done";
		}
		else {
			return "not done";
		}
	}
	
	
	@RequestMapping("/deleteQty")
	@ResponseBody
	public String deleteItem(@RequestParam("id") String id, HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		CartGenerate cart = (CartGenerate) session.getAttribute("cartgenerate");
		int x = usercartdao.deleteItem(cart.getId(), id);
		return "done";
	}
	
	
	@RequestMapping("/history")
	public ModelAndView allOrder(HttpServletRequest request)
	{
		try {
		ModelAndView model = new ModelAndView("allorder");
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("user");
		List<Orderdetail> od = orderdao.getorder(u.getId());
		for(Orderdetail o: od)
		{
			List<UserCart> uc = usercartdao.getcurrentCart(o.getCartId(), u.getId());
			o.setitemPerOrder(uc);
		}
		model.addObject("history", od);
		model.addObject("user", u);
		return model;
		}
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
			return new ModelAndView("login");
		}
	}
}

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

import com.stationary.dao.CartGenerateDao;
import com.stationary.dao.UserCartDao;
import com.stationary.entities.User;
import com.stationary.order.CartGenerate;
import com.stationary.order.UserCart;

@Controller
public class ordercontroller {
	
	@Autowired
	private CartGenerateDao generatedao;
	
	@Autowired
	private UserCartDao usercartdao;
	
	@RequestMapping(path="/addtocart", method=RequestMethod.POST)
	@ResponseBody
	public String addtocart(@RequestParam("name") String name, @RequestParam("id") String id, @RequestParam("price") int price, @RequestParam("qty") int qty, HttpServletRequest request)
	{
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
				usercartdao.insertCart(usercart);
				return "done";
			}
		}
	}
	
	
	
	@RequestMapping("/cart")
	public ModelAndView showCart(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		CartGenerate cart = generatedao.getCart(u.getId());
		session.setAttribute("cartgenrate", cart);
		List<UserCart> usercart = usercartdao.getcart(u.getId());
		ModelAndView model = new ModelAndView("cart");
		model.addObject("usercart", usercart);
		return model;
	}
	
	
	@RequestMapping("/changeQty")
	@ResponseBody
	public String increment(@RequestParam("id") String id, @RequestParam("qty") int qty, HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		CartGenerate cart = (CartGenerate) session.getAttribute("cartgenrate");
		int x = usercartdao.incrementItem(cart.getId(), id, qty);
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
		CartGenerate cart = (CartGenerate) session.getAttribute("cartgenrate");
		int x = usercartdao.deleteItem(cart.getId(), id);
		return "done";
	}
}

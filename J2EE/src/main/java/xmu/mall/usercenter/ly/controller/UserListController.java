package xmu.mall.usercenter.ly.controller;

import javax.mail.Session;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import xmu.mystore.ordersmgt.zf.service.OrderService;

@Controller
@RequestMapping(value="/user")
public class UserListController
{
	@Autowired
	@Qualifier("orderService")
	private OrderService orderService;
	
	@RequestMapping(value="/alllist")
	public String alllist(Model model)
	{
		model.addAttribute("mylist", orderService.getOrderByUser_id(1));
		return "ly/listview";
	}
	@RequestMapping(value="/waitpay")
	public String waitpay(Model model,HttpSession session)
	{
		model.addAttribute("mylist",orderService.getOrderByStatus(1,0));
		session.setAttribute("userId", 1);
		return "ly/waitpayview";
	}
	@RequestMapping(value="/waittake")
	public String waittake(Model model)
	{
		model.addAttribute("mylist",orderService.getOrderByStatus(1,3));
		return "ly/waittakeview";
	}
	@RequestMapping(value="/havetake")
	public String havetake(Model model)
	{
		model.addAttribute("mylist",orderService.getOrderByStatus(1,4));
		return "ly/listview";
	}
	@RequestMapping(value="delete1")
	public String delete1(Model model)
	{
		model.addAttribute("mylist", orderService.getOrderByStatus(1,5));
		return "ly/listview";
	}
	@RequestMapping(value="/deletelist")
	public String deletelist(Model model,String a)
	{
		long l = Long.parseLong(a);
		orderService.cancelOrder(l);
		model.addAttribute("mylist", orderService.getOrderByUser_id(1));
		return "ly/listview";
	}
	@RequestMapping(value="/surelist")
	public String surelist(Model model,String a)
	{
		long l = Long.parseLong(a);
		orderService.receiveOrder(l);
		model.addAttribute("mylist", orderService.getOrderByUser_id(1));
		return "ly/listview";
	}
}

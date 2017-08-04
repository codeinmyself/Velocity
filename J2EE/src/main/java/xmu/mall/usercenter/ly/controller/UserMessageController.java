package xmu.mall.usercenter.ly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import xmu.mall.usercenter.ly.service.IUsersService;

@Controller
@RequestMapping(value="/user")
public class UserMessageController
{
	long b=0;
	
	@Autowired
	@Qualifier("IUsersServiceImpl")
	private IUsersService iusersservice;
	
	@RequestMapping(value="/messagemanage")
	public String messagemanage(Model model)
	{
		model.addAttribute("mymessage", iusersservice.getUserByUserId((long) 1));
		return "ly/managemessageview";
	}
	
	@RequestMapping(value="/messagemanage1")
	public String messagemanage1(Model model,String un,String nn,String mt,String ip)
	{
		iusersservice.updateu(b, un, nn, mt, ip);
		return "ly/managemessageview";
	}
	@RequestMapping(value="/changemessage")
	public String changemessage(Model model,String a)
	{
		b=Long.parseLong(a);
		return "ly/changemessageview";
	}
}

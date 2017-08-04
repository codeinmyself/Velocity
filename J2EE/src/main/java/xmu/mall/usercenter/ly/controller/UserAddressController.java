package xmu.mall.usercenter.ly.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import xmu.mall.usercenter.ly.model.User_address;
import xmu.mall.usercenter.ly.model.tran;
import xmu.mall.usercenter.ly.service.User_addressService;
import xmu.mall.usercenter.ly.service.regionService;

@Controller
@RequestMapping(value="/user")
public class UserAddressController
{
	@Autowired
	@Qualifier("AddressService")
	private User_addressService user_addressservice;
	
	@Autowired
	@Qualifier("regionServiceImpl")
	private regionService regionservice;
	
	@RequestMapping(value="/addressmanage")
	public String addressmanage(Model model)
	{
		model.addAttribute("myaddress",user_addressservice.getAddressByUid((long)1));
		return "ly/manageaddressview";
	}
}

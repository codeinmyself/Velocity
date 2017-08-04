package xmu.mall.usercenter.ly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import xmu.mall.usercenter.ly.service.User_collect_goodsService;

@Controller
@RequestMapping(value="/user/home")
public class UserCenterController
{
	@RequestMapping(value="")
	public String center(Model model)
	{
		return "ly/usercenterview";
	}
}
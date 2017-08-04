package xmu.mystore.securitymgt.yzh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xmu.mystore.securitymgt.yzh.annotation.HasAuthority;

@Controller
@RequestMapping(value = "/MallMgt")
public class MallController {

	@RequestMapping(method = RequestMethod.GET)
	//@HasAuthority(tableName="users", operator="*")
	public String home() {
		return "/yzh/manager";
	}
	
	@RequestMapping(value="/403", method = RequestMethod.GET)
	public String errorHome() {
		return "/yzh/MallMgt403";
	}
}

package xmu.mystore.home.zyt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value="home")
public class HomeController {
	
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public String home() {
		return "zyt/home";
	}
}

package xmu.mystore.goodsmgt.lcf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/GoodsMgt")
public class GoodsMgtController {

	@RequestMapping(method = RequestMethod.GET)
	public String home() {
		return "/lcf/manager";
	}
}

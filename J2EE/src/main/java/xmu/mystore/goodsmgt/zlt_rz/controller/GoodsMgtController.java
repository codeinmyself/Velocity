package xmu.mystore.goodsmgt.zlt_rz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author zhenglongtian
 *
 */
@Controller
@RequestMapping(value = "/GoodsMgt")
public class GoodsMgtController {

	@RequestMapping(method = RequestMethod.GET)
	public String home() {
		return "/zlt/manager";
	}
}

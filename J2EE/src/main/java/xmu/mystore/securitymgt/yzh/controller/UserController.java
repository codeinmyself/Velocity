package xmu.mystore.securitymgt.yzh.controller;

import java.util.List;

import org.junit.runners.Parameterized.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import xmu.mystore.logmgt.yzh.annotation.ControllerLogger;
import xmu.mystore.securitymgt.yzh.model.User;
import xmu.mystore.securitymgt.yzh.service.UserService;
import xmu.mystore.securitymgt.yzh.service.UserTypeService;


@Controller
@RequestMapping(value = "/MallMgt/User")
public class UserController {
	@Autowired
	@Qualifier("142528_userService")
	private UserService userService;

	@Autowired
	private UserTypeService userTypeService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ControllerLogger(description="查看用户信息", operatorObeject="UserInfo")
	public String allUsersPage(Model model) {
		List<User> userList = userService.getAllUsers();
		model.addAttribute("userList", userList);
		return "/yzh/allUsers";
	}
	
	
	@RequestMapping(value="/changeUserState", method = RequestMethod.GET)
	@ControllerLogger(description="修改用户状态", operatorObeject="UserState")
	public String changeUserState(@RequestParam("id") Long user_id, Model model) {
		userService.changeUserStateById(user_id);
		return "redirect:/MallMgt/User";
	}
}

package xmu.mystore.securitymgt.yzh.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xmu.mystore.logmgt.yzh.annotation.ControllerLogger;
import xmu.mystore.securitymgt.yzh.model.User;
import xmu.mystore.securitymgt.yzh.service.UserService;
import xmu.mystore.securitymgt.yzh.service.UserTypeService;

@Controller
@RequestMapping(value="loginSuccessDispatch")
public class LoginSuccessDispatch {
	
	@Autowired
	@Qualifier("142528_userService")
	private UserService userService;

	@Autowired
	private UserTypeService userTpeService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	@ControllerLogger(description="根据用户信息跳转到页面", operatorObeject="dispatcher")
	public String dispatcher(HttpServletRequest request, Model model)
	{
		HttpSession session = request.getSession();
		SecurityContextImpl securityContextImpl = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
		String name = securityContextImpl.getAuthentication().getName();
		User user = userService.findUserByUsername(name);
		Long user_id =  user.getUser_id();
		session.setAttribute("userId", user_id);//设置用户session
		
		String userType = user.getUser_type();
		session.setAttribute("user_type", userType);
		
		System.out.println(name+"loginSucceed");
		if(userType.equals("normal_user")){
			return "redirect:/";
		} else if(userType.equals("admin")){
			return "redirect:/GoodsMgt";	
		} else {
			return "redirect:/MallMgt/";
		}
	}
}

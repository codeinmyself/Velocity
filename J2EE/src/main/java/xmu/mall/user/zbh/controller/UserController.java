package xmu.mall.user.zbh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xmu.mall.user.zbh.encrypt.MD5Encrypt;
import xmu.mall.user.zbh.model.User;
import xmu.mall.user.zbh.service.UserService;


@Controller
@RequestMapping(value="/")
public class UserController {
	@Autowired
	@Qualifier("142537_userService")
	private UserService userService;
	
	@RequestMapping("/test")
	public String showUserList(Model model){
		
		return "zbh/test";
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request,HttpServletResponse response){
		
		return "zbh/login";
	}
	
	@RequestMapping(value="/loginConfirm",method=RequestMethod.POST)
	public String loginConfirm(Model model,HttpServletRequest request,HttpServletResponse response,String mobilePhone,String password) throws Exception{
		User user = userService.getUserByMobilePhoneAndPassword(mobilePhone,MD5Encrypt.getEncryptionString(password));
		if(user != null){
			//model.addAttribute(user.getUserId());
			
			HttpSession session = request.getSession(true);
			session.setAttribute("userId", user.getUserId());
			Object p = session.getAttribute("path");
			if(p!=null&&!p.toString().equals("")&&!p.toString().equals("/")){
				//return p.toString();
				session.removeAttribute("path");
				//System.out.println(p.toString());
				return "redirect:"+p.toString();
			}else{
				return "redirect:/";
			}
		}
		else
			return "zbh/loginFailure";
	}
	
	@RequestMapping("userRegister")
	public String jumpToRegister()
	{
		return "zbh/userRegister";
	}
	
	@RequestMapping(value="register",method=RequestMethod.POST)
	public String register(Model model,HttpServletRequest request,HttpServletResponse response,String password,String mobilePhone,String nickname) throws Exception{
		User u = new User();
		
		u.setMobilePhone(mobilePhone);
		u.setPassword(MD5Encrypt.getEncryptionString(password));
		u.setNickname(nickname);
	
		userService.insertUser(u);
		//return "test";
		User user = userService.getUserByMobilePhone(mobilePhone);
		//model.addAttribute("user",user);
		//model.addAttribute("userId", user.getUserId());
		//return "showOrderList";
		
		HttpSession session = request.getSession(true);
		session.setAttribute("userId", user.getUserId());
		Object p = session.getAttribute("path");
		if(p!=null&&!p.toString().equals("")&&!p.toString().equals("/")){
			//return p.toString();
			session.removeAttribute("path");
			//System.out.println(p.toString());
			return "redirect:"+p.toString();
		}else{
			return "redirect:/";
		}
		
	}

}

package xmu.mystore.user.zbh.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import xmu.mystore.user.zbh.encrypt.MD5Encrypt;
import xmu.mystore.user.zbh.model.User;
import xmu.mystore.user.zbh.service.UserService;


@Controller
@SessionAttributes({"userId"})
@RequestMapping(value="/")
public class UserController {
	@Resource
	private UserService userService;
	
	@RequestMapping("/test")
	public String showUserList(Model model){
		
		return "test";
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request,HttpServletResponse response){
		
		return "login";
	}
	
	@RequestMapping("/loginConfirm")
	public String loginConfirm(Model model,HttpServletRequest request,HttpServletResponse response,String mobilePhone,String password) throws Exception{
		User user = userService.getUserByMobilePhoneAndPassword(mobilePhone,MD5Encrypt.getEncryptionString(password));
		if(user != null){
			model.addAttribute(user.getUserId());
			
			HttpSession session = request.getSession(true);
			Object p = session.getAttribute("path");
			if(p!=null&&!p.toString().equals("")&&!p.toString().equals("/")){
				//return p.toString();
				return "redirect:http://localhost:8080/JavaEE"+p.toString();
			}else{
				return "homePage";
			}
		}
		else
			return "loginFailure";
	}
	
	@RequestMapping("userRegister")
	public String jumpToRegister()
	{
		return "userRegister";
	}
	
	@RequestMapping("register")
	public String register(Model model,HttpServletRequest request,HttpServletResponse response,String password,String mobilePhone,String nickname) throws Exception{
		User u = new User();
		
		u.setMobilePhone(mobilePhone);
		u.setPassword(MD5Encrypt.getEncryptionString(password));
		u.setNickname(nickname);
	
		userService.insertUser(u);
		//return "test";
		User user = userService.getUserByMobilePhone(mobilePhone);
		model.addAttribute("user",user);
		model.addAttribute("userId", user.getUserId());
		//return "showOrderList";
		
		HttpSession session = request.getSession(true);
		Object p = session.getAttribute("path");
		if(p!=null&&!p.toString().equals("")&&!p.toString().equals("/")){
			//return p.toString();
			return "redirect:http://localhost:8080/JavaEE"+p.toString();
		}else{
			return "homePage";
		}
		
	}

}

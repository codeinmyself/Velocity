package xmu.mystore.wx.zbh2.controller;

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

import xmu.mystore.wx.zbh2.model.User;
import xmu.mystore.wx.zbh2.service.UserService;

@Controller
@SessionAttributes({"userId","openid"})
@RequestMapping(value="/")
public class WxController {
	@Resource
	private UserService userService;
	/*
	@RequestMapping(method=RequestMethod.GET)
	public String showUserList(Model model){
		List<User> userList = userService.showAllUser();
		model.addAttribute("userList", userList);
		//return "showOrderList";
		return "showList";
	}
	*/
	@RequestMapping("/test")
	public String showUserList(Model model){
		
		return "test";
	}
	@RequestMapping(method=RequestMethod.GET)
	public String getOpenId(HttpServletRequest request,HttpServletResponse response){
		
		String s = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect"; 
		   s = s.replace("APPID", "wx41d5a8837cee2e1b");
		   s = s.replace("REDIRECT_URI", "http://www.zbh2537.club/JavaEE/getOpenId2");
		   s = s.replace("SCOPE", "snsapi_base");
		   return "redirect:"+s; 

	}
	
	@RequestMapping("/getOpenId2")
	public String GetOpenId2(Model model,HttpServletRequest request,HttpServletResponse response) throws Exception{
		String code = request.getParameter("code");
		   String s = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
		   s = s.replace("APPID", "wx41d5a8837cee2e1b");
		   s = s.replace("SECRET", "22ae63278f6b85b9b8c0be3a72d6c65a");
		   s = s.replace("CODE", code);
		  
		   	URI uri = new URI(s);
		   	SimpleClientHttpRequestFactory schr = new SimpleClientHttpRequestFactory();
			ClientHttpRequest chr = schr.createRequest(uri, HttpMethod.POST);
			ClientHttpResponse res = chr.execute();
			InputStream is = res.getBody(); //获得返回数据,注意这里是个流
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String str = "";
			String result = "";
			String openid = "";
			String userName= "";
			long userId = 0;

			/*
			//这个时候 用户的个人信息已经存储在br里面
			//下面是瞎几把处理- -。之为让你看见openid
			while((str = br.readLine())!=null){
				System.out.println(str);//获得页面内容或返回内容
				result+=str;
			}
			   return "redirect:"+result; 		  
			   */
		   
			while((str = br.readLine())!=null){
				System.out.println(str);//获得页面内容或返回内容
				JSONObject jsonParam = JSON.parseObject(str);
				Map<String,Object> resultMap = (Map<String,Object>)jsonParam;
				openid = (String)resultMap.get("openid");				
			}
			
			//model.addAttribute("openid", openid);
			
			User user = userService.getUserByOpenid(openid);
			if(user == null){
				model.addAttribute("openid",openid);
				
				return "register";
			}
			else {
				model.addAttribute("user", user);
				//userName =user.getUserName();
				userId = user.getUserId();
				model.addAttribute("openid", openid);
				model.addAttribute("userId", userId);
				//return "test";
				
				HttpSession session = request.getSession(true);
				Object p = session.getAttribute("path");
				if(p!=null&&!p.toString().equals("")&&!p.toString().equals("/")){
					//return p.toString();
					return "redirect:http://www.zbh2537.club/JavaEE"+p.toString();
				}else{
					return "myPage";
				}
				/*
				if(request.getServletPath().equals(p.toString()))
					return "myPage";
				else
					return p.toString();
				*/
				//return "myPage";
				//return "homepage";
			}
	}
	
	
	@RequestMapping("register")
	public String register(Model model,String userName,String realName,String mobilePhone,String address,String openid){
		User u = new User();
		u.setUserName(userName);
		u.setRealName(realName);
		u.setMobilePhone(mobilePhone);
		u.setAddress(address);
		u.setOpenid(openid);		
		userService.insertUser(u);
		//return "test";
		User user = userService.getUserByOpenid(openid);
		//String userName = user.getUserName();
		model.addAttribute("user",user);
		model.addAttribute("openid", openid);
		model.addAttribute("userId", user.getUserId());
		//return "showOrderList";
		
		//return "";
		//return "personalPage";
		String s = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect"; 
		   s = s.replace("APPID", "wx41d5a8837cee2e1b");
		   s = s.replace("REDIRECT_URI", "http://www.zbh2537.club/JavaEE/getOpenId2");
		   s = s.replace("SCOPE", "snsapi_base");
		   return "redirect:"+s; 
	}
	

	

}
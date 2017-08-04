package xmu.mall.usercenter.zf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import xmu.mall.usercenter.zf.model.User_collect_goods;
import xmu.mall.usercenter.zf.service.UserService;
import xmu.mystore.ordersmgt.zf.model.Users;

import javax.servlet.http.HttpServletRequest;


@Controller
public class UserController 
{
	@Autowired
	@Qualifier("userService")
	private UserService userSerive;
	
	// 首页
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(Model model)
	{
		Users user = this.userSerive.getUserById(1);
		
		model.addAttribute("user", user);
		return "myInfo";
	}
	
	// 用户信息页
	@RequestMapping(value="userInfo", method=RequestMethod.GET)
	public String userInfo(long uid, Model model)
	{
		Users user = this.userSerive.getUserById(uid);
		
		model.addAttribute("user", user);
		return "updateInfo";
	}
	
	// 用户设置
	@RequestMapping(value="userSetting", method=RequestMethod.GET)
	public String userSetting(long uid, Model model)
	{
		Users user = this.userSerive.getUserById(uid);
		
		model.addAttribute("user", user);
		return "setting";
	}

	// 账号与安全
	@RequestMapping(value="manageAccount", method=RequestMethod.GET)
	public String manageAccount(long uid, Model model)
	{
		Users user = this.userSerive.getUserById(uid);
		model.addAttribute("user", user);
		return "accountSafety";
	}
	
	// 更新昵称
	@RequestMapping(value="updateInfo", method=RequestMethod.GET)
	public String updateNickname(long uid, String type, Model model)
	{
		Users user = this.userSerive.getUserById(uid);
		model.addAttribute("user", user);
		model.addAttribute("type", type);
		return "updateAccount";
	}
	
	// 保存昵称
	@RequestMapping(value="saveNickName", method=RequestMethod.POST)
	public String saveNickName(HttpServletRequest request, Model model)
	{
		long uid = Long.parseLong(request.getParameter("uid"));
		String nickname = request.getParameter("info");
		Users user = this.userSerive.getUserById(uid);

		if(nickname != null && nickname != "" && !nickname.equals(user.getNickname())){
			this.userSerive.saveNickname(uid, nickname);
			user.setNickname(nickname);
		}

		model.addAttribute("user", user);
		return "updateInfo";
	}

	// 保存电话
	@RequestMapping(value="saveTel", method=RequestMethod.POST)
	public String saveTel(HttpServletRequest request, Model model)
	{
		long uid = Long.parseLong(request.getParameter("uid"));
		String tel = request.getParameter("info");
		Users user = this.userSerive.getUserById(uid);

		if(tel != null && tel != "" && !tel.equals(user.getNickname())){
			this.userSerive.saveTelephone(uid, tel);
			user.setMobile_phone(tel);
		}

		model.addAttribute("user", user);
		return "accountSafety";
	}

	// 保存密码
	@RequestMapping(value="savePwd", method=RequestMethod.POST)
	public String savePwd(HttpServletRequest request, Model model)
	{
		long uid = Long.parseLong(request.getParameter("uid"));
		String pwd = request.getParameter("info");
		Users user = this.userSerive.getUserById(uid);

		if(pwd != null && pwd != ""){
			this.userSerive.savePassword(uid, pwd);
			user.setPassword(pwd);
		}

		model.addAttribute("user", user);
		return "accountSafety";
	}
	
	// 查看收藏
	@RequestMapping(value="checkCollection", method=RequestMethod.GET)
	public String checkCollection(long uid, Model model)
	{
		List<User_collect_goods> collections = this.userSerive.getCollectionsById(uid);
		model.addAttribute("collections", collections);
		return "myCollection";
	}
	
	// 删除收藏
	@RequestMapping(value="deleteCollect", method=RequestMethod.GET)
	public String deleteCollect(long uid, long cid, Model model)
	{
		this.userSerive.deleteCollect(cid);
		
		Users user = this.userSerive.getUserById(uid);
		
		model.addAttribute("user", user);
		return "myInfo";
	}
}

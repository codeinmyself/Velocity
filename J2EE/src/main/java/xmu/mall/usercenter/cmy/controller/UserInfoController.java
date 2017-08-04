package xmu.mall.usercenter.cmy.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xmu.mall.usercenter.cmy.entity.Goods;
import xmu.mall.usercenter.cmy.entity.OrderGoods;
import xmu.mall.usercenter.cmy.entity.Order_info;
import xmu.mall.usercenter.cmy.entity.SearchOrder;
import xmu.mall.usercenter.cmy.entity.User;
import xmu.mall.usercenter.cmy.entity.User_address;
import xmu.mall.usercenter.cmy.service.Goods2Service;
import xmu.mall.usercenter.cmy.service.Order2Service;
import xmu.mall.usercenter.cmy.service.OrderGoods2Service;
import xmu.mall.usercenter.cmy.service.User2Service;
import xmu.mall.usercenter.cmy.service.UserAddressService;
@Controller
@RequestMapping(value="userinfo")
public class UserInfoController {
	
	@Resource
	private Goods2Service goodsService;
	@Resource
	private OrderGoods2Service orderGoodsService;
	@Resource
	private UserAddressService userAddressService;
	@Resource
	private User2Service userService;
		
	@RequestMapping(method=RequestMethod.GET)
	public String getOrderList(Model model)
	{
		long user_id=1;
		model.addAttribute("user_id",user_id);
		return "cmy2/userInfo";
	}
	
	@RequestMapping("userInfo")
	public String userInfo(Model model, HttpServletRequest request)
	{
		long user_id = Long.parseLong(request.getParameter("user_id"));
		model.addAttribute("user_id",user_id);
		return "redirect:/userinfo";
	}
	
	@RequestMapping("order")
	public String order(Model model, HttpServletRequest request){
		long user_id = Long.parseLong(request.getParameter("user_id"));
		List<OrderGoods> goodslist=orderGoodsService.getAllGoodsByUserId(user_id);
		model.addAttribute("goodslist",goodslist);
		model.addAttribute("user_id",user_id);
		return "cmy2/order";
	}
	
	@RequestMapping("orderUnpay")
	public String orderUnpay(Model model, HttpServletRequest request){
		long user_id = Long.parseLong(request.getParameter("user_id"));
		int order_status=0;
		List<OrderGoods> goodslist=orderGoodsService.getSelectedGoodsByUserId(user_id,order_status);
		model.addAttribute("goodslist",goodslist);
		model.addAttribute("user_id",user_id);
		return "cmy2/order";
	}
	
	@RequestMapping("orderPayed")
	public String orderPayed(Model model, HttpServletRequest request){
		long user_id = Long.parseLong(request.getParameter("user_id"));
		int order_status=3;
		List<OrderGoods> goodslist=orderGoodsService.getSelectedGoodsByUserId(user_id,order_status);
		model.addAttribute("goodslist",goodslist);
		model.addAttribute("user_id",user_id);
		return "cmy2/order";
	}
	
	@RequestMapping("orderGeted")
	public String orderGeted(Model model, HttpServletRequest request){
		long user_id = Long.parseLong(request.getParameter("user_id"));
		int order_status=4;
		List<OrderGoods> goodslist=orderGoodsService.getSelectedGoodsByUserId(user_id,order_status);
		model.addAttribute("goodslist",goodslist);
		model.addAttribute("user_id",user_id);
		return "cmy2/order";
	}
	
	@RequestMapping("orderCancel")
	public String orderCancel(Model model, HttpServletRequest request){
		long user_id = Long.parseLong(request.getParameter("user_id"));
		int order_status=5;
		List<OrderGoods> goodslist=orderGoodsService.getSelectedGoodsByUserId(user_id,order_status);
		model.addAttribute("goodslist",goodslist);
		model.addAttribute("user_id",user_id);
		return "cmy2/order";
	}
	
	@RequestMapping("receiveAddress")
	public String receiveAddress(Model model, HttpServletRequest request){
		long user_id = Long.parseLong(request.getParameter("user_id"));
		List<User_address> useraddress=userAddressService.getAllAddress(user_id);
		model.addAttribute("useraddress",useraddress);
		return "cmy2/receiveAddress";
	}
	
	@RequestMapping("updateAddress")
	public String updateAddress(Model model, HttpServletRequest request){
		
		long address_id = Long.parseLong(request.getParameter("address_id"));
		User_address useraddress=userAddressService.getAddressByAddressID(address_id);
		model.addAttribute("useraddress",useraddress);
		return "cmy2/updateAddress";
	}
	
	@RequestMapping("updateResult")
	public String updateResult(Model model,long address_id,String consignee,String telephone,int district,String detail,String isDefault){
		User_address address=userAddressService.getAddressByAddressID(address_id);
		address.setConsignee(consignee);
		address.setTelephone(telephone);
		address.setDistrict(district);
		address.setDetail(detail);
		if(isDefault.equals("Y"))
			address.setIs_default(true);
		else
			address.setIs_default(false);
		
		userAddressService.updateAddress(address);
		List<User_address> useraddress=userAddressService.getAllAddress(address.getUser_id());
		model.addAttribute("useraddress",useraddress);
		return "cmy2/receiveAddress";
	}
	
	@RequestMapping("userUpdate")
	public String userUpdate(Model model, HttpServletRequest request){
		long user_id=Long.parseLong(request.getParameter("user_id"));
		User user=userService.getUserByUserId(user_id);
		model.addAttribute("user",user);
		return "cmy2/userUpdate";
	}

	@RequestMapping("userUpdateResult")
	public String userUpdateResult(Model model,long user_id,String imagepath,String user_name,String mobile_phone,String nickname){
		User user=userService.getUserByUserId(user_id);
		user.setImagepath(imagepath);
		user.setMobile_phone(mobile_phone);
		user.setNickname(nickname);
		user.setUser_name(user_name);
		userService.updateUser(user);
		model.addAttribute("user_id",user_id);
		return "redirect:/userinfo";
	}
	
	@RequestMapping("collectGoods")
	public String collectGoods(Model model, HttpServletRequest request){
		long user_id=Long.parseLong(request.getParameter("user_id"));
		List<Goods> goods=goodsService.getGoodsByUserId(user_id);
		model.addAttribute("user_id",user_id);
		model.addAttribute("goods",goods);
		
		return "cmy2/collectGoods";
	}
	
}

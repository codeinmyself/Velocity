package xmu.mall.usercenter.ghz.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xmu.mall.usercenter.ghz.entity.Address;
import xmu.mall.usercenter.ghz.entity.User;
import xmu.mall.usercenter.ghz.service.AddressService;
import xmu.mall.usercenter.ghz.service.MyOrderService;
import xmu.mall.usercenter.ghz.service.UserService;
import xmu.mystore.ordersmgt.zf.model.Goods;
import xmu.mystore.ordersmgt.zf.model.Order_info;

@Controller
@RequestMapping(value="/user", produces="text/html;charset=UTF-8")
public class UserController {
	
	@Autowired 
	UserService us;
	
	@Autowired
	AddressService as;
	
	@Autowired
	MyOrderService os;
	
//	@RequestMapping(method=RequestMethod.GET, produces="text/html;charset=UTF-8")
//	public String home(HttpSession session)
//	{
//		User user = us.getUserById(1);
//		session.setAttribute("user", user);
//		return "ghz/myInfo";
//	}

	@RequestMapping(value="/home",method=RequestMethod.GET, produces="text/html;charset=UTF-8")
	public String toHome(Model model, HttpSession session)
	{
		User user = us.getUserById(1);
		session.setAttribute("user", user);
		session.setAttribute("userId", (long)1);
		return "ghz/myInfo";
	}
	
	@RequestMapping(value="/myCollection",method=RequestMethod.GET, produces="text/html;charset=UTF-8")
	public String toMyCollection(Model model, HttpSession session)
	{
		User user = (User) session.getAttribute("user");
		List<Goods> goodsList = os.getUserCollection(user.getUser_id());
		model.addAttribute("goodsList", goodsList);
		return "ghz/myCollection";
	}
	
	@RequestMapping(value="/deliveryAddress",method=RequestMethod.GET, produces="text/html;charset=UTF-8")
	public String toDeliveryAddress(Model model, HttpSession session)
	{
		User user = (User)session.getAttribute("user");
		List<Address> addressList = as.getUserAddress(user.getUser_id());
		Address defaultAddress = as.getDefaultAddress(user.getUser_id());
		model.addAttribute("addressList", addressList);
		model.addAttribute("defaultAddress", defaultAddress);
		return "ghz/deliveryAddress";
	}
	
	@RequestMapping(value="/newAddress", produces="text/html;charset=UTF-8")
	public String toNewAddress(Model model)
	{
		return "ghz/newAddress";
	}
	
	@RequestMapping(value="/orderList", produces="text/html;charset=UTF-8")
	public String toOrderList(Model model, HttpServletRequest request, HttpSession session)
	{
		String tag = request.getParameter("stat");
		User user = (User) session.getAttribute("user");
		if (tag != null) {
			List<Order_info> orderList = os.getOrderByTag(user.getUser_id(), tag);
			model.addAttribute("orderList", orderList);
		}
		return "ghz/orderList";
	}
	
	@RequestMapping(value="/updateInfo", produces="text/html;charset=UTF-8")
	public String toUpdateInfo(Model model, HttpSession session)
	{
		User user = (User) session.getAttribute("user");
		user = us.getUserById(user.getUser_id());
		session.setAttribute("user", user);
		model.addAttribute("user", user);
		return "ghz/updateInfo";
	}
	
	@RequestMapping(value="/updateName",method=RequestMethod.GET, produces="text/html;charset=UTF-8")
	public String toUpdateName(Model model, HttpSession session)
	{
		User user = (User) session.getAttribute("user");
		user = us.getUserById(user.getUser_id());
		session.setAttribute("user", user);
		model.addAttribute("user", user);
		return "ghz/updateName";
	}
	
	@RequestMapping(value="/removeOrder", produces="text/html;charset=UTF-8")
	public String removeOrder(Model model, HttpSession session, HttpServletRequest request)
	{
		int order_id = Integer.parseInt(request.getParameter("order_id"));
		String stat = request.getParameter("stat");
		User user = (User) session.getAttribute("user");
		os.removeOrder(user.getUser_id(), order_id);
		return "redirect:orderList?stat="+stat;
	}
	
	@RequestMapping(value="/confirmOrder", produces="text/html;charset=UTF-8")
	public String confirmOrder(Model model, HttpSession session, HttpServletRequest request)
	{
		int order_id = Integer.parseInt(request.getParameter("order_id"));
		User user = (User) session.getAttribute("user");
		os.confirmOrder(order_id);
		return "redirect:orderList?stat=received";
	}
	
	@RequestMapping(value="/cancelOrder", produces="text/html;charset=UTF-8")
	public String cancelOrder(Model model, HttpSession session, HttpServletRequest request)
	{
		int order_id = Integer.parseInt(request.getParameter("order_id"));
		User user = (User) session.getAttribute("user");
		os.cancelOrder(order_id);
		return "redirect:orderList?stat=cancel";
	}
	
	@RequestMapping(value="/setDefaultAddress", produces="text/html;charset=UTF-8")
	public String setDefaultAddress(Model model, HttpSession session, HttpServletRequest request)
	{
		int address_id = Integer.parseInt(request.getParameter("address_id"));
		User user = (User) session.getAttribute("user");
		as.setDefaultAddress(user.getUser_id(), address_id);
		return "redirect:deliveryAddress";
	}
	
	@RequestMapping(value="/setNickname", produces="text/html;charset=UTF-8")
	public String setNickname(Model model, HttpSession session, HttpServletRequest request)
	{
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String nickname = request.getParameter("nickname");
		User user = (User) session.getAttribute("user");
		us.updateUserName(user.getUser_id(), nickname);
		return "redirect:updateInfo";
	}
	
	@RequestMapping(value="/addNewAddress", produces="text/html;charset=UTF-8")
	public String addNewAddress(Model model, HttpSession session, HttpServletRequest request)
	{
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Address address = new Address();
		address.setConsignee(request.getParameter("consignee"));
		address.setZipcode(request.getParameter("zipcode"));
		address.setDetail(request.getParameter("detail").trim());
		address.setTelephone(request.getParameter("telephone"));
		User user = (User) session.getAttribute("user");
		address.setUser_id(user.getUser_id());
		as.addNewAddress(address);
		return "redirect:deliveryAddress";
	}
	
	@RequestMapping(value="/updateAddress", produces="text/html;charset=UTF-8")
	public String updateAddress(Model model, HttpSession session, HttpServletRequest request)
	{
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		User user = (User) session.getAttribute("user");
		int address_id = Integer.valueOf(request.getParameter("address_id").trim());
		Address address = as.getAddress(user.getUser_id(), address_id);
		model.addAttribute("address", address);
		return "ghz/updateAddress";
	}
	
	
	@RequestMapping(value="/updateCurrentAddress", produces="text/html;charset=UTF-8")
	public String updateCurrentAddress(Model model, HttpSession session, HttpServletRequest request)
	{
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		User user = (User) session.getAttribute("user");
		int address_id = Integer.valueOf(request.getParameter("address_id").trim());
		Address address = as.getAddress(user.getUser_id(), address_id);
		address.setConsignee(request.getParameter("consignee"));
		address.setZipcode(request.getParameter("zipcode"));
		address.setDetail(request.getParameter("detail").trim());
		address.setTelephone(request.getParameter("telephone"));
		as.updateAddress(address);
		return "redirect:deliveryAddress";
	}
	
	@RequestMapping(value="removeAddress", produces="text/html;charset=UTF-8")
	public String removeAddress(Model model, HttpSession session, HttpServletRequest request)
	{
		User user = (User) session.getAttribute("user");
		int address_id = Integer.valueOf(request.getParameter("address_id").trim());
		as.removeAddress(address_id);
		return "redirect:deliveryAddress";
	}
	
}

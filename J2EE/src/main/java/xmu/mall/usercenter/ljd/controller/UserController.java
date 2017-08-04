package xmu.mall.usercenter.ljd.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xmu.mystore.ordersmgt.tangkai.model.Order;
import xmu.mystore.ordersmgt.tangkai.model.OrderGoods;
import xmu.mystore.orderindex.tangkai.model.UserAddress;
import xmu.mall.usercenter.ljd.model.Goods;
import xmu.mall.usercenter.ljd.model.Order_info;
import xmu.mall.usercenter.ljd.model.Region;
import xmu.mall.usercenter.ljd.model.Show_OrderItem;
import xmu.mall.usercenter.ljd.model.User_collect_goods;
import xmu.mall.usercenter.ljd.model.Users;
import xmu.mall.usercenter.ljd.service.UserCollectGoodsService;
import xmu.mall.usercenter.ljd.service.UsersAddressService;
import xmu.mall.usercenter.ljd.service.UsersService;
import xmu.mystore.goodsmgt.zlt.service.GoodsMgtService;
//import xmu.mystore.goodsmgt.wcf.service.GoodsService;

@Controller
@RequestMapping(value="/user")
public class UserController
{
	@Autowired
	@Qualifier("UsersService")
	private UsersService usersService;
	
//	@Component("tangkai1_OrderGoodsMapper")
//	@Component("tangkai1_OrderMapper")	
	@Autowired
	@Qualifier("orderindex_UserService")
	private xmu.mystore.orderindex.tangkai.service.UserService tk_usersService;
	

	@Autowired
	@Qualifier("tangkai_OrderService")
	private xmu.mystore.ordersmgt.tangkai.service.OrderService tk_orderService;
	
	@Autowired
	@Qualifier("tangkai_OrderGoodsService")
	private xmu.mystore.ordersmgt.tangkai.service.OrderGoodsService tk_orderGoodsService;
	
	@Autowired
	@Qualifier("UserCollectGoodsService")
	private UserCollectGoodsService usercollectgoodsService;
	
	@Autowired
	@Qualifier("UsersAddressService")
	private UsersAddressService usersAddressService;
	
//	@Autowired
//	@Qualifier("wyh_IGoodsService")
//	private IGoodsMapperService wyh_IGoodsService;
//	@Component("wcf_BrandMapper")
	@Autowired
	private GoodsMgtService goodsMgtService;
	
	@RequestMapping(value={"/","/index","/home"},method=RequestMethod.GET)
	public String userIndex(Model model,HttpSession session)
	{
		session.setAttribute("userId",1);
//		Long user_id=Long.valueOf(session.getAttribute("userId").toString());
		Long user_id = (long) 1;
		Users user = new Users();
		user.setUser_id(user_id);
		model.addAttribute("user", usersService.getUsersByID(user));
		
		return "ljd/index";
	}
	
	public List<Order_info> changeOrderListToLocal(List<Order> orderList)
	{	
		List<Order_info> newOrderList = new ArrayList<Order_info>();
		
		for(int i = 0;i < orderList.size(); i ++){
			Order_info newOrder = new Order_info();
			Order oldOrder = orderList.get(i);
			
			newOrder.setOrder_id(oldOrder.getOrder_id());
			newOrder.setOrder_sn(oldOrder.getOrder_sn());
			newOrder.setUser_id(oldOrder.getUser_id());
			newOrder.setOrder_status(oldOrder.getOrder_status());
			newOrder.setConsignee(oldOrder.getConsignee());
			newOrder.setAddress(oldOrder.getAddress());
			newOrder.setZipcode(oldOrder.getZipcode());
			newOrder.setTelephone(oldOrder.getTelephone());
			newOrder.setOrder_price(oldOrder.getOrder_price());
			newOrder.setRemark(oldOrder.getRemark());
			newOrder.setTotal_weight(oldOrder.getTotal_weight());
			newOrder.setAdd_time(oldOrder.getAdd_time());
			newOrder.setShipped_time(oldOrder.getShipped_time());
			newOrder.setExpressCode(oldOrder.getExpressCode());
			newOrder.setIsUrgency(oldOrder.getIsUrgency());
			newOrder.setMake_time(oldOrder.getMake_time());
			
			newOrderList.add(newOrder);
		}
		
		return newOrderList;
	}
	
	public List<Show_OrderItem> changeOrderItem(List<Order_info> orderList)
	{	
		List<Show_OrderItem> showOrderList = new ArrayList<Show_OrderItem>();
		
		for(int i = 0;i < orderList.size(); i ++){
			Show_OrderItem showOrderItem = new Show_OrderItem();
			
			showOrderItem.setOrder_id(orderList.get(i).getOrder_id());
			showOrderItem.setOrder_sn(orderList.get(i).getOrder_sn());
			showOrderItem.setUser_id(orderList.get(i).getUser_id());
			showOrderItem.setOrder_status(orderList.get(i).getOrder_status());
			showOrderItem.setOrder_price(orderList.get(i).getOrder_price());
			
			List<OrderGoods> OrderGoods = tk_orderGoodsService.getAllOrdersByOrderId(showOrderItem.getOrder_id());
			
			showOrderItem.setGoodsList(OrderGoods);
			
			showOrderList.add(showOrderItem);
		}
		
		return showOrderList;
	}
	
	//@ServiceLogger(description="updateUserName",OperateObject="User")
	@RequestMapping(value="/order_list",method=RequestMethod.GET)
	public String userOrderList(Model model,HttpSession session)
	{
		Long user_id=Long.valueOf(session.getAttribute("userId").toString());
		
		Users user = new Users();
		user.setUser_id(user_id);
		model.addAttribute("user", usersService.getUsersByID(user));
		
		model.addAttribute("show_order_list", changeOrderItem(changeOrderListToLocal(tk_orderService.getOrderByUser_id(user_id))));
		//model.addAttribute("show_order_list", changeOrderItem(tk_orderService.getAllOrdersByUserID(user_id)));
		
		return "ljd/order_list";
	}
	
	@RequestMapping(value="/unpaid_order",method=RequestMethod.GET)
	public String userUnpaidList(Model model,HttpSession session)
	{
		int state = 0;
		Long user_id=Long.valueOf(session.getAttribute("userId").toString());
		
		Users user = new Users();
		user.setUser_id(user_id);
		model.addAttribute("user", usersService.getUsersByID(user));
		
		model.addAttribute("show_order_list", changeOrderItem(changeOrderListToLocal(tk_orderService.getOrderByStatus(user_id,state))));
		
		return "ljd/unpaid_order";
	}
	
	@RequestMapping(value="/canel_order/{id}",method=RequestMethod.GET)
	public String canelOrder(
			@PathVariable Long id,
			Model model,
			HttpSession session)
	{
		tk_orderService.cancelOrder(id);
		
		return "redirect:/user/unpaid_order";
	}
	
	@RequestMapping(value="/unshipped_order",method=RequestMethod.GET)
	public String userUnshippedList(Model model,HttpSession session)
	{
		int state = 1;
		Long user_id=Long.valueOf(session.getAttribute("userId").toString());
		
		Users user = new Users();
		user.setUser_id(user_id);
		model.addAttribute("user", usersService.getUsersByID(user));
		
		model.addAttribute("show_order_list", changeOrderItem(changeOrderListToLocal(tk_orderService.getOrderByStatus(user_id,state))));
		
		return "ljd/unshipped_order";
	}
	
	@RequestMapping(value="/receive_order/{id}",method=RequestMethod.GET)
	public String receiveOrder(
			@PathVariable Long id,
			Model model,
			HttpSession session)
	{
		tk_orderService.receiveOrder(id);
		
		return "redirect:/user/unreceivied_order";
	}
	
	@RequestMapping(value="/unreceivied_order",method=RequestMethod.GET)
	public String userUnreceiviedList(Model model,HttpSession session)
	{
		int state = 3;
		Long user_id=Long.valueOf(session.getAttribute("userId").toString());
		
		Users user = new Users();
		user.setUser_id(user_id);
		model.addAttribute("user", usersService.getUsersByID(user));
		
		model.addAttribute("show_order_list", changeOrderItem(changeOrderListToLocal(tk_orderService.getOrderByStatus(user_id,state))));
		
		return "ljd/unreceivied_order";
	}
	
	@RequestMapping(value="/receipt_order",method=RequestMethod.GET)
	public String userEeceiptList(Model model,HttpSession session)
	{
		int state = 4;
		Long user_id=Long.valueOf(session.getAttribute("userId").toString());
		
		Users user = new Users();
		user.setUser_id(user_id);
		model.addAttribute("user", usersService.getUsersByID(user));
		
		model.addAttribute("show_order_list", changeOrderItem(changeOrderListToLocal(tk_orderService.getOrderByStatus(user_id,state))));
		
		return "ljd/receipt_order";
	}
	
	@RequestMapping(value="/user_info",method=RequestMethod.GET)
	public String userInfo(Model model,HttpSession session)
	{
		Long user_id=Long.valueOf(session.getAttribute("userId").toString());
		
		Users user = new Users();
		user.setUser_id(user_id);
		model.addAttribute("user", usersService.getUsersByID(user));
		
		return "ljd/user_info";
	}

	@RequestMapping(value="/user_info",method=RequestMethod.POST)
	public String updateUserInfo(@ModelAttribute("user") Users user,Model model,HttpSession session)
	{	
		user.setUser_id(Long.valueOf(session.getAttribute("userId").toString()));
		
		usersService.updateUsername(user);
		usersService.updateNickname(user);
		usersService.updateMobilephone(user);
		
		model.addAttribute("user", usersService.getUsersByID(user));
		
		return "ljd/user_info";
	}
	
	@RequestMapping(value="/canel_collection/{id}",method=RequestMethod.GET)
	public String canelCollection(
			@PathVariable long id,
			Model model,
			HttpSession session)
	{
		Long user_id=Long.valueOf(session.getAttribute("userId").toString());
		
		User_collect_goods user_collect_goods = new User_collect_goods();
		user_collect_goods.setUser_id(user_id);
		user_collect_goods.setGoods_id(id);
		
		usercollectgoodsService.delete(user_collect_goods);
		
		return "redirect:/user/collection";
	}
	
	@RequestMapping(value="/collection",method=RequestMethod.GET)
	public String userCollection(Model model,HttpSession session)
	{
		Long user_id=Long.valueOf(session.getAttribute("userId").toString());
		
		Users user = new Users();
		user.setUser_id(user_id);
		model.addAttribute("user", usersService.getUsersByID(user));
		
		List<User_collect_goods> ucg_list = usercollectgoodsService.getAllCollectionsByUserID(user_id);
		List<xmu.mystore.goodsmgt.zlt.model.Goods> good_list = new ArrayList<xmu.mystore.goodsmgt.zlt.model.Goods>();
		
		for(int i =0 ;i<ucg_list.size();++i){
//		change	
			good_list.add(goodsMgtService.getGoodsByGoodsId(ucg_list.get(i).getGoods_id()));
		}
			
		model.addAttribute("goods_list", good_list);
		
		return "ljd/collection";
	}
	
	
	@RequestMapping(value="/address",method=RequestMethod.GET)
	public String userAddress(Model model,HttpSession session)
	{
		Long user_id=Long.valueOf(session.getAttribute("userId").toString());
		
		Users user = new Users();
		user.setUser_id(user_id);
		model.addAttribute("user", usersService.getUsersByID(user));
		
		//model.addAttribute("address_list", usersAddressService.selectAllByUserID(user_id));
		
		model.addAttribute("address_list", tk_usersService.getUserAddressesByUserId(user_id));
		
		model.addAttribute("region_list", usersAddressService.selectAllRegion());
		
		return "ljd/address";
	}
	
	@RequestMapping(value="/add_address",method=RequestMethod.GET)
	public String addAddress(Model model,HttpSession session)
	{
		Long user_id=Long.valueOf(session.getAttribute("userId").toString());
		
		List<Region> region_list = usersAddressService.selectAllRegion();
		
		model.addAttribute("countryParent", 0);
		model.addAttribute("provinceParent", -1);
		model.addAttribute("cityParent", -1);
		model.addAttribute("districtParent", -1);
		model.addAttribute("region_list", region_list);
		
		return "ljd/add_address";
	}
	
	@RequestMapping(value="/add_address/{id}",method=RequestMethod.GET)
	public String addAddress(@PathVariable int id,Model model,HttpSession session)
	{
		Long user_id=Long.valueOf(session.getAttribute("userId").toString());
		
		List<Region> region_list = usersAddressService.selectAllRegion();
		
		model.addAttribute("countryParent", id);
		model.addAttribute("provinceParent", -1);
		model.addAttribute("cityParent", -1);
		model.addAttribute("districtParent", -1);
		model.addAttribute("region_list", region_list);
		
		return "ljd/add_address";
	}
	
	@RequestMapping(value="/add_address/{id}/{id1}",method=RequestMethod.GET)
	public String addAddress(@PathVariable int id,@PathVariable int id1,Model model,HttpSession session)
	{
		Long user_id=Long.valueOf(session.getAttribute("userId").toString());
		
		List<Region> region_list = usersAddressService.selectAllRegion();
		
		model.addAttribute("countryParent", id);
		model.addAttribute("provinceParent", id1);
		model.addAttribute("cityParent", -1);
		model.addAttribute("districtParent", -1);
		model.addAttribute("region_list", region_list);
		
		return "ljd/add_address";
	}
	
	@RequestMapping(value="/add_address/{id}/{id1}/{id2}",method=RequestMethod.GET)
	public String addAddress(@PathVariable int id,@PathVariable int id1,@PathVariable int id2,Model model,HttpSession session)
	{
		Long user_id=Long.valueOf(session.getAttribute("userId").toString());
		
		List<Region> region_list = usersAddressService.selectAllRegion();
		
		model.addAttribute("countryParent", id);
		model.addAttribute("provinceParent", id1);
		model.addAttribute("cityParent", id2);
		model.addAttribute("districtParent", -1);
		model.addAttribute("region_list", region_list);
		
		return "ljd/add_address";
	}
	
	@RequestMapping(value="/add_address/{id}/{id1}/{id2}/{id3}",method=RequestMethod.GET)
	public String addAddress(@PathVariable int id,@PathVariable int id1,@PathVariable int id2,@PathVariable int id3,Model model,HttpSession session)
	{
		Long user_id=Long.valueOf(session.getAttribute("userId").toString());
		
		List<Region> region_list = usersAddressService.selectAllRegion();
		
		model.addAttribute("countryParent", id);
		model.addAttribute("provinceParent", id1);
		model.addAttribute("cityParent", id2);
		model.addAttribute("districtParent", id3);
		model.addAttribute("district", -1);
		model.addAttribute("region_list", region_list);
		
		return "ljd/add_address";
	}
	
	@RequestMapping(value="/add_address/{id}/{id1}/{id2}/{id3}/{id4}",method=RequestMethod.GET)
	public String addAddress(@PathVariable int id,@PathVariable int id1
			,@PathVariable int id2,@PathVariable int id3,@PathVariable int id4
			,Model model,HttpSession session)
	{
		Long user_id=Long.valueOf(session.getAttribute("userId").toString());
		
		List<Region> region_list = usersAddressService.selectAllRegion();
		
		model.addAttribute("countryParent", id);
		model.addAttribute("provinceParent", id1);
		model.addAttribute("cityParent", id2);
		model.addAttribute("districtParent", id3);
		model.addAttribute("district", id4);
		model.addAttribute("region_list", region_list);
		
		return "ljd/add_address";
	}
	
	@RequestMapping(value="/add_address/{id}/{id1}/{id2}/{id3}/{id4}",method=RequestMethod.POST)
	public String addAddressInfo(@ModelAttribute("UserAddress") UserAddress userAddress
			,@PathVariable int id,@PathVariable int id1
			,@PathVariable int id2,@PathVariable int id3,@PathVariable int id4
			,Model model,HttpSession session)
	{
		Long user_id=Long.valueOf(session.getAttribute("userId").toString());
		
		userAddress.setUser_id(Long.valueOf(session.getAttribute("userId").toString()));
		userAddress.setMydefault("N");
		userAddress.setCountry(id1);
		userAddress.setProvince(id2);
		userAddress.setCity(id3);
		userAddress.setDistrict(id4);
		
		//usersAddressService.add(user_address);
		tk_usersService.addUserAddress(userAddress);
		
		return "redirect:/user/address";
	}
	
	@RequestMapping(value="/delete_address/{id}",method=RequestMethod.GET)
	public String deleteAddress(
			@PathVariable Long id,
			Model model,
			HttpSession session)
	{
		usersAddressService.deleteUserAddressByAddressID(id);
		System.out.println("运行至此，address_id是"+id);
		return "redirect:/user/address";
	}
	
	@RequestMapping(value="/default_address/{id}",method=RequestMethod.GET)
	public String defaultAddress(
			@PathVariable Long id,
			Model model,
			HttpSession session)
	{
		UserAddress user_address = new UserAddress();
		user_address.setUser_id(Long.valueOf(session.getAttribute("userId").toString()));
		user_address.setAddress_id(id);
		tk_usersService.setDefaultAddress(user_address);
		
		return "redirect:/user/address";
	}
}

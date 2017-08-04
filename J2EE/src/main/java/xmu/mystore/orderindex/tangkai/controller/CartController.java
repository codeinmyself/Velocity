package xmu.mystore.orderindex.tangkai.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xmu.mall.goodsindex.zjh.service.IShoppingCartService;
import xmu.mystore.goodsmgt.wcf.model.Goods;
import xmu.mystore.goodsmgt.wcf.service.outter.IGoodsMapper;
import xmu.mystore.ordersmgt.tangkai.model.Order;
import xmu.mystore.ordersmgt.tangkai.model.OrderGoods;
import xmu.mystore.orderindex.tangkai.model.User;
import xmu.mystore.orderindex.tangkai.model.UserAddress;
import xmu.mystore.ordersmgt.tangkai.service.OrderGoodsService;
import xmu.mystore.ordersmgt.tangkai.service.OrderService;
import xmu.mystore.orderindex.tangkai.service.UserService;

/**
 * @author tangkai
 * @data 2017年6月2日--下午4:17:11
 */
@Controller
@RequestMapping(value="/user/orderindex/")
public class CartController {
	
	@Autowired
	@Qualifier("tangkai_OrderService")
	private OrderService orderService;
	@Autowired
	@Qualifier("tangkai_OrderGoodsService")
	private OrderGoodsService orderGoodsService;
	@Autowired
	@Qualifier("orderindex_UserService")
	private UserService userService;
	
	@Autowired
	@Qualifier("wcf_IGoodsMapper")
	private IGoodsMapper goodService;	
	
	@Autowired
	@Qualifier("ShoppingCartService")
	private IShoppingCartService shoppingCartService;
		
	/**
	 * 处理订单页面
	 * @param goodsId
	 * @param goodsNumber
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/order",method=RequestMethod.POST)
	public String turnToOrderPage(
			String[]goodsId,
			String[]goodsNumber,
			Model model, HttpSession session)
	{
		//model.addAttribute("orderList",orderInforList);
		Long user_id=Long.valueOf(session.getAttribute("userId").toString());
		//System.out.println(userId);
		
		Order order = new Order();
		
		//return "zjh/ordertest";
        
        order.setOrder_sn(orderService.createOrder_sn()); 
		
		List<Order> orders = orderService.getShoppingCart(user_id);	
		System.out.println(orders.size());
		if(orders.size() == 0)
			return "test";		
		User user = userService.getUserByUserId(user_id);
		UserAddress address = userService.getDefaultAddress(user_id);
		order.setConsignee(address.getConsignee());
		order.setIsUrgency("N");
		order.setZipcode(address.getZipcode());
		order.setOrder_status(0);
		order.setAddress(address.getDetail());
		order.setTelephone(address.getTelephone());
		order.setUser_id(user_id);
		order.setTotal_weight(0d);
		order.setOrder_price(0d);
		order.setRemark("");
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = new Date();
		String t = df.format(d);
		try {
			int time_now = (int) (df.parse(t).getTime() / 1000);
			
			order.setAdd_time(time_now);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		orderService.addOrder(order);
		
		double total_weight = 0;
		
		double order_price = 0;
		
		List<OrderGoods> orderGoodsList=new ArrayList<OrderGoods>();
		if(goodsId.length==goodsNumber.length)
		{
			for(int i=0;i<goodsId.length;++i)
			{
				OrderGoods orderGoods=new OrderGoods();
				Goods goods = (Goods) goodService.getGoodsByGoodsId(Long.parseLong(goodsId[i]));
				orderGoods.setOrder_id(order.getOrder_id());
				orderGoods.setGoods_id(Long.parseLong(goodsId[i]));
				orderGoods.setName(goods.getName());
				orderGoods.setPrice(goods.getReal_price());
				orderGoods.setDescription(goods.getDescription());
				orderGoods.setNum(Integer.parseInt(goodsNumber[i]));
				total_weight += goods.getWeight() * Integer.parseInt(goodsNumber[i]);
				order_price += goods.getReal_price() * Integer.parseInt(goodsNumber[i]);
				orderGoodsService.addOrderGoods(orderGoods);
				goodService.deleteGoodsNumById(goodsId[i], Integer.parseInt(goodsNumber[i]));
				shoppingCartService.deleteByUserIdAndGoodsId(user_id, Long.parseLong(goodsId[i]));
				orderGoodsList.add(orderGoods);
			}
		}
		
		order.setTotal_weight(total_weight);
		order.setOrder_price(order_price);
		//System.out.println(order.getTotal_weight() + "   " + order.getOrder_price());
		orderService.updateOrder(order);
		
		model.addAttribute("userAddress", address);
		model.addAttribute("goodslist", orderGoodsList);
		model.addAttribute("order", order);
		
		model.addAttribute("user", user);
		return "tangkai/balance";
		
	}
	
	@RequestMapping("addOrder")
	public String addOrder(Model model, HttpServletRequest request)
	{
		long address_id = Long.parseLong(request.getParameter("address_id"));
		long order_id = Long.parseLong(request.getParameter("order_id"));
		long user_id = Long.parseLong(request.getParameter("user_id"));
		Order order = orderService.getOrderByOrderId(order_id);
		List<UserAddress> addresses = userService.getUserAddressesByUserId(user_id);
		List<OrderGoods> goods = orderGoodsService.getAllOrdersByOrderId(order_id);
		UserAddress address = null;
		for(UserAddress temp:addresses)
		{
			if(temp.getAddress_id() == address_id)
				address = temp;
		}
		if(address != null)
		{
			order.setAddress(address.getDetail());
			order.setConsignee(address.getConsignee());
			order.setTelephone(address.getTelephone());
			order.setZipcode(address.getZipcode());
		}
		
		order.setOrder_status(1);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = new Date();
		String t = df.format(d);
		try {
			int pay_time = (int) (df.parse(t).getTime() / 1000);
			
			order.setPay_time(pay_time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		orderService.updateOrder(order);
		model.addAttribute("order", order);
		model.addAttribute("goodsList",goods);
		model.addAttribute("user", userService.getUserByUserId(user_id));
	    return "tangkai/lookupOrder";
	}
	
	@RequestMapping("chooseAddress")
	public String chooseAddress(Model model, HttpServletRequest request)
	{
		long user_id = Long.parseLong(request.getParameter("user_id"));
		List<UserAddress> addresses = userService.getNotDefaultAddress(user_id);
		UserAddress defaultAddress = userService.getDefaultAddress(user_id);
		model.addAttribute("defaultAddress", defaultAddress);
		model.addAttribute("user_id", user_id);
		model.addAttribute("userAddresses", addresses);
		return "tangkai/deliveryAddress";
	}
	
	@RequestMapping("newAddress")
	public String newAddress(Model model, HttpServletRequest request)
	{
		long user_id = Long.parseLong(request.getParameter("user_id"));
		List<UserAddress> addresses = userService.getUserAddressesByUserId(user_id);
		model.addAttribute("userAddresses", addresses);
		model.addAttribute("user_id", user_id);
		return "tangkai/newAddress";
	}
	
	@RequestMapping("getAddress")
	public String getAddress(Model model, HttpServletRequest request)
	{
		long user_id = Long.parseLong(request.getParameter("user_id"));
		long address_id = Long.parseLong(request.getParameter("address_id"));
		
		List<Order> orders = orderService.getShoppingCart(user_id);			
		if(orders.size() == 0)
			return "test";		
		Order order = orders.get(0);		
		User user = userService.getUserByUserId(user_id);		
		List<OrderGoods> goodslist = orderGoodsService.getAllOrdersByOrderId(order.getOrder_id());
		
		UserAddress address = userService.getAddressById(address_id);

		model.addAttribute("userAddress", address);
		model.addAttribute("goodslist", goodslist);
		model.addAttribute("order", order);
		
		model.addAttribute("user", user);
		return "tangkai/balance";
	}
	
	@RequestMapping("addNewAddress")
	public String addNewAddress(Model model, HttpServletRequest request)
	{
		long user_id = Long.parseLong(request.getParameter("user_id"));
		String consignee = request.getParameter("consignee");
		String telephone = request.getParameter("telephone");
		String zipcode = request.getParameter("zipcode");
		String detail = request.getParameter("detail");
		UserAddress address = new UserAddress();
		address.setUser_id(user_id);
		address.setZipcode(zipcode);
		address.setConsignee(consignee);
		address.setDetail(detail);
		address.setTelephone(telephone);
		
		userService.addUserAddress(address);
		
		List<UserAddress> addresses = userService.getNotDefaultAddress(user_id);
		
		address = addresses.get(addresses.size() - 1);
		
		List<Order> orders = orderService.getShoppingCart(user_id);			
		if(orders.size() == 0)
			return "test";		
		Order order = orders.get(0);		
		User user = userService.getUserByUserId(user_id);		
		List<OrderGoods> goodslist = orderGoodsService.getAllOrdersByOrderId(order.getOrder_id());

		model.addAttribute("userAddress", address);
		model.addAttribute("goodslist", goodslist);
		model.addAttribute("order", order);
		
		model.addAttribute("user", user);
		return "tangkai/balance";
		
		
	/*
	 @Autowired
	private IOrderService orderService;
	
	@Autowired
	private IOrderGoodsService orderGoodsService;

	@Autowired
	private IUserService userService;
	
	@Autowired
	private IUserAddressService userAddressService;

	@Autowired
	@Qualifier("ShoppingCartService")
	private IShoppingCartService shoppingCartService;

	
	@Autowired
	private GoodsService goodService;
	
	@Autowired
	private GoodsMgtService goodsMgtService;
	@RequestMapping(value="/order",method=RequestMethod.POST)
	public String turnToOrderPage(
			String[]goodsId,
			String[]goodsNumber,
			Model model, HttpSession session)
	{

		Long user_id=Long.valueOf(session.getAttribute("userId").toString());

		
		Order order = new Order();
		String sn = orderService.createOrder_sn();
        order.setOrder_sn(sn); 
			
		User user = userService.getUserByID(user_id);
		UserAddress address = userAddressService.getDefaultAddress(user_id);
		order.setConsignee(address.getConsignee());
		order.setIsUrgency("N");
		order.setZipcode(address.getZipcode());
		order.setOrder_status(0);
		order.setAddress(address.getDetail());
		order.setTelephone(address.getTelephone());
		order.setUser_id(user_id);
		order.setTotal_weight(0);
		order.setOrder_price(0);
		order.setRemark("");
		order.setAdd_time(System.currentTimeMillis());
		orderService.addOrder(order);
		
		order = orderService.getOrderBySN(sn);
		double total_weight = 0;
		
		double order_price = 0;
		
		List<OrderGoods> orderGoodsList=new ArrayList<OrderGoods>();
		if(goodsId.length==goodsNumber.length)
		{
			for(int i=0;i<goodsId.length;++i)
			{
				OrderGoods orderGoods=new OrderGoods();
				Goods tmp = new Goods();
				tmp.setId(Long.parseLong(goodsId[i]));
				Goods goods = (Goods) goodService.getAGoods(tmp);
				orderGoods.setOrder_id(order.getOrder_id());
				orderGoods.setGoods_id(Long.parseLong(goodsId[i]));
				orderGoods.setGoods_name(goods.getName());
				orderGoods.setGoods_price(goods.getReal_price());
				orderGoods.setGoods_number(Integer.parseInt(goodsNumber[i]));
				total_weight += goods.getWeight() * Integer.parseInt(goodsNumber[i]);
				order_price += goods.getReal_price() * Integer.parseInt(goodsNumber[i]);
				orderGoodsService.addOrderGoods(orderGoods);
				goodsMgtService.deleteGoodsNumById(Long.parseLong(goodsId[i]), Integer.parseInt(goodsNumber[i]));
				shoppingCartService.deleteByUserIdAndGoodsId(user_id, Long.parseLong(goodsId[i]));
				orderGoodsList.add(orderGoods);
			}
		}
		
		order.setTotal_weight(total_weight);
		order.setOrder_price(order_price);
		orderService.updateOrder(order);
		
		model.addAttribute("userAddress", address);
		model.addAttribute("goodslist", orderGoodsList);
		model.addAttribute("order", order);
		
		model.addAttribute("user", user);
		return "tangkai/balance";
	}

	
	@RequestMapping("addOrder")
	public String addOrder(Model model, HttpServletRequest request)
	{
		long address_id = Long.parseLong(request.getParameter("address_id"));
		long order_id = Long.parseLong(request.getParameter("order_id"));
		long user_id = Long.parseLong(request.getParameter("user_id"));
		Order order = orderService.getOrderByID(order_id);
	
		List<OrderGoods> goods = orderGoodsService.getOrderGoodsByOrderId(order_id);
		
		order.setOrder_status(1);
		order.setPay_time(System.currentTimeMillis());
		orderService.updateOrder(order);
		
		model.addAttribute("order", order);
		model.addAttribute("goodsList",goods);
		model.addAttribute("user", userService.getUserByID(user_id));
	    return "tangkai/lookupOrder";
	}
	 * */
	}
}

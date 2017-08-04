package xmu.mall.usercenter.zf.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import xmu.mystore.ordersmgt.zf.model.Order_info;
import xmu.mystore.ordersmgt.zf.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	@Qualifier("orderService")
	private OrderService orderSerive;
	
	// 根据状态获取订单
	@RequestMapping(value="orderList", method=RequestMethod.GET)
	public String home(long uid, String stat, Model model)
	{
		List<Order_info> orders = new ArrayList<Order_info>();
		if(stat.equals("all"))
			orders = this.orderSerive.getOrderByUser_id(uid);
		else if (stat.equals("pay")) // 未付款订单
			orders = this.orderSerive.getOrderByStatus(uid, 0);
		else if (stat.equals("receive")) // 待收货(已发货)订单
			orders = this.orderSerive.getOrderByStatus(uid, 3);
		else if (stat.equals("done")) // 已完成(已收货)订单
			orders = this.orderSerive.getOrderByStatus(uid, 4);
		else if (stat.equals("cancel")) // 已取消订单
			orders = this.orderSerive.getOrderByStatus(uid, 5);
		
		model.addAttribute("orders", orders);
		return "orderList";
	}
	
	// 根据状态获取订单
	@RequestMapping(value="getOrders",method=RequestMethod.GET)
	@ResponseBody
	public List<Order_info> getUrgentOrders(long uid, String stat){
		List<Order_info> orders = new ArrayList<Order_info>();
		if(stat.equals("all"))
			orders = this.orderSerive.getOrderByUser_id(uid);
		else if (stat.equals("pay")) // 未付款订单
			orders = this.orderSerive.getOrderByStatus(uid, 0);
		else if (stat.equals("receive")) // 待收货(已发货)订单
			orders = this.orderSerive.getOrderByStatus(uid, 3);
		else if (stat.equals("done")) // 已完成(已收货)订单
			orders = this.orderSerive.getOrderByStatus(uid, 4);
		else if (stat.equals("cancel")) // 已取消订单
			orders = this.orderSerive.getOrderByStatus(uid, 5);
		return orders;
	}
	
	// 取消订单
	@RequestMapping(value="cancelOrder", method=RequestMethod.GET)
	@ResponseBody
	public String cancel(long order_id)
	{
		this.orderSerive.cancelOrder(order_id);
		return "success";
	}
	
	// 确认收货
	@RequestMapping(value="finishOrder", method=RequestMethod.GET)
	@ResponseBody
	public String finish(long order_id)
	{
		this.orderSerive.receiveOrder(order_id);
		return "success";
	}
	
}

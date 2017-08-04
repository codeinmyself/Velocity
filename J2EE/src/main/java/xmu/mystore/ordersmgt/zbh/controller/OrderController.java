package xmu.mystore.ordersmgt.zbh.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xmu.mystore.ordersmgt.zbh.model.Goods;
import xmu.mystore.ordersmgt.zbh.model.Order;
import xmu.mystore.ordersmgt.zbh.model.User;
import xmu.mystore.ordersmgt.zbh.service.GoodsService;
import xmu.mystore.ordersmgt.zbh.service.OrderService;
import xmu.mystore.ordersmgt.zbh.service.UserService;

@Controller
@RequestMapping(value="/")
public class OrderController {
	@Resource
	private OrderService orderService;
	@Resource
	private GoodsService goodsService;
	@Resource
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String showOrderList(Model model){
		List<Order> orderList = orderService.showAllOrder();
		
		/*未和支付模块集成讨论前 最早写的生成订单号的方法
		for(Order o:orderList){
			//int time =Integer.parseInt( o.getAddTime());
			String time = o.getAddTime();
			try{
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				long ltime = Long.valueOf(time);
				String data =sdf.format(ltime*1000);
				//System.out.println(data);
				o.setAddTime(data);
			}catch(Exception e){
				e.printStackTrace();
			}
			Random rm = new Random();
			//获得随机数
			int pross = 100+rm.nextInt(900);
			String rms = String.valueOf(pross);
			o.setOrderSn(time+rms);
			
			orderService.updateOrder(o);
		}
		*/
		model.addAttribute("orderList", orderList);
		return "showOrderList";
	}
	
	
	@RequestMapping("checkOrderList")
	public String checkOrderList(Model model,HttpServletRequest request){
		int s =Integer.parseInt(request.getParameter("orderStatus"));
		long oid=Long.parseLong(request.getParameter("orderId"));
		Order o=orderService.getOrderById(oid);
		o.setOrderStatus(s);
		orderService.updateOrder(o);
		List<Order> orderList = orderService.showAllOrder();
		model.addAttribute("orderList", orderList);
		return "showOrderList";
	}
	
	@RequestMapping("deliverOrder")
	public String deliverOrder(Model model,HttpServletRequest request){
		int s =Integer.parseInt(request.getParameter("orderStatus"));
		long oid=Long.parseLong(request.getParameter("orderId"));
		Order o=orderService.getOrderById(oid);
		o.setOrderStatus(s);
		orderService.updateOrder(o);
		
		//List<Order> orderList = orderService.showAllOrder();
		//model.addAttribute("orderList", orderList);
		List<Goods> goodsList=goodsService.getGoodsByOrderid(oid);
		User u=userService.getUserByUserId(o.getUserId());
		model.addAttribute("order", o);
		model.addAttribute("goodsList", goodsList);
		model.addAttribute("user", u);
		return "deliverOrder";
	}
	
	
	@RequestMapping("deliverOrderList")
	public String deliverOrderList(Model model, long id,String expressCode){
		//System.out.println("调用成功");
		Order o=orderService.getOrderById(id);
		//System.out.println(o.getConsignee());
		System.out.println(expressCode);
		
		o.setExpressCode(expressCode);
		
		orderService.updateOrder(o);
		List<Order> orderList = orderService.showAllOrder();
		model.addAttribute("orderList", orderList);
		return "showOrderList";
	}
	
	@RequestMapping("updateOrder")
    public String updateOrder(Model model,long id,String address,
    		int orderStatus,String expressCode,String remark,String isUrgency,String orderSn){	
		//System.out.println("Yes");
		//System.out.println(orderStatus);
		Order o=new Order();
		o.setOrderSn(orderSn);
		o.setOrderId(id);
		o.setAddress(address);
		o.setOrderStatus(orderStatus);
		
		o.setExpressCode(expressCode);
		o.setRemark(remark);
		o.setIsUrgency(isUrgency);
		//System.out.println(o.getOrderSn());
		orderService.updateOrder(o);
		
		//System.out.println(o.getOrderSn());
		List<Order> orderList = orderService.showAllOrder();
	    model.addAttribute("orderList", orderList);
	    return "showOrderList";
    }
	
	@RequestMapping("manageButton")
    public String manageButton(Model model,HttpServletRequest request){
		long oid=Long.parseLong(request.getParameter("orderId"));
		Order o=orderService.getOrderById(oid);
		/*测试数据连接
		if(o == null)
			System.out.println("No"+oid);
		*/
		List<Goods> goodsList=goodsService.getGoodsByOrderid(oid);
		User u=userService.getUserByUserId(o.getUserId());
		model.addAttribute("order", o);
		model.addAttribute("goodsList", goodsList);
		model.addAttribute("user", u);
        return "manageButton";
    }
	
	@RequestMapping("searchOrder")
    public String searchOrder(){
		//System.out.println("Yes");
		return "searchOrder";
    }
	
	@RequestMapping("searchResult")
    public String searchResult(Model model,String orderSn,String addTime,
    		int orderStatus,String isUrgency,String goodsName,String consignee){
		//System.out.println("No");
		//System.out.println(isUrgency);
		//System.out.println(orderStatus);
		//System.out.println(orderSn);
		//System.out.println(consignee);
		Order order=new Order( orderSn, addTime, consignee, orderStatus, isUrgency);
		//System.out.println(order.getAddTime());
        List<Order> orderList = orderService.showOrder(order);
        // System.out.println(orderList.size());
        // if(orderList.size()!=0) System.out.println("搜索成功");
        //System.out.println(orderList.size());

        model.addAttribute("orderList", orderList);
	    return "showOrderList";
    }
	
	
	
	public long stringToLong(String str){
		long i=0;
		if(str==""||str==null) i=0;
		else i=Long.parseLong(str);
		return i;
	}
}

package xmu.mystore.ordersmgt.lhr.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xmu.mystore.ordersmgt.lhr.model.Order;
import xmu.mystore.ordersmgt.lhr.model.OrderGoods;
import xmu.mystore.ordersmgt.lhr.model.Page;
import xmu.mystore.ordersmgt.lhr.model.SearchOrder;
import xmu.mystore.ordersmgt.lhr.model.User;
import xmu.mystore.ordersmgt.lhr.service.OrderGoodsService;
import xmu.mystore.ordersmgt.lhr.service.OrderService;
import xmu.mystore.ordersmgt.lhr.service.UserService;


@Controller
@RequestMapping(value="/")
public class OrdermgtController 
{
	
	@Resource
	private OrderService orderService;
	@Resource
	private OrderGoodsService orderGoodsService;
	@Resource
	private UserService userService;
		
	@RequestMapping(method=RequestMethod.GET)
	public String getOrderList(Model model)
	{
		List<Order> orders = orderService.getAllOrder();
		
		Page page=new Page();
		page.setEverypage(2);
		page.setTotalPage(orders.size()/2+1);
		page.setCurrentPage(1);
		page.setHasNextPage(page.getTotalPage()>page.getCurrentPage()?true:false);
		page.setHasPrePage(page.getCurrentPage()>1?true:false);
		page.setTotalCount(orders.size());
		model.addAttribute("page", page);
		//model.addAttribute("orderlist",orders);
		//if(page.getCurrentPage()>1&&page.getCurrentPage()<page.getTotalPage())//不是第一页也不是最后一页
			//model.addAttribute("orderlist", orders.subList((page.getCurrentPage()-1)*2, page.getCurrentPage()*2));
		
		if(page.getCurrentPage()==1){
			if(page.getTotalCount()<=2)
				model.addAttribute("orderlist", orders.subList(0, page.getTotalCount()));
			else
				model.addAttribute("orderlist", orders.subList(0, 2));
		}
		//else 
			//model.addAttribute("orderlist", orders.subList((page.getCurrentPage()-1)*2, page.getTotalCount()));
		return "orderlist";
	}
	
	@RequestMapping("nextPage")
	public String nextPage(Model model, HttpServletRequest request)
	{
		List<Order> orders = orderService.getAllOrder();
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		Page page=new Page();
		page.setEverypage(2);
		page.setTotalPage(orders.size()/2+1);
		page.setCurrentPage(currentPage+1);
		page.setHasNextPage(page.getTotalPage()>page.getCurrentPage()?true:false);
		page.setHasPrePage(page.getCurrentPage()>1?true:false);
		page.setTotalCount(orders.size());
		model.addAttribute("page", page);
		//model.addAttribute("orderlist",orders);
		if(page.getCurrentPage()>1&&page.getCurrentPage()<page.getTotalPage())//不是第一页也不是最后一页
			model.addAttribute("orderlist", orders.subList((page.getCurrentPage()-1)*2, page.getCurrentPage()*2));
		if(page.getCurrentPage()==1){//是第一页
			if(page.getTotalCount()<=2)
				model.addAttribute("orderlist", orders.subList(0, page.getTotalCount()));
			else
				model.addAttribute("orderlist", orders.subList(0, 2));
		}
		else if(page.getCurrentPage()==page.getTotalPage())//最后一页
			model.addAttribute("orderlist", orders.subList((page.getCurrentPage()-1)*2, page.getTotalCount()));
		return "orderlist";
	}
	
	@RequestMapping("prePage")
	public String prePage(Model model, HttpServletRequest request)
	{
		List<Order> orders = orderService.getAllOrder();
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		Page page=new Page();
		page.setEverypage(2);
		page.setTotalPage(orders.size()/2+1);
		page.setCurrentPage(currentPage-1);
		page.setHasNextPage(page.getTotalPage()>page.getCurrentPage()?true:false);
		page.setHasPrePage(page.getCurrentPage()>1?true:false);
		page.setTotalCount(orders.size());
		model.addAttribute("page", page);
		//model.addAttribute("orderlist",orders);
		if(page.getCurrentPage()>1&&page.getCurrentPage()<page.getTotalPage())//不是第一页也不是最后一页
			model.addAttribute("orderlist", orders.subList((page.getCurrentPage()-1)*2, page.getCurrentPage()*2));
		if(page.getCurrentPage()==1){//是第一页
			if(page.getTotalCount()<=2)
				model.addAttribute("orderlist", orders.subList(0, page.getTotalCount()));
			else
				model.addAttribute("orderlist", orders.subList(0, 2));
		}
		else if(page.getCurrentPage()==page.getTotalPage())//最后一页
			model.addAttribute("orderlist", orders.subList((page.getCurrentPage()-1)*2, page.getTotalCount()));
		return "orderlist";
	}
	
	@RequestMapping("orderlist")
	public String getOrderList1(Model model)
	{
		List<Order> orders = orderService.getAllOrder();
		
		Page page=new Page();
		page.setEverypage(2);
		page.setTotalPage(orders.size()/2+1);
		page.setCurrentPage(1);
		page.setHasNextPage(page.getTotalPage()>page.getCurrentPage()?true:false);
		page.setHasPrePage(page.getCurrentPage()>1?true:false);
		page.setTotalCount(orders.size());
		model.addAttribute("page", page);
		if(page.getCurrentPage()==1){
			if(page.getTotalCount()<=2)
				model.addAttribute("orderlist", orders.subList(0, page.getTotalCount()));
			else
				model.addAttribute("orderlist", orders.subList(0, 2));
		}
		
		//model.addAttribute("orderlist", orders);
		return "orderlist";
	}
	
	
	@RequestMapping("lookupOrder")
	public String lookupOrder(Model model, HttpServletRequest request)
	{
		long order_id = Long.parseLong(request.getParameter("order_id"));
		List<OrderGoods> goods = orderGoodsService.getAllOrdersByOrderId(order_id);
		Order order = orderService.getOrderByOrderId(order_id);
		User user = userService.getUserByUserId(order.getUser_id());
		
		model.addAttribute("order", order);
		model.addAttribute("goodsList",goods);
		model.addAttribute("user", user);
		
		String isUrgency=request.getParameter("isUrgency");
		model.addAttribute("isUrgency", isUrgency);
		return "lookupOrder";
	}
	
	
	@RequestMapping("modifyOrder")
	public String modifyOrder(Model model, HttpServletRequest request)
	{
		long order_id = Long.parseLong(request.getParameter("order_id"));
		List<OrderGoods> goods = orderGoodsService.getAllOrdersByOrderId(order_id);
		Order order = orderService.getOrderByOrderId(order_id);
		model.addAttribute("order", order);
		model.addAttribute("goodsList",goods);
		return "modifyOrder";
	}
	
	@RequestMapping("updateOrder")
    public String updateOrder(Model model,long order_id, int order_status,String remark, String expressCode, 
    		String isUrgency, String consignee, String address,String telephone){	
		Order order =new Order();
		order.setOrder_id(order_id);
		order.setConsignee(consignee);
		order.setAddress(address);
		order.setTelephone(telephone);
		order.setOrder_status(order_status);
		order.setExpressCode(expressCode);
		order.setRemark(remark);
		order.setIsUrgency(isUrgency);
		orderService.updateOrder(order);
		List<Order> orderList = orderService.getAllOrder();
		
		Page page=new Page();
		page.setEverypage(2);
		page.setTotalPage(orderList.size()/2+1);
		page.setCurrentPage(1);
		page.setHasNextPage(page.getTotalPage()>page.getCurrentPage()?true:false);
		page.setHasPrePage(page.getCurrentPage()>1?true:false);
		page.setTotalCount(orderList.size());
		model.addAttribute("page", page);
		if(page.getCurrentPage()==1){
			if(page.getTotalCount()<=2)
				model.addAttribute("orderlist", orderList.subList(0, page.getTotalCount()));
			else
				model.addAttribute("orderlist", orderList.subList(0, 2));
		}
	    //model.addAttribute("orderlist", orderList);
	    return "orderlist";
    }
	
	@RequestMapping("updatePayedStatus")
	public String updatePayedStatus(Model model, HttpServletRequest request ){
		long order_id = Long.parseLong(request.getParameter("order_id"));
		Order order = orderService.getOrderByOrderId(order_id);
		order.setOrder_status(2);
		orderService.updateOrder(order);
		List<Order> orderList = orderService.getAllOrder();
		
		Page page=new Page();
		page.setEverypage(2);
		page.setTotalPage(orderList.size()/2+1);
		page.setCurrentPage(1);
		page.setHasNextPage(page.getTotalPage()>page.getCurrentPage()?true:false);
		page.setHasPrePage(page.getCurrentPage()>1?true:false);
		page.setTotalCount(orderList.size());
		model.addAttribute("page", page);
		if(page.getCurrentPage()==1){
			if(page.getTotalCount()<=2)
				model.addAttribute("orderlist", orderList.subList(0, page.getTotalCount()));
			else
				model.addAttribute("orderlist", orderList.subList(0, 2));
		}
		
	    //model.addAttribute("orderlist", orderList);
		return "orderlist";
	}
	
	@RequestMapping("transfer")
	public String transfer(Model model, HttpServletRequest request)
	{
		long order_id = Long.parseLong(request.getParameter("order_id"));
		List<OrderGoods> goods = orderGoodsService.getAllOrdersByOrderId(order_id);
		Order order = orderService.getOrderByOrderId(order_id);
		User user = userService.getUserByUserId(order.getUser_id());
		model.addAttribute("order", order);
		System.out.println(order.getUser_id());
		model.addAttribute("goodsList",goods);
		model.addAttribute("user", user);
		return "transfer";
	}
	
	@RequestMapping("updateTransfer")
	public String updateTransfer(Model model,long order_id, String expressCode){
		Order order = orderService.getOrderByOrderId(order_id);
		order.setOrder_status(3);
		order.setExpressCode(expressCode);
		
		orderService.updateOrder(order);
		List<Order> orderList = orderService.getAllOrder();
		
		Page page=new Page();
		page.setEverypage(2);
		page.setTotalPage(orderList.size()/2+1);
		page.setCurrentPage(1);
		page.setHasNextPage(page.getTotalPage()>page.getCurrentPage()?true:false);
		page.setHasPrePage(page.getCurrentPage()>1?true:false);
		page.setTotalCount(orderList.size());
		model.addAttribute("page", page);
		if(page.getCurrentPage()==1){
			if(page.getTotalCount()<=2)
				model.addAttribute("orderlist", orderList.subList(0, page.getTotalCount()));
			else
				model.addAttribute("orderlist", orderList.subList(0, 2));
		}
		
	    //model.addAttribute("orderlist", orderList);
		return "orderlist";
	}
	
	@RequestMapping("searchOrder")
	public String searchOrder()
	{
		return "searchOrder";
	}
	
	@RequestMapping("searchResult")
    public String searchResult(Model model,String order_id, String before_add_time,
    		String after_add_time,int order_status,String isUrgency,String goods_name,String consignee){
		long longOrder_id=0l;
		if(order_id != "")
			longOrder_id=Long.parseLong(order_id);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		long long_before = 0;
		
		if(before_add_time!="") {
			try{				
				long_before = sdf.parse(before_add_time).getTime()/1000;  
			}catch(Exception e){
				long_before=0;
				e.printStackTrace(); 
			}			
		}
		long long_after = 0;
		if(after_add_time!="") {
			try{
				long_after = sdf.parse(after_add_time).getTime()/100;  
			}catch(Exception e){
				long_after=0;
				e.printStackTrace(); 
			}			
		}
		
		SearchOrder searchOrder = new SearchOrder(longOrder_id,order_status,consignee,goods_name,long_before,long_after,isUrgency);
		
		List<Order> orders = orderService.searchOrder(searchOrder);
		
		Page page=new Page();
		page.setEverypage(2);
		page.setTotalPage(orders.size()/2+1);
		page.setCurrentPage(1);
		page.setHasNextPage(page.getTotalPage()>page.getCurrentPage()?true:false);
		page.setHasPrePage(page.getCurrentPage()>1?true:false);
		page.setTotalCount(orders.size());
		model.addAttribute("page", page);
		if(page.getCurrentPage()==1){
			if(page.getTotalCount()<=2)
				model.addAttribute("orderlist", orders.subList(0, page.getTotalCount()));
			else
				model.addAttribute("orderlist", orders.subList(0, 2));
		}
        
		//model.addAttribute("orderlist", orders);
	    return "orderlist";
    }

}

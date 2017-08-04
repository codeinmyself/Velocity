package xmu.mystore.ordersmgt.zf.controller;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import xmu.mystore.ordersmgt.zf.model.Order;
import xmu.mystore.ordersmgt.zf.model.Order_info;
import xmu.mystore.ordersmgt.zf.service.OrderService;



@Controller
@RequestMapping(value="/")
public class HomeController 
{
	
	@Autowired
	@Qualifier("orderService")
	private OrderService orderService;
	
	// 主页
	@RequestMapping(method=RequestMethod.GET)
	public String home()
	{
		return "ShowOrders";
	}
	
	private List<Order> temp;
	
	
	// 获取所有订单
	@RequestMapping(value="getOrders",method=RequestMethod.POST)
	@ResponseBody
	public List<Order> getAllOrders(){
		List<Order> orderlist = new ArrayList<Order>();
		List<Order_info> orders = orderService.getAllOrders();
		for(Order_info order : orders){
			Order od = new Order();
			od.setOrder_id(order.getOrder_id());
			od.setOrder_sn(order.getOrder_sn());
			od.setGoods_name(order.getGoods().get(0).getGoods_name());
			od.setAdd_time(getTime(order.getAdd_time()));
			od.setConsignee(order.getConsignee());
			od.setUser_name(order.getUser().getUser_name());
			od.setPrice(order.getOrder_price());
			String urgency = "否";
			String ur = order.getIsUrgency();
			if(ur.equals("Y"))
				urgency = "是";
			od.setIsUrgency(urgency);
			od.setRemark(order.getRemark());
			String state = "未付款";
			int status = order.getOrder_status();
			if(status == 1){
				state = "已付款";
			} else if (status == 2) {
				state = "已审核";
			} else if (status == 3) {
				state = "已发货";
			} else if (status == 4) {
				state = "已收货";
			} else if (status == 5) {
				state = "已取消";
			}
			od.setOrder_status(state);
			if(status <= 2){
				od.setShipped_time("-");
			} else {
				od.setShipped_time(getTime(order.getShipped_time()));
			}
			
			orderlist.add(od);
		}
		
		return orderlist;
	}
	
	// 获取加急订单
	@RequestMapping(value="getUrgentOrders",method=RequestMethod.POST)
	@ResponseBody
	public List<Order> getUrgentOrders(){
		List<Order> orderlist = new ArrayList<Order>();
		List<Order_info> orders = orderService.getAllOrders();
		for(Order_info order : orders){
			if(order.getIsUrgency().equals("N"))
				continue;
			Order od = new Order();
			od.setOrder_id(order.getOrder_id());
			od.setOrder_sn(order.getOrder_sn());
			od.setGoods_name(order.getGoods().get(0).getGoods_name());
			od.setAdd_time(getTime(order.getAdd_time()));
			od.setConsignee(order.getConsignee());
			od.setUser_name(order.getUser().getUser_name());
			od.setPrice(order.getOrder_price());
			od.setIsUrgency("是");
			od.setRemark(order.getRemark());
			String state = "未付款";
			int status = order.getOrder_status();
			if(status == 1){
				state = "已付款";
			} else if (status == 2) {
				state = "已审核";
			} else if (status == 3) {
				state = "已发货";
			} else if (status == 4) {
				state = "已收货";
			} else if (status == 5) {
				state = "已取消";
			}
			od.setOrder_status(state);
			if(status <= 2){
				od.setShipped_time("-");
			} else {
				od.setShipped_time(getTime(order.getShipped_time()));
			}
			
			orderlist.add(od);
		}
		
		return orderlist;
	}
	 
	// 获取订单详情
	@RequestMapping(value="checkOrder_info",method=RequestMethod.GET)
	public String getOrderById(long order_id, Model model){
		Order_info order = orderService.getOrderById(order_id);
		model.addAttribute("order", order);
		
		return "OrderDetail";
	}
	
	// 修改订单（跳转）
	@RequestMapping(value="updateOrder_info",method=RequestMethod.GET)
	public String skipToUpdateOrder(long order_id, Model model){
		Order_info order = orderService.getOrderById(order_id);
		model.addAttribute("order", order);
		
		return "updateOrder";
	}
	
	// 修改订单状态
	@RequestMapping(value="updateStatus",method=RequestMethod.GET)
	@ResponseBody
	public String updateStatus(long order_id, String status){
		Order_info order = orderService.getOrderById(order_id);
		int state = 0;
		if(status.equals("已付款")){
			state = 1;
			order.setPay_time((int)(System.currentTimeMillis() / 1000));
		} else if(status.equals("已审核")){
			state = 2;
			order.setMake_time((int)(System.currentTimeMillis() / 1000));
		} else if(status.equals("已发货")){
			state = 3;
			order.setShipped_time((int)(System.currentTimeMillis() / 1000));
		} else if(status.equals("已收货")){
			state = 4;
			order.setReceive_time((int)(System.currentTimeMillis() / 1000));
		} else if(status.equals("已取消")){
			state = 5;
			order.setCancel_time((int)(System.currentTimeMillis() / 1000));
		}
		if(state == order.getOrder_status()) {
			return null;
		}
		
		order.setOrder_status(state);
		orderService.updateOrder(order);
		
		return "success";
	}
	
	// 修改快递单号
	@RequestMapping(value="updateExpressCode",method=RequestMethod.GET)
	@ResponseBody
	public String updateExpressCode(long order_id, String expresscode){
		Order_info order = orderService.getOrderById(order_id);
		if(expresscode == null || expresscode.equals("无") || expresscode.equals(order.getExpressCode()))
			return null;
		
		order.setExpressCode(expresscode);
		orderService.updateOrder(order);
		
		return "success";
	}
	
	// 修改备注
	@RequestMapping(value="updateRemark",method=RequestMethod.GET)
	@ResponseBody
	public String updateRemark(long order_id, String remark){
		Order_info order = orderService.getOrderById(order_id);
		if(remark == null || remark.equals("无") || remark.equals(order.getRemark()))
			return null;
		
		order.setRemark(remark);
		orderService.updateOrder(order);
		
		return "success";
	}
	
	// 修改收货人信息
	@RequestMapping(value="updateAddress",method=RequestMethod.GET)
	@ResponseBody
	public String updateAddress(long order_id, String consignee, String zipcode, String telephone, String address){
		Order_info order = orderService.getOrderById(order_id);
		if(consignee.equals(order.getConsignee()) && zipcode.equals(order.getZipcode()) && telephone.equals(order.getTelephone()) && address.equals(order.getAddress()))
			return null;
		
		order.setConsignee(consignee);
		order.setZipcode(zipcode);
		order.setTelephone(telephone);
		order.setAddress(address);
		
		orderService.updateOrder(order);
		
		return "success";
	}
	
	// 确认订单
	@RequestMapping(value="checkOrder",method=RequestMethod.GET)
	public String checkOrder(long order_id){
		Order_info order = orderService.getOrderById(order_id);
		order.setOrder_status(2);
		order.setMake_time((int)(System.currentTimeMillis() / 1000));
		orderService.updateOrder(order);
		
		return "ShowOrders";
	}
	
	// 订单发货
	@RequestMapping(value="shipOrder",method=RequestMethod.GET)
	public String skipToShipOrder(long order_id, Model model){
		Order_info order = orderService.getOrderById(order_id);
		model.addAttribute("order", order);
		
		return "shipOrder";
	}
	
	// 发货
	@RequestMapping(value="Ship",method=RequestMethod.GET)
	@ResponseBody
	public String ship(long order_id, String expresscode){
		Order_info order = orderService.getOrderById(order_id);
		order.setOrder_status(3);
		order.setShipped_time((int)(System.currentTimeMillis() / 1000));
		order.setExpressCode(expresscode);
		orderService.updateOrder(order);
		
		return "success";
	}
	
	// 跳转
	@RequestMapping(value="search",method=RequestMethod.GET)
	public String skipToSearchOrder(){
		
		return "OrderSearch";
	}
	
	@RequestMapping(value="searchCondition",method=RequestMethod.GET)
	@ResponseBody
	public String getCondition(String order_sn, String start_date, String end_date, int isUrgency, int order_status, String goods_name, String consignee) throws ParseException{
		List<Order> orders = new ArrayList<Order>();
		if(order_sn != null && order_sn != ""){
			Order_info order = orderService.getOrderByOrder_sn(order_sn);
			if(order != null) {
				Order od = new Order();
				od.setOrder_id(order.getOrder_id());
				od.setOrder_sn(order.getOrder_sn());
				od.setGoods_name(order.getGoods().get(0).getGoods_name());
				od.setAdd_time(getTime(order.getAdd_time()));
				od.setConsignee(order.getConsignee());
				od.setUser_name(order.getUser().getUser_name());
				od.setPrice(order.getOrder_price());
				String urgency = "否";
				String ur = order.getIsUrgency();
				if(ur.equals("Y"))
					urgency = "是";
				od.setIsUrgency(urgency);
				od.setRemark(order.getRemark());
				String state = "未付款";
				int status = order.getOrder_status();
				if(status == 1){
					state = "已付款";
				} else if (status == 2) {
					state = "已审核";
				} else if (status == 3) {
					state = "已发货";
				} else if (status == 4) {
					state = "已收货";
				} else if (status == 5) {
					state = "已取消";
				}
				od.setOrder_status(state);
				if(status <= 2){
					od.setShipped_time("-");
				} else {
					od.setShipped_time(getTime(order.getShipped_time()));
				}
				
				orders.add(od);
			}
		} else {
			List<Order_info> orderes = orderService.getAllOrders();
			for(Order_info order : orderes){
				if(start_date != null && start_date != ""){
					if(order.getAdd_time() < getTimestamp(start_date))
						continue;
				} 
				if(end_date != null && end_date != ""){
					if(order.getAdd_time() > getTimestamp(end_date))
						continue;
				}
				if(isUrgency != -1){
					String ur = "N";
					if(isUrgency == 1)
						ur = "Y";
					if(!order.getIsUrgency().equals(ur))
						continue;
				} 
				if(order_status != -1){
					if(order.getOrder_status() != order_status)
						continue;
				} 
				if(goods_name != null && goods_name != ""){
					if(!order.getGoods().get(0).getGoods_name().equals(goods_name))
						continue;
				} 
				if(consignee != null && consignee != ""){
					if(!order.getConsignee().equals(consignee))
						continue;
				} 
				
				Order od = new Order();
				od.setOrder_id(order.getOrder_id());
				od.setOrder_sn(order.getOrder_sn());
				od.setGoods_name(order.getGoods().get(0).getGoods_name());
				od.setAdd_time(getTime(order.getAdd_time()));
				od.setConsignee(order.getConsignee());
				od.setUser_name(order.getUser().getUser_name());
				od.setPrice(order.getOrder_price());
				String urgency = "否";
				String ur = order.getIsUrgency();
				if(ur.equals("Y"))
					urgency = "是";
				od.setIsUrgency(urgency);
				od.setRemark(order.getRemark());
				String state = "未付款";
				int status = order.getOrder_status();
				if(status == 1){
					state = "已付款";
				} else if (status == 2) {
					state = "已审核";
				} else if (status == 3) {
					state = "已发货";
				} else if (status == 4) {
					state = "已收货";
				} else if (status == 5) {
					state = "已取消";
				}
				od.setOrder_status(state);
				if(status <= 2){
					od.setShipped_time("-");
				} else {
					od.setShipped_time(getTime(order.getShipped_time()));
				}
				
				orders.add(od);
			}
		}
		
		this.temp = orders;
		
		return "success";
	}
	
	@RequestMapping(value="searchResult",method=RequestMethod.GET)
	public String searchResult(){
		
		return "searchResult";
	}
	
	@RequestMapping(value="getSeachResults",method=RequestMethod.POST)
	@ResponseBody
	public List<Order> getSeachResults(){
		return this.temp;
	}
	
	private int getTimestamp(String date) throws ParseException{
		String[] dt = date.split("-");
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		String time = dt[0] + "/" + dt[1] + "/" + dt[2] + " 00:00:00";
		Date date1 = df.parse(time);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date1);
		long timestamp = cal.getTimeInMillis();
		//System.out.println(timestamp);
		
		return (int)(timestamp / 1000);
	}
	
	// 时间格式化
	private String getTime(int time)
	{
		Date date = new Date(((long)time) * 1000);
		//转换时间格式
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeString = simpleDateFormat.format(date);
		return timeString;
	}
}

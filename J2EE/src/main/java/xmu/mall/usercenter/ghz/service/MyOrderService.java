package xmu.mall.usercenter.ghz.service;



/**
 * 封装了 zf 的OrderService，做了一些功能增强
 * */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xmu.mall.usercenter.ghz.mapper.ICollectionMapper;
import xmu.mystore.ordersmgt.zf.model.Goods;
import xmu.mystore.ordersmgt.zf.model.Order_info;
import xmu.mystore.ordersmgt.zf.service.OrderService;

@Service
public class MyOrderService {
	
//	@Autowired
//	IOrderMapper orderMapper;
	
	@Autowired
	ICollectionMapper collectionMapper;
	
	@Autowired
	OrderService orderService;
	
	public List<Order_info> getOrderByTag(int user_id, String tag) {
		List<xmu.mystore.ordersmgt.zf.model.Order_info> orderList = null;
		switch(tag){
		case "forPay":
			orderList = orderService.getOrderByStatus(user_id, 0);
			break;
		case "forSend":
			orderList = orderService.getOrderByStatus(user_id,  1);
			orderList.addAll(orderService.getOrderByStatus(user_id, 2));
			break;
		case "forReceive":
			orderList = orderService.getOrderByStatus(user_id,  3);
			break;
		case "received":
			orderList = orderService.getOrderByStatus(user_id,  4);
			break;
		case "cancel":
			orderList = orderService.getOrderByStatus(user_id,  5);
			break;
		case "all":
			orderList = orderService.getOrderByUser_id(user_id);
			break;
		default: break;
		}
		return orderList;
	}
	
	public void removeOrder(int user_id, int order_id) {
		orderService.cancelOrder(order_id);
	}
	
	public void payOrder(int order_id) {
		
	}
	
	public void confirmOrder(int order_id) {
		orderService.receiveOrder(order_id);
	}
	
	public void cancelOrder(int order_id) {
		orderService.cancelOrder(order_id);
	}
	
	public List<Goods> getUserCollection(int user_id){
		return collectionMapper.getUserCollection(user_id);
	}
	
}

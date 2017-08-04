package xmu.mystore.ordersmgt.zyd.service;

import java.util.List;

import xmu.mystore.ordersmgt.zyd.entities.Order;

public interface OrderService {
	public List<Order> getAllOrder();
	public Order getOrderById(long oid);
	public List<Order> getOrder(Order order);
	public void updateOrder(Order order);
	//public void updateTime(IdTime it);
	public void updateTime(long id,int time);
	public String createOrder_sn();
	public List<Order> getOrderByUser_id(long user_id);
	public List<Order> getOrderByStatus(long user_id,int status);
	public void receiveOrder(long order_id);
	public void cancelOrder(long order_id);
	public void payOrder(long order_id);
}

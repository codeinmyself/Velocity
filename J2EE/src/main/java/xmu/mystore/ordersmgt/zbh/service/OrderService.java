package xmu.mystore.ordersmgt.zbh.service;

import java.util.List;

import xmu.mystore.ordersmgt.zbh.model.Order;

public interface OrderService {
	public Order getOrderById(long oid);
	public List<Order> showAllOrder();
	public Order getOrderByOrderId(String orderSn);
	public List<Order> showOrder(Order order);
	public void updateOrder(Order order);
	public List<Order>getOrderByUser_id(long user_id);
	public List<Order>getOrderByStatus(long user_id,int status);
	public void receiveOrder(long order_id);
	public void cancelOrder(long order_id);
	public String createOrder_sn();
}

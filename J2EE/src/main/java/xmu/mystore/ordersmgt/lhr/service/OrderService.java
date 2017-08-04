package xmu.mystore.ordersmgt.lhr.service;

import java.util.List;

import xmu.mystore.ordersmgt.lhr.model.Order;
import xmu.mystore.ordersmgt.lhr.model.SearchOrder;

public interface OrderService 
{
	public List<Order> getAllOrder();
	public Order getOrderByOrderId(long order_id);
	public void updateOrder(Order order);
	public List<Order> searchOrder(SearchOrder searchOrder);
	public String createOrder_sn();
	public List<Order> getOrderByUser_id(long user_id);
	public List<Order> getOrderByStatus(long user_id,int status);
	public void receiveOrder(long order_id);
	public void cancelOrder(long order_id);
}

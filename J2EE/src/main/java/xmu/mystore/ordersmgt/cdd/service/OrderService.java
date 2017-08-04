package xmu.mystore.ordersmgt.cdd.service;

import java.util.List;

import xmu.mystore.ordersmgt.cdd.model.Order;
import xmu.mystore.ordersmgt.cdd.model.SearchOrder;

public interface OrderService {
	public List<Order> getAllOrder();
	public Order getOrderByOrderId(long order_id);
	public void updateOrder(Order order);
	public List<Order> searchOrder(SearchOrder searchOrder);
	}

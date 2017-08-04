package xmu.mystore.ordermgt.lhr.service;

import java.util.List;

import xmu.mystore.ordermgt.lhr.model.Order;
import xmu.mystore.ordermgt.lhr.model.SearchOrder;

public interface OrderService {
	public List<Order> getAllOrder();
	public Order getOrderByOrderId(long order_id);
	public void updateOrder(Order order);
	public List<Order> searchOrder(SearchOrder searchOrder);
	}

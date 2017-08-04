package xmu.mystore.ordersmgt.tangkai.service;

import java.util.List;

import xmu.mystore.ordersmgt.tangkai.model.Order;
import xmu.mystore.ordersmgt.tangkai.model.SearchOrder;

/**
 * @author tangkai
 * @data 2017年6月2日--下午12:46:20 主要是调用了mapper的数据操作
 */
public interface OrderService {
	public List<Order> getAllOrder();

	public Order getOrderByOrderId(long order_id);

	public void updateOrder(Order order);

	public List<Order> searchOrder(SearchOrder searchOrder);

	public String createOrder_sn();

	public List<Order> getOrderByStatus(long user_id, int status);

	public void receiveOrder(long order_id);

	public void cancelOrder(long order_id);

	public List<Order> getOrderByUser_id(long user_id);

	public List<Order> getShoppingCart(long user_id);

	public void addOrder(Order order);
}

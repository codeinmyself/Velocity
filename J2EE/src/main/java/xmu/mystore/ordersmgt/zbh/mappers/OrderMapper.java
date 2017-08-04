package xmu.mystore.ordersmgt.zbh.mappers;

import java.util.List;

import org.springframework.stereotype.Repository;

import xmu.mystore.ordersmgt.zbh.model.Order;

@Repository
public interface OrderMapper {
	public Order getOrderById(long oid);
	public List<Order> showAllOrder();
	public Order getOrderByOrderId(String orderSn);
	public List<Order> showOrder(Order order);
	public void updateOrder(Order order);
	public List<Order>getOrderByUser_id(long user_id);
	public List<Order>getOrderByStatus(long user_id,int status);
	public void receiveOrder(long order_id,String receiveTime);
	public void cancelOrder(long order_id,String cancelTime);
}

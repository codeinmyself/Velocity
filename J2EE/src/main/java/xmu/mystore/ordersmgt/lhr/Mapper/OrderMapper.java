package xmu.mystore.ordersmgt.lhr.Mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import xmu.mystore.ordersmgt.lhr.model.Order;
import xmu.mystore.ordersmgt.lhr.model.SearchOrder;

@Repository
public interface OrderMapper 
{
	//具体实现在mapper层的OrderMapper.xml文件中
	public List<Order> getAllOrder();
	public Order getOrderByOrderId(long order_id);
	public void updateOrder(Order order);
	public List<Order> searchOrder(SearchOrder searchOrder);
	public List<Order> getOrderByUser_id(long user_id);
	public List<Order> getOrderByStatus(long user_id,int status);
	public void receiveOrder(long order_id);
	public void cancelOrder(long order_id);
}

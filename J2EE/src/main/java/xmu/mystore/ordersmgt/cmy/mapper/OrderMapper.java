package xmu.mystore.ordersmgt.cmy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import xmu.mystore.ordersmgt.cmy.entity.Order;
import xmu.mystore.ordersmgt.cmy.entity.SearchOrder;

@Repository
public interface OrderMapper {
	//具体实现在mapper层的OrderMapper.xml文件中
	public List<Order> getAllOrder();
	public Order getOrderByOrderId(long order_id);
	public void updateOrder(Order order);
	public List<Order> searchOrder(SearchOrder searchOrder);
	
	public List<Order> getOrderByUser_id(long user_id);
	public List<Order> getOrderByStatus(@Param("user_id")long user_id,@Param("status")long status);
	public void receiveOrder(@Param("order_id")long order_id,@Param("receive_time")int receive_time);
	public void cancelOrder(@Param("order_id")long order_id,@Param("cancel_time")int cancel_time);
}

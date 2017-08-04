package xmu.mystore.ordersmgt.tangkai.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import xmu.mystore.ordersmgt.tangkai.model.Order;
import xmu.mystore.ordersmgt.tangkai.model.SearchOrder;

/**
 * @author tangkai
 * @data 2017年6月2日--下午12:37:34
 * mapper的接口层，代码的实现层在OrderMapper.xml中
 */

@Repository
public interface OrderMapper {
	//获得所有的订单
	public List<Order> getAllOrder();
	
	//根据订单号获取订单
	public Order getOrderByOrderId(long order_id);
	
	//更新订单
	public void updateOrder(Order order);
	
	//查询订单
	public List<Order> searchOrder(SearchOrder searchOrder);
	
	//用户根据订单状态查询订单
	public List<Order> getOrderByStatus(@Param("user_id") long user_id, @Param("order_status") int order_status);
	
	//用户收货
	public void receiveOrder(@Param("order_id") long order_id, @Param("receive_time")  int receive_time);
	
	//用户取消订单
	public void cancelOrder(@Param("order_id") long order_id, @Param("cancel_time") int cancel_time);
	
	//获取当前用户所有订单
	public List<Order> getOrderByUser_id(long user_id);
	
	public void addOrder(Order order);
	
	public List<Order> getShoppingCart(long user_id);
}

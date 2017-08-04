package xmu.mystore.ordersmgt.zf.mapper;


import java.util.List;

import org.springframework.stereotype.Component;

import xmu.mystore.ordersmgt.zf.model.Order_info;


@Component
public interface Order_infoMapper {
	
	// 获取所有订单
	public List<Order_info> getAllOrders();
	
	// 根据订单ID获取订单
	public Order_info getOrderById(long id);
	
	// 根据订单编号获取订单
	public Order_info getOrderBySn(String sn);
	
	// 根据商品名称获取订单
	public List<Order_info> getOrderByGoods_name(String name);
	
	// 根据收货人获取订单
	public List<Order_info> getOrderByConsignee(String name);
	
	// 根据是否加急获取订单
	public List<Order_info> getOrderByIsUrgency(String ur);
	
	// 根据订单状态获取订单
	public List<Order_info> getOrderByStatus(int st);
	
	// 根据订单下单时间范围获取订单
	public List<Order_info> getOrderByOrder_time(int start, int end);
	
	// 修改订单
	public void updateOrder(Order_info order);

	// 确认订单
	public void checkOrder(Order_info order);

	public void updateStatus(Order_info order);

	public void updateAddress(Order_info order);

	// 根据用户ID获取用户订单
	public List<Order_info> getOrderByUser_id(long id);
	
	// 根据用户ID以及状态获取订单
	public List<Order_info> getOrdersByUserId_Status(long user_id, int status);

	// 确认收货
	public void receiveOrder(long order_id, int currentTimeMillis);

	// 取消订单
	public void cancelOrder(long order_id, int currentTimeMillis);
}

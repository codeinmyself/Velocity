package xmu.mall.usercenter.ghz.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import xmu.mall.usercenter.ghz.entity.Order_info;


public interface IOrderMapper {
	List<Order_info> getOrderListByType(@Param("user_id") int user_id, @Param("order_status") int order_status);
	
	List<Order_info> getOrders(int user_id);
	
	boolean removeOrder(@Param("user_id") int user_id, @Param("order_id") int order_id);
	
	boolean changeOrderStat(@Param("order_id") int order_id, @Param("order_status") int order_status);
}

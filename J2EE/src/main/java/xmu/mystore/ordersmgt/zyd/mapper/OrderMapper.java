package xmu.mystore.ordersmgt.zyd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import xmu.mystore.ordersmgt.zyd.entities.Order;

@Repository
public interface OrderMapper {
	public List<Order> getAllOrder();
	public Order getOrderById(long oid);
	public List<Order> getOrder(Order order);
	public void updateOrder(Order order);
	//public void updateTime(IdTime it);
	public void updateTime(@Param("id")long id,@Param("time")int time);
	public void updateReceiveTime(@Param("id")long id,@Param("time")int time);
	public void updateCancelTime(@Param("id")long id,@Param("time")int time);
	public void updatePayTime(@Param("id")long id,@Param("time")int time);
}

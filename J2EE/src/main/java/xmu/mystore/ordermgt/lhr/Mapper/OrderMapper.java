package xmu.mystore.ordermgt.lhr.Mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import xmu.mystore.ordermgt.lhr.model.Order;
import xmu.mystore.ordermgt.lhr.model.SearchOrder;

@Repository
public interface OrderMapper 
{
	//具体实现在mapper层的OrderMapper.xml文件中
	public List<Order> getAllOrder();
	public Order getOrderByOrderId(long order_id);
	public void updateOrder(Order order);
	public List<Order> searchOrder(SearchOrder searchOrder);
}

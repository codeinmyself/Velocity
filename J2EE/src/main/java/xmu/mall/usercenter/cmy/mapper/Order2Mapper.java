package xmu.mall.usercenter.cmy.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import xmu.mall.usercenter.cmy.entity.Order_info;
import xmu.mall.usercenter.cmy.entity.SearchOrder;

@Repository
public interface Order2Mapper {
	//具体实现在mapper层的OrderMapper.xml文件中
	public List<Order_info> getAllOrder();
	public Order_info getOrderByOrderId(long order_id);
	public void updateOrder(Order_info order);
	public List<Order_info> searchOrder(SearchOrder searchOrder);
}

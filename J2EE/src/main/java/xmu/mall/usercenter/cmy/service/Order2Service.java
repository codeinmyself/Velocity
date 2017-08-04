package xmu.mall.usercenter.cmy.service;

import java.util.List;

import xmu.mall.usercenter.cmy.entity.Order_info;
import xmu.mall.usercenter.cmy.entity.SearchOrder;

public interface Order2Service {
	public List<Order_info> getAllOrder();
	public Order_info getOrderByOrderId(long order_id);
	public void updateOrder(Order_info order);
	public List<Order_info> searchOrder(SearchOrder searchOrder);
	}

package xmu.mall.usercenter.cmy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mall.usercenter.cmy.entity.Order_info;
import xmu.mall.usercenter.cmy.entity.SearchOrder;
import xmu.mall.usercenter.cmy.mapper.Order2Mapper;
import xmu.mall.usercenter.cmy.service.Order2Service;

@Service
@Transactional(rollbackFor = Exception.class)
public class Order2ServiceImpl implements Order2Service{
	
	@Autowired (required=false) 
	private Order2Mapper orderMapper;
		
	public List<Order_info> getAllOrder()
	{
		if(orderMapper == null)
			System.out.println("I am so sad");
		return orderMapper.getAllOrder();
	}

	@Override
	public Order_info getOrderByOrderId(long order_id) {
		// TODO Auto-generated method stub
		return orderMapper.getOrderByOrderId(order_id);
	}

	@Override
	public void updateOrder(Order_info order) {
		// TODO Auto-generated method stub
		orderMapper.updateOrder(order);
	}

	@Override
	public List<Order_info> searchOrder(SearchOrder searchOrder) {
		// TODO Auto-generated method stub
		return orderMapper.searchOrder(searchOrder);
	}
}

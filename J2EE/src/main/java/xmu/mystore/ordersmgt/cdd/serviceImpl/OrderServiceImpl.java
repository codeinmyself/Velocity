package xmu.mystore.ordersmgt.cdd.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mystore.ordersmgt.cdd.dao.OrderMapper;
import xmu.mystore.ordersmgt.cdd.model.Order;
import xmu.mystore.ordersmgt.cdd.model.SearchOrder;
import xmu.mystore.ordersmgt.cdd.service.OrderService;

@Service
@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl implements OrderService{
	
	@Autowired (required=false) 
	private OrderMapper orderMapper;
		
	public List<Order> getAllOrder()
	{
		if(orderMapper == null)
			System.out.println("I am so sad");
		return orderMapper.getAllOrder();
	}

	@Override
	public Order getOrderByOrderId(long order_id) {
		// TODO Auto-generated method stub
		return orderMapper.getOrderByOrderId(order_id);
	}

	@Override
	public void updateOrder(Order order) {
		// TODO Auto-generated method stub
		orderMapper.updateOrder(order);
	}

	@Override
	public List<Order> searchOrder(SearchOrder searchOrder) {
		// TODO Auto-generated method stub
		return orderMapper.searchOrder(searchOrder);
	}
}

package xmu.mystore.ordermgt.lhr.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mystore.ordermgt.lhr.Mapper.OrderMapper;
import xmu.mystore.ordermgt.lhr.model.Order;
import xmu.mystore.ordermgt.lhr.model.SearchOrder;
import xmu.mystore.ordermgt.lhr.service.OrderService;

@Service
@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl implements OrderService{
	
	@Autowired (required=false) 
	private OrderMapper orderMapper;
		
	public List<Order> getAllOrder()
	{
		if(orderMapper == null)
			System.out.println("No order");
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

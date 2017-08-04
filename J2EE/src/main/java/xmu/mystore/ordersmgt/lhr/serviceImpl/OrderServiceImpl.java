package xmu.mystore.ordersmgt.lhr.serviceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mystore.ordersmgt.lhr.Mapper.OrderMapper;
import xmu.mystore.ordersmgt.lhr.model.Order;
import xmu.mystore.ordersmgt.lhr.model.SearchOrder;
import xmu.mystore.ordersmgt.lhr.service.OrderService;

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
	public Order getOrderByOrderId(long order_id) 
	{
		// TODO Auto-generated method stub
		return orderMapper.getOrderByOrderId(order_id);
	}

	@Override
	public void updateOrder(Order order)
	{
		// TODO Auto-generated method stub
		orderMapper.updateOrder(order);
	}

	@Override
	public List<Order> searchOrder(SearchOrder searchOrder) {
		// TODO Auto-generated method stub
		return orderMapper.searchOrder(searchOrder);
	}

	@Override
	public String createOrder_sn()
	{
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyyMMdd");
		String time=format.format(date);
		int x1=(int)(Math.random()*10);
		int x2=(int)(Math.random()*10);
		int x3=(int)(Math.random()*10);
		int x4=(int)(Math.random()*10);
		int x5=(int)(Math.random()*10);		
		time=time+String.valueOf(x1)+String.valueOf(x2)+String.valueOf(x3)+String.valueOf(x4)+String.valueOf(x5);
		return time;
	}

	@Override
	public List<Order> getOrderByUser_id(long user_id)
	{
		// TODO Auto-generated method stub
		return orderMapper.getOrderByUser_id(user_id);
	}

	@Override
	public List<Order> getOrderByStatus(long user_id, int status) 
	{
		// TODO Auto-generated method stub
		return orderMapper.getOrderByStatus(user_id,status);
	}

	@Override
	public void receiveOrder(long order_id)
	{
		orderMapper.receiveOrder(order_id);
		
	}

	@Override
	public void cancelOrder(long order_id) 
	{
		orderMapper.cancelOrder(order_id);
		
	}
}

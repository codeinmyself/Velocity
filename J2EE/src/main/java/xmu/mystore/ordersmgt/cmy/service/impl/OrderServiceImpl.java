package xmu.mystore.ordersmgt.cmy.service.impl;

import java.util.List;
import java.util.Random;
import java.util.Date;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mystore.ordersmgt.cmy.entity.Order;
import xmu.mystore.ordersmgt.cmy.entity.SearchOrder;
import xmu.mystore.ordersmgt.cmy.mapper.OrderMapper;
import xmu.mystore.ordersmgt.cmy.service.OrderService;

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
	
	@Override
	public String createOrder_sn(){
		Calendar now=Calendar.getInstance();//日期类
		int year=now.get(Calendar.YEAR);
		int month=now.get(Calendar.MONTH)+1;
		int day=now.get(Calendar.DAY_OF_MONTH);
		Random random=new Random();
		int rand1=random.nextInt(10);
		int rand2=random.nextInt(10);
		int rand3=random.nextInt(10);
		int rand4=random.nextInt(10);
		int rand5=random.nextInt(10);
		String order_sn="";
		if(month<10)
			order_sn=""+year+"0"+month;
		else
			order_sn=""+year+month;
		if(day<10)
			order_sn=order_sn+"0"+day+rand1+rand2+rand3+rand4+rand5;
		else 
			order_sn=order_sn+day+rand1+rand2+rand3+rand4+rand5;
		System.out.println(order_sn);
		return order_sn;
	}
	@Override
	public List<Order> getOrderByUser_id(long user_id){
		// TODO Auto-generated method stub
		System.out.println("this is the getOrderByUser_id");
		return orderMapper.getOrderByUser_id(user_id);
	}
	@Override
	public List<Order> getOrderByStatus(long user_id,int status){
		
		System.out.println("this is the getOrderByStatus");
		return orderMapper.getOrderByStatus(user_id,(long)status);
	}
	@Override
	public void receiveOrder(long order_id){
		// TODO Auto-generated method stub
		System.out.println("this is the receiveOrder");
		int receive_time=(int)(System.currentTimeMillis()/1000L);
		orderMapper.receiveOrder(order_id,receive_time);
	}
	@Override
	public void cancelOrder(long order_id){
		// TODO Auto-generated method stub
		System.out.println("this is the cancelOrder");
		int cancel_time=(int)(System.currentTimeMillis()/1000L);
		orderMapper.cancelOrder(order_id,cancel_time);
	}
}

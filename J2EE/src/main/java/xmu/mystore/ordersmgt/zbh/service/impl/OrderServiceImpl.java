package xmu.mystore.ordersmgt.zbh.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mystore.ordersmgt.zbh.mappers.OrderMapper;
import xmu.mystore.ordersmgt.zbh.model.Order;
import xmu.mystore.ordersmgt.zbh.service.OrderService;

@Service
@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl implements OrderService{
	@Autowired (required=false) 
	private OrderMapper orderMapper;

	public Order getOrderById(long oid){
		return orderMapper.getOrderById(oid);
	}
	public void updateOrder(Order order){
		orderMapper.updateOrder(order);
	}

	@Override
	public List<Order> showAllOrder() {
		// TODO Auto-generated method stub
		return orderMapper.showAllOrder();
	}

	@Override
	public Order getOrderByOrderId(String orderSn) {
		// TODO Auto-generated method stub
		return orderMapper.getOrderByOrderId(orderSn);
	}

	@Override
	public List<Order> showOrder(Order order) {
		// TODO Auto-generated method stub
		return orderMapper.showOrder(order);
	}
	@Override
	public List<Order> getOrderByUser_id(long user_id) {
		// TODO Auto-generated method stub
		return orderMapper.getOrderByUser_id(user_id);
	}
	@Override
	public List<Order> getOrderByStatus(long user_id, int status) {
		// TODO Auto-generated method stub
		return orderMapper.getOrderByStatus(user_id, status);
	}
	@Override
	public void receiveOrder(long order_id) {
		// TODO Auto-generated method stub
		String receiveTime = String.valueOf(System.currentTimeMillis()/1000);
		orderMapper.receiveOrder(order_id,receiveTime);
	}
	@Override
	public void cancelOrder(long order_id) {
		// TODO Auto-generated method stub
		String cancelTime = String.valueOf(System.currentTimeMillis()/1000);
		orderMapper.cancelOrder(order_id,cancelTime);
	}
	@Override
	public String createOrder_sn() {
		// TODO Auto-generated method stub
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		String date = df.format(new Date());
		Random rm = new Random();
		//获得随机数
		int pross = 10000+rm.nextInt(90000);
		String rms = String.valueOf(pross);
		
		return  (date+rms);
	}
}

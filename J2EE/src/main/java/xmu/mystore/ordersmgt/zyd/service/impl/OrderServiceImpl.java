package xmu.mystore.ordersmgt.zyd.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mystore.ordersmgt.zyd.entities.Order;
import xmu.mystore.ordersmgt.zyd.mapper.OrderMapper;
import xmu.mystore.ordersmgt.zyd.service.OrderService;

@Service
@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl implements OrderService{
	@Autowired (required=false) 
	private OrderMapper orderDao;
	
	public List<Order> getAllOrder(){
		return orderDao.getAllOrder();
	}
	
	public Order getOrderById(long oid){
		return orderDao.getOrderById(oid);
	}
	
	public List<Order> getOrder(Order order){
		return orderDao.getOrder(order);
	}
	
	public void updateOrder(Order order){
		orderDao.updateOrder(order);
	}
	public void updateTime(long id,int time){
		orderDao.updateTime(id,time);
	}
	/*public void updateTime(IdTime it){
		orderDao.updateTime(it);
	}*/
	public String createOrder_sn(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd HH:mm:ss");
		String str=sdf.format(new Date());
		String[] strArray = str.split(" ");
		str=strArray[0]+strArray[1]+strArray[2];
		Random random = new Random();
		for(int i=0;i<5;i++){
			str+=random.nextInt(9);
		}
		return str;
	}
	public List<Order> getOrderByUser_id(long user_id){
		Order order=new Order(0, "", "", "","", -1, user_id,-1,"","","");
		return orderDao.getOrder(order);
	}
	public List<Order> getOrderByStatus(long user_id,int status){
		Order order=new Order(0, "", "", "","", -1, user_id,status,"","","");
		return orderDao.getOrder(order);
	}
	public void receiveOrder(long order_id){
		Order o=orderDao.getOrderById(order_id);
		o.setState(4);
		orderDao.updateOrder(o);
		orderDao.updateReceiveTime(order_id,(int)(new Date().getTime()/1000));
	}
	public void cancelOrder(long order_id){
		Order o=orderDao.getOrderById(order_id);
		o.setState(5);
		orderDao.updateOrder(o);
		orderDao.updateCancelTime(order_id,(int)(new Date().getTime()/1000));
	}
	public void payOrder(long order_id){
		Order o=orderDao.getOrderById(order_id);
		o.setState(1);
		orderDao.updateOrder(o);
		orderDao.updatePayTime(order_id,(int)(new Date().getTime()/1000));
	}
}

package xmu.mystore.ordersmgt.zf.service;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mystore.ordersmgt.zf.mapper.Order_infoMapper;
import xmu.mystore.ordersmgt.zf.model.Order_info;

@Service("orderService")
@Transactional
public class OrderService {

	@Autowired
	private Order_infoMapper orderDao;
	
	// 获取全部订单
	public List<Order_info> getAllOrders() {
		return orderDao.getAllOrders();
	}
	
	// 根据用户ID获取订单
	public List<Order_info> getOrderByUser_id(long user_id){
		return this.orderDao.getOrderByUser_id(user_id);
	}

	public Order_info getOrderById(long id) {
		return orderDao.getOrderById(id);
	}

	public Order_info getOrderBySn(String sn) {
		return orderDao.getOrderBySn(sn);
	}

	public List<Order_info> getOrderByGoods_name(String name) {
		return orderDao.getOrderByGoods_name(name);
	}

	public List<Order_info> getOrderByConsignee(String name) {
		return orderDao.getOrderByConsignee(name);
	}

	public List<Order_info> getOrderByIsUrgency(String ur) {
		return orderDao.getOrderByIsUrgency(ur);
	}

	public List<Order_info> getOrderByStatus(int st) {
		return orderDao.getOrderByStatus(st);
	}

	public List<Order_info> getOrderByOrder_time(int start, int end) {
		return orderDao.getOrderByOrder_time(start, end);
	}

	public void updateOrder(Order_info order) {
		orderDao.updateOrder(order);
	}

	public void checkOrder(Order_info order) {
		orderDao.checkOrder(order);
	}

	public void updateStatus(Order_info order) {
		orderDao.updateStatus(order);
	}

	public void updateAddress(Order_info order) {
		orderDao.updateAddress(order);
	}

	public Order_info getOrderByOrder_sn(String order_sn) {
		return orderDao.getOrderBySn(order_sn);
	}
	
	// 生成订单编号
	public String createOrder_sn(){
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		Date d = new Date();
		String date = df.format(d);
		Random random = new Random();  
        StringBuffer sb = new StringBuffer(date);
        for(int i = 0; i < 5; i++){
        	int num = random.nextInt(10);
        	sb.append(num);
        }
        
        return sb.toString();
	}
	
	// 获取用户的某个状态的订单
	public List<Order_info> getOrderByStatus(long user_id,int status){
		return this.orderDao.getOrdersByUserId_Status(user_id, status);
	}
	
	// 确认收货
	public void receiveOrder(long order_id){
		this.orderDao.receiveOrder(order_id, getCurrentTimestamp());
	}
	
	// 取消订单
	public void cancelOrder(long order_id){
		this.orderDao.cancelOrder(order_id, getCurrentTimestamp());
	}

	// 获取当前时间戳
	public int getCurrentTimestamp(){
		long millis = System.currentTimeMillis();
		int ms = (int)(millis/1000);
			
		return ms;
	}
}

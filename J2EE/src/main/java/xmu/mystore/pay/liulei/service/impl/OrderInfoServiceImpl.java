package xmu.mystore.pay.liulei.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xmu.mystore.pay.liulei.mapper.OrderGoodsMapper;
import xmu.mystore.pay.liulei.mapper.OrderInfoMapper;
import xmu.mystore.pay.liulei.model.OrderGoods;
import xmu.mystore.pay.liulei.model.OrderInfo;
import xmu.mystore.pay.liulei.service.OrderGoodsService;
import xmu.mystore.pay.liulei.service.OrderInfoService;

@Service("OrderInfoService")
public class OrderInfoServiceImpl implements OrderInfoService {

	@Autowired
	private OrderInfoMapper orderInfoDao;

	@Override
	public void addAOrderInfo(OrderInfo orderInfo) {
		orderInfoDao.add(orderInfo);
	}
	
	@Override
	public OrderInfo getOrderInfo(long id){
		return orderInfoDao.getOrderInfo(id);
	}
	
	@Override
	public void setOrderStatus(int order_status, long order_id) {
		orderInfoDao.setOrderStatus(order_status, order_id);
	}
}
package xmu.mystore.pay.liulei.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mystore.pay.liulei.mapper.OrderGoodsMapper;
import xmu.mystore.pay.liulei.model.OrderGoods;
import xmu.mystore.pay.liulei.service.OrderGoodsService;

@Service("OrderGoodsService")
@Transactional
public class OrderGoodsServiceImpl implements OrderGoodsService {

	@Autowired
	private OrderGoodsMapper orderGoodsDao;

	@Override
	public OrderGoods addAOrderGoods(OrderGoods orderGoods) {
		orderGoodsDao.add(orderGoods);
		return null;
	}

	@Override
	public void deleteAOrderGoods(OrderGoods orderGoods) {
		orderGoodsDao.delete(orderGoods);
	}

	@Override
	public List<OrderGoods> getOrderGoods(long order_id) {
		return orderGoodsDao.selectByOrderId(order_id);
	}

}
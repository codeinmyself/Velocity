package xmu.mystore.ordermgt.lhr.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mystore.ordermgt.lhr.Mapper.OrderGoodsMapper;
import xmu.mystore.ordermgt.lhr.model.OrderGoods;
import xmu.mystore.ordermgt.lhr.service.OrderGoodsService;

@Service
@Transactional(rollbackFor = Exception.class)
public class OrderGoodsServiceImpl implements OrderGoodsService{

	
	@Autowired (required=false) 
	private OrderGoodsMapper orderGoodsMapper;


	@Override
	public List<OrderGoods> getAllOrdersByOrderId(long order_id) {
		// TODO Auto-generated method stub
		return this.orderGoodsMapper.getAllGoodsByOrderId(order_id);
	}
	


}

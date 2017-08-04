package xmu.mall.usercenter.cmy.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mall.usercenter.cmy.entity.OrderGoods;
import xmu.mall.usercenter.cmy.mapper.OrderGoods2Mapper;
import xmu.mall.usercenter.cmy.service.OrderGoods2Service;

@Service
@Transactional(rollbackFor = Exception.class)
public class OrderGoods2ServiceImpl implements OrderGoods2Service{

	
	@Autowired (required=false) 
	private OrderGoods2Mapper orderGoodsMapper;


	@Override
	public List<OrderGoods> getAllOrdersByOrderId(long order_id) {
		// TODO Auto-generated method stub
		return this.orderGoodsMapper.getAllGoodsByOrderId(order_id);
	}
	

	public List<OrderGoods> getAllGoodsByUserId(@Param("user_id")long user_id){
		// TODO Auto-generated method stub
				return this.orderGoodsMapper.getAllGoodsByUserId(user_id);
	}

	public List<OrderGoods> getSelectedGoodsByUserId(@Param("user_id")long user_id,@Param("order_status")int order_status){
		// TODO Auto-generated method stub
				return this.orderGoodsMapper.getSelectedGoodsByUserId(user_id,order_status);
	}
	


}

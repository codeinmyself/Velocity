package xmu.mall.usercenter.cmy.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import xmu.mall.usercenter.cmy.entity.OrderGoods;

public interface OrderGoods2Service {
	public List<OrderGoods> getAllOrdersByOrderId(long order_id);
	public List<OrderGoods> getAllGoodsByUserId(@Param("user_id")long user_id);
	public List<OrderGoods> getSelectedGoodsByUserId(@Param("user_id")long user_id,@Param("order_status")int order_status);


}

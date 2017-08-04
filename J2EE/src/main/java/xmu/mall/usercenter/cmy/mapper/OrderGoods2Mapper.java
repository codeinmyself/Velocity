package xmu.mall.usercenter.cmy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import xmu.mall.usercenter.cmy.entity.OrderGoods;
import xmu.mall.usercenter.cmy.entity.Order_info;

//@Repository用于标注数据访问组件，即DAO组件；
@Repository
public interface OrderGoods2Mapper {
	public List<OrderGoods> getAllGoodsByOrderId(long order_id);
	public List<OrderGoods> getAllGoodsByUserId(@Param("user_id")long user_id);
	public List<OrderGoods> getSelectedGoodsByUserId(@Param("user_id")long user_id,@Param("order_status")int order_status);

}

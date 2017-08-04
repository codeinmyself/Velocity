package xmu.mystore.ordersmgt.cmy.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import xmu.mystore.ordersmgt.cmy.entity.Order;
import xmu.mystore.ordersmgt.cmy.entity.OrderGoods;

//@Repository用于标注数据访问组件，即DAO组件；
@Repository
public interface OrderGoodsMapper {
	public List<OrderGoods> getAllGoodsByOrderId(long order_id);
}

package xmu.mystore.ordersmgt.tangkai.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import xmu.mystore.ordersmgt.tangkai.model.OrderGoods;

//@Repository用于标注数据访问组件，即DAO组件；
/**
 * @author tangkai
 * @data 2017年6月2日--下午1:17:15
 */
@Repository
public interface OrderGoodsMapper {
	public List<OrderGoods> getAllGoodsByOrderId(long order_id);
	public void addOrderGoods(OrderGoods orderGoods);
}

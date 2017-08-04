package xmu.mystore.ordersmgt.zyd.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import xmu.mystore.ordersmgt.zyd.entities.Goods;

@Repository
public interface OrderGoodsMapper {
	public List<Goods> getGoodsByOrderid(long oid);
}

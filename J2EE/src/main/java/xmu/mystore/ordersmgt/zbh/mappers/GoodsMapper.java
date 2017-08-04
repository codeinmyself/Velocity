package xmu.mystore.ordersmgt.zbh.mappers;

import java.util.List;

import org.springframework.stereotype.Repository;

import xmu.mystore.ordersmgt.zbh.model.Goods;

@Repository
public interface GoodsMapper {
	public List<Goods> getGoodsByOrderid(long oid);
}

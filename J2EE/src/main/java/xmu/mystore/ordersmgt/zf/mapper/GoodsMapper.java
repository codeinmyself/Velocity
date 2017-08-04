package xmu.mystore.ordersmgt.zf.mapper;

import org.springframework.stereotype.Component;

import xmu.mystore.ordersmgt.zf.model.Goods;


@Component
public interface GoodsMapper {
	public Goods getGoodsById(long id);
	
	String getGoodsImageById(long id);
}

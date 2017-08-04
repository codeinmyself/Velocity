package xmu.mystore.ordersmgt.zyd.service;

import java.util.List;

import xmu.mystore.ordersmgt.zyd.entities.Goods;

public interface GoodsService {
	public List<Goods> getGoodsByOrderid(long oid);
}

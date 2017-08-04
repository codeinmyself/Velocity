package xmu.mystore.ordersmgt.zbh.service;

import java.util.List;

import xmu.mystore.ordersmgt.zbh.model.Goods;

public interface GoodsService {
	public List<Goods> getGoodsByOrderid(long oid);
}

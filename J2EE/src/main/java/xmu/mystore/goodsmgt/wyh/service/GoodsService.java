package xmu.mystore.goodsmgt.wyh.service;

import java.util.List;

import xmu.mystore.goodsmgt.wyh.model.Goods;

public interface GoodsService {

	Goods getGoodsById(String goodsId);
	
	List<Goods> getGoodsByName(String name);
	
	List<Goods> getAllGoods();
	
	Goods insertGoods(Goods goods);
	
	void updateGoodsNameById(int id);
	
	Goods getGoodsByGoodsCode(String serialCode);
	
	void updateGoodsById(Goods goods);
	
	List<Goods> getGoodsByStandAndBrand(int begin ,int step,int standId,int brandId);
	
	List<Goods> getGoodsByStand(int begin ,int step,int standId);
	
	List<Goods> getGoodsByBrand(int begin ,int step,int brandId);
	
	List<Goods> getGoodsByNumber(int begin ,int step);
	
	void deleteGoodsById(String id);
}

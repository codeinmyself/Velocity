package xmu.mystore.goodsmgt.wyh.service;

import java.util.List;
import java.util.Map;

import xmu.mystore.goodsmgt.wyh.model.Brand;
import xmu.mystore.goodsmgt.wyh.model.Category;
import xmu.mystore.goodsmgt.wyh.model.Goods;
import xmu.mystore.goodsmgt.wyh.model.Stand;

public interface IGoodsService {
	Goods getGoodsByGoodsCode(String serialCode);

	Goods getGoodsByGoodsId(long id);
	
	List<Goods> getGoodsByGoodsName(String goods_name);
	// 模糊查找

	List<Goods> getGoodsBy(Map<String, String> array);
	// 平拍

	List<Category> getCategoryList();

	List<Brand> getBrandList();

	Stand getGoodsPrice(Long goods_id);
}

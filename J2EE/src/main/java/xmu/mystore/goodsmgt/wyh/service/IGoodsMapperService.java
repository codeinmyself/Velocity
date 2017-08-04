package xmu.mystore.goodsmgt.wyh.service;

import java.util.List;
import java.util.Map;

import xmu.mystore.goodsmgt.wyh.model.Brand;
import xmu.mystore.goodsmgt.wyh.model.Category;
import xmu.mystore.goodsmgt.wyh.model.Goods;
import xmu.mystore.goodsmgt.wyh.model.Stand;

public interface IGoodsMapperService {
	public Goods getGoodsByGoodsCode(String serialCode);
	
	public List<Goods> getGoodsByGoodsName(String goods_name);
	//模糊查找
	
	public List<Goods> getGoodsBy(Map<String,String> array);
	//平拍
	
	public List<Category> getCategoryList();
	
	public List<Brand> getBrandList();
	
	public Stand getGoodsPrice(Long goods_id);
}

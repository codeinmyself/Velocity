package xmu.mystore.goodsmgt.lcf.service;

import java.util.List;

import xmu.mystore.goodsmgt.lcf.model.Brand;
import xmu.mystore.goodsmgt.lcf.model.Category;
import xmu.mystore.goodsmgt.lcf.model.Goods;
import xmu.mystore.goodsmgt.lcf.model.SelectParameters;

public interface GoodsService {

	public boolean addGoods(Goods goods);

	public boolean deleteGoods(Goods goods);

	public boolean modifyGoods(Goods goods);

	public Goods getAGoods(Goods goods);

	public List<Goods> getAllGoods();
	
	public Goods getGoodsBySerialCode(Goods goods);

	public List<Goods> getGoodsByBrand(long brandId);

	public List<Goods> getGoodsByName(Goods goods);

	public List<Goods> getGoodsByCategory(long categoryId);

	public List<Goods> getGoodsByBrandAndCategory(long brandId, long categoryId);

	public List<Goods> getGoodsByPage(int pageNumber, int pageSize);

	public Category getCategory(Goods goods);

	public Brand getBrand(Goods goods);

	public List<Goods> getGoodsBy(SelectParameters selects);
}

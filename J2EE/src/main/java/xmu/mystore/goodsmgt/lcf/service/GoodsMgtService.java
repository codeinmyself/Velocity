package xmu.mystore.goodsmgt.lcf.service;

import java.util.List;
import xmu.mystore.goodsmgt.lcf.model.*;

public interface GoodsMgtService {

	/**
	 * 根据商品ID查找商品
	 * 
	 * @param id
	 * @return
	 */
	public Goods getGoodsByGoodsId(Long id);

	/**
	 * 根据商品编号查找商品
	 * 
	 * @param serial_code
	 * @return Goods
	 */
	public Goods getGoodsByGoodsCode(String serial_code);

	/**
	 * 根据商品名称查找商品（可以尝试下模糊查询）
	 * 
	 * @param goods_name
	 * @return
	 */
	public List<Goods> getGoodsByGoodsName(String goods_name);

	/**
	 * 根据传进来的参数先判断参数是哪些, 如果参数为一个以上，自行选择链接查询！！ 注意返回的商品都是已上架商品
	 * 
	 * @param selects
	 * @return
	 */
	public List<Goods> getGoodsBy(SelectParameters selects);

	/**
	 * @return 所有可以显示到前台的商品品类(前台显示顺序从小到大排序 )
	 */
	public List<Category> getCategoryList();

	/** 返回所有可以显示到前台的商品品牌
	 * @return  List<Brand>
	 */
	public List<Brand> getBrandList();

	/**
	 * 返回一个符合条件且已上架的上架信息（主要是为了查询商品价格）
	 * 
	 * @param goods_id
	 * @return Stand
	 */
	public Stand getGoodsPrice(Long goods_id);

}

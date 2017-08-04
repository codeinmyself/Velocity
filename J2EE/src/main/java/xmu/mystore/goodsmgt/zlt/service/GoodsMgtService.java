package xmu.mystore.goodsmgt.zlt.service;

import java.util.List;
import xmu.mystore.goodsmgt.zlt.model.*;

/**
 * @author zhenglongtian
 *
 */
public interface GoodsMgtService {

	/**
	 * @param goodsId
	 * @return
	 */
	public Goods getGoodsByGoodsId(Long goodsId);

	/**
	 * @param serialCode
	 * @return
	 */
	public Goods getGoodsByGoodsCode(String serialCode);

	/**
	 * @param goodsName
	 * @return
	 */
	public List<Goods> getGoodsByGoodsName(String goodsName);

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

	/**
	 * 返回所有可以显示到前台的商品品牌
	 * 
	 * @return List<Brand>
	 */
	public List<Brand> getBrandList();

	/**
	 * 返回一个符合条件且已上架的上架信息（主要是为了查询商品价格）
	 * 
	 * @param goods_id
	 * @return Stand
	 */
	public Stand getGoodsPrice(Long goodsId);

	/**
	 * 根据传递进来的商品id和商品数量减少商品表相应商品的库存（stock_count字段） 和增加销量（pre_sale_number字段）
	 * 同时还要修改上下架表对应商品的库存（pre_sale_count字段）
	 * 
	 * @param goodsId
	 * @param num
	 * @return
	 */
	public boolean deleteGoodsNumById(Long goodsId, int num);

}

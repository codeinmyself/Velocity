package xmu.mystore.goodsmgt.zlt.service.impls;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xmu.mystore.goodsmgt.zlt.model.*;
import xmu.mystore.goodsmgt.zlt.service.*;

/**
 * @author zhenglongtian
 *
 */
@Service("GoodsMgtService")
public class GoodsMgtServiceImpl implements GoodsMgtService {
	@Autowired
	private BrandService brandService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private GoodsService goodsService;

	@Autowired
	private StandService standService;

	@Override
	/* 根据商品ID查找商品 */
	public Goods getGoodsByGoodsId(Long id) {
		Goods goods = new Goods();
		goods.setId(id);
		return goodsService.getAGoods(goods);
	}

	@Override
	/* 根据商品编号查找商品 */
	public Goods getGoodsByGoodsCode(String serial_code) {
		Goods goods = new Goods();
		goods.setSerial_code(serial_code);
		return goodsService.getGoodsBySerialCode(goods);
	}

	@Override
	/* 根据商品名称查找商品,模糊查询 */
	public List<Goods> getGoodsByGoodsName(String goods_name) {
		List<Goods> goodList = new ArrayList<Goods>();
		Goods goods = new Goods();
		goods.setName(goods_name);
		goodList = goodsService.getGoodsByName(goods);
		return goodList;
	}

	@Override
	/*
	 * 根据传进来的参数先判断参数是哪些，最多5个 （第几页（no）、页尺寸（size）、品牌id(brand_id)、
	 * 品类id(category_id)、 和一个排序方法（按销量(pre_sale_number)或真实价格(real_price)排序）
	 * 0表示降序排序，1表示升序排序； 至少为2个（一个为第几页，一个为页尺寸）； 如果参数为品牌表示要返回该品牌下的所有商品，
	 * 如果为品类表示返回该品类下的所有商品， 如果参数为一个以上，自行选择链接查询！！ 注意返回的商品都是已上架商品
	 */
	public List<Goods> getGoodsBy(SelectParameters selects) {
		return goodsService.getGoodsBy(selects);// goodsService.getGoodsBy(array);
	}

	@Override
	/* 返回所有可以显示到前台的商品品类，注意按前台显示顺序从小到大排序 */
	public List<Category> getCategoryList() {
		return categoryService.getShowCategory();
	}

	@Override
	/* 返回所有可以显示到前台的商品品牌 */
	public List<Brand> getBrandList() {
		return brandService.getShowBrand();
	}

	@Override
	/* 返回一个符合条件且已上架的上架信息（主要是为了查询商品价格） */
	public Stand getGoodsPrice(Long goods_id) {
		Stand stand = new Stand();
		stand.setGoods_id(goods_id);
		stand = standService.getAStand(stand);
		return stand;
	}

	@Override
	public boolean deleteGoodsNumById(Long goodsId, int num) {
		Goods goods = new Goods();
		goods.setId(goodsId);
		goods = goodsService.getAGoods(goods);
		int stockCount = goods.getStock_count();
		int preSaleNumber = goods.getPre_sale_number() + num;
		stockCount -= num;
		if (stockCount < 0) {
			return false;
		}
		synchronized (this) {
			/* 防止不必要的麻烦发生 */
			goods.setStock_count(goods.getStock_count() - num);
			goods.setPre_sale_number(preSaleNumber);
			goodsService.modifyGoods(goods);
			Stand stand = new Stand();
			stand.setGoods_id(goodsId);
			stand = standService.getStandByGoodsId(goods);
			stand.setPre_sale_count(stand.getPre_sale_count() + num);
			standService.modifyStand(stand);
		}
		return true;
	}

}

package xmu.mystore.goodsmgt.cwh.service;

import java.util.List;
import java.util.Map;

import xmu.mystore.goodsmgt.cwh.model.Goods;
import xmu.mystore.goodsmgt.cwh.model.Goods_Brand;
import xmu.mystore.goodsmgt.cwh.model.Goods_Category;
import xmu.mystore.goodsmgt.cwh.model.Goods_Stand;

public interface IGoodsMapper {
	Goods getGoodsByGoodsCode(String serial_code);//根据商品编号查找商品
	List<Goods> getGoodsByName(String goods_name);//根据商品名称查找商品（模糊查找）
	List<Goods> getGoodsBy(Map<String, String> map);//根据参数查询（最多5个：页数、页尺寸、品牌id、品类id、排序方法）
	List<Goods_Category> getCategoryList();//返回所有可以显示到前台的商品品类，从小到大排序（前台显示顺序）
	List<Goods_Brand> getBrandList();//返回所有可以显示到前台的商品品牌
	Goods_Stand getGoodsPrice(Long goods_id);//返回一个符合条件且已上架的上架信息
}

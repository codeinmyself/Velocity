package xmu.mystore.goodsmgt.wyh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import xmu.mystore.goodsmgt.wyh.model.Goods;

@Component("wyh_GoodsMapper")
public interface GoodsMapper {
	Goods getGoodsById(String goodsId);
	
	List<Goods> getGoodsByName(@Param("name")String name);
	
	List<Goods> getAllGoods();
	
	int insertGoods(@Param("goods")Goods goods);
	
	void updateGoodsNameById(int id);
	
	Goods getGoodsByGoodsCode(@Param("serialCode")String serialCode);
	
	void updateGoodsById(@Param("goods")Goods goods);
	
	List<Goods> getGoodsByStandAndBrand(@Param("begin")int begin ,@Param("step")int step,@Param("standId")int standId,@Param("brandId")int brandId);
	
	List<Goods> getGoodsByStand(@Param("begin")int begin ,@Param("step")int step,@Param("standId")int standId);
	
	List<Goods> getGoodsByBrand(@Param("begin")int begin ,@Param("step")int step,@Param("brandId")int brandId);
	
	List<Goods> getGoodsByNumber(@Param("begin")int begin ,@Param("step")int step);
	
	void deleteGoodsById(@Param("goodsId")String id);
}

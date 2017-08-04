package xmu.mystore.goodsmgt.wyh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import xmu.mystore.goodsmgt.wyh.model.Stand;

@Component("wyh_StandMapper")
public interface StandMapper {
	Stand getStandById(String standId);
	
	List<Stand> getAllStand();
	
	int insertStand(@Param("stand")Stand stand);
	
	void updateStand(@Param("standId")String id,@Param("onMarketTime") String onMarketTime,
			@Param("offMarketTime")String offMarketTime,@Param("preSaleCount") String preSaleCount);
	
	Stand getStandByGoodsId(@Param("goodsId")String goodsId);
}

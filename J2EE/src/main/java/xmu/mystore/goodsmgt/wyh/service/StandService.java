package xmu.mystore.goodsmgt.wyh.service;

import java.util.List;

import xmu.mystore.goodsmgt.wyh.model.Stand;

public interface StandService {

	Stand getStandById(String standId);
	
	List<Stand> getAllStand();
	
	Stand insertStand(Stand stand);
	
	void updateStand(String standId,String onMarketTime,String offMarketTime,String preSaleCount);
	
	Stand getStandByGoodsId(String goodsId);
	
}

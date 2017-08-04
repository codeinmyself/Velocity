package xmu.mystore.goodsmgt.wyh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mystore.goodsmgt.wyh.mapper.StandMapper;
import xmu.mystore.goodsmgt.wyh.model.Stand;
import xmu.mystore.goodsmgt.wyh.service.StandService;


@Service("wyh_StandService")
@Transactional
public class StandServiceImpl implements StandService {
	@Autowired
	@Qualifier("wyh_StandMapper")
	private StandMapper standMapper;

	public StandMapper getStandMapper() {
		return standMapper;
	}

	
	public void setStandMapper(StandMapper standMapper) {
		this.standMapper = standMapper;
	}

	
	public Stand getStandById(String standId) {
		return this.standMapper.getStandById(standId);
	}
	

	public Stand getStandByGoodsId(String goodsId) {
		return this.standMapper.getStandByGoodsId(goodsId);
	}

	public List<Stand> getAllStand() {
		return this.standMapper.getAllStand();
	}

	public Stand insertStand(Stand stand) {
		this.standMapper.insertStand(stand);

		return getStandById(String.valueOf(stand.getId()));
	}


	public void updateStand(String standId, String onMarketTime, String offMarketTime, String preSaleCount) {
		// TODO Auto-generated method stub
		this.standMapper.updateStand(standId, onMarketTime, offMarketTime, preSaleCount);
	}

}
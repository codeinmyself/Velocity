package xmu.mystore.goodsmgt.cwh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mystore.goodsmgt.cwh.dao.Goods_StandDao;
import xmu.mystore.goodsmgt.cwh.model.Goods_Stand;

@Service("Goods_StandService")
@Transactional
public class Goods_StandService {
	
	@Autowired
	private Goods_StandDao gsdao;
	
	public boolean eidtGoods_Stand(Goods_Stand stand){//修改商品上下架信息
		if (gsdao.compare(stand.getOn_market_time(), stand.getOff_market_time())){
			gsdao.update(stand);
			return true;
		}
		return false;
	}
		
}

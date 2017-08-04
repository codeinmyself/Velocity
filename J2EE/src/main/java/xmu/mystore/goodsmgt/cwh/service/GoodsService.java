package xmu.mystore.goodsmgt.cwh.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mystore.goodsmgt.cwh.dao.GoodsDao;
import xmu.mystore.goodsmgt.cwh.dao.Goods_StandDao;
import xmu.mystore.goodsmgt.cwh.dao.TimeConvertor;
import xmu.mystore.goodsmgt.cwh.model.Goods;
import xmu.mystore.goodsmgt.cwh.model.Goods_Stand;
import xmu.mystore.goodsmgt.cwh.model.UserType;

@Service("GoodsService")  
@Transactional
public class GoodsService {
	
	@Autowired
	private GoodsDao gdao;
	
	@Autowired
	private Goods_StandDao gsdao;
	
	
	public void addGoods(Goods goods){ //添加商品（同时创建了上下架信息）
		String serial_code = goods.getSerial_code();
		if (serial_code == null || serial_code.trim().length() == 0){
			goods.setSerial_code(gdao.autoSerial_code(goods.getStore_id()));
		}
		goods.setAdd_time(TimeConvertor.DateToString(new Date()));
		Goods_Stand stand = new Goods_Stand();
		stand.setMarket_price(goods.getMarket_price());
		stand.setMid_user_price(goods.getMid_user_price());
		stand.setPre_sale_count(goods.getPre_sale_number());
		stand.setReal_price(goods.getReal_price());
		stand.setOn_market_time("0000-00-00 00:00:00");
		stand.setOff_market_time("0000-00-00 00:00:00");
		goods.setStand(stand);
		stand.setGoods(goods);
		gdao.save(goods);
		gsdao.save(stand);
	}
	
	public void editGoods(Goods goods){//编辑商品
		gdao.update(goods);
	}
	
	public List<Goods> getGoodsByUserType(UserType type){//根据用户类型获得商品列表
		return null;
	}
	
	public boolean existGoodsByGoodsCode(String serial_code){
		return gdao.getGoodsByGoodsCode(serial_code) != null?true:false;
	}
}

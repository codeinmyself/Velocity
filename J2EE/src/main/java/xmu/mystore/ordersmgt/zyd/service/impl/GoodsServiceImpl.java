package xmu.mystore.ordersmgt.zyd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mystore.ordersmgt.zyd.entities.Goods;
import xmu.mystore.ordersmgt.zyd.mapper.OrderGoodsMapper;
import xmu.mystore.ordersmgt.zyd.service.GoodsService;

@Service
@Transactional(rollbackFor = Exception.class)
public class GoodsServiceImpl implements GoodsService{
	@Autowired (required=false) 
	private OrderGoodsMapper goodsDao;
	
	public List<Goods> getGoodsByOrderid(long oid){
		return goodsDao.getGoodsByOrderid(oid);
	}
}

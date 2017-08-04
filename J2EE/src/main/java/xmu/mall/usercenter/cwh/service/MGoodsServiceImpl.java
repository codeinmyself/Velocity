package xmu.mall.usercenter.cwh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mall.usercenter.cwh.mapper.IEGoodsMapper;
import xmu.mystore.goodsmgt.zlt.model.Goods;

@Service
@Transactional(rollbackFor = Exception.class)
public class MGoodsServiceImpl implements IMGoodsService{

	
	@Autowired (required=false) 
	private IEGoodsMapper goodsMapper;

	@Override
	public List<Goods> getAllGoodsByOrderId(Long order_id) {
		return goodsMapper.getAllGoodsByOrderId(order_id);
	}

	@Override
	public List<Goods> getCollectedGoodsByUserId(Long user_id) {
		return goodsMapper.getCollectedGoodsByUserId(user_id);
	}

	@Override
	public void delectCollectedGoodsByUserIdAndGoodsId(Long user_id, Long goods_id) {
		goodsMapper.delectCollectedGoodsByUserIdAndGoodsId(user_id, goods_id);
	}
}
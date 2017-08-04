package xmu.mall.usercenter.pjx.service.impls;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mall.usercenter.pjx.mapper.UserCollectGoodsMapper;
import xmu.mall.usercenter.pjx.model.Goods;
import xmu.mall.usercenter.pjx.model.User_collect_goods;
import xmu.mall.usercenter.pjx.service.UserCollectGoodsService;

@Service("UserCollectGoodsService")
@Transactional
public class UserCollectGoodsServiceImpl implements UserCollectGoodsService {

	@Autowired
	private UserCollectGoodsMapper usercollectgoodsmapper;
	
	@Override
	public boolean delete(User_collect_goods user_collect_goods){
		usercollectgoodsmapper.delete(user_collect_goods);
		return true;
	}

	@Override
	public List<User_collect_goods> getAllCollectionsByUserID(long user_id) {
		return usercollectgoodsmapper.getAllCollectionsByUserID(user_id);
	}
	
}

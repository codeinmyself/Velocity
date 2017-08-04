package xmu.mystore.goodsmgt.cwh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mystore.goodsmgt.cwh.dao.Goods_CategoryDao;
import xmu.mystore.goodsmgt.cwh.model.Goods_Category;

@Service("Goods_CategoryService")
@Transactional
public class Goods_CategoryService {
	@Autowired
	private Goods_CategoryDao gcdao;
	
	public void addGoods_Category(Goods_Category category){//添加商品品类
		gcdao.save(category);
	}

	public void eidtGoods_Category(Goods_Category category){//修改商品品类
		gcdao.update(category);
	}
}

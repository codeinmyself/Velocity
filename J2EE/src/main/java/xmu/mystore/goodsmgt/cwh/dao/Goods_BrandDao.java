package xmu.mystore.goodsmgt.cwh.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import xmu.mystore.goodsmgt.cwh.model.Goods_Brand;
import xmu.mystore.goodsmgt.cwh.model.Goods_Category;

@Repository("goods_brandDao")  
public class Goods_BrandDao {

	@Autowired  
    private SessionFactory sessionFactory;
	
	public void save(Goods_Brand gb){   //保存商品品牌
		sessionFactory.getCurrentSession().save(gb);
	}
	
	public Goods_Brand getById(Long id){   //根据品牌ID查找品牌
		return (Goods_Brand) sessionFactory.getCurrentSession().get(Goods_Brand.class, id);
	}
	
	public void update(Goods_Brand gb){   //修改品牌
		sessionFactory.getCurrentSession().update(gb);
	}
	
	@SuppressWarnings("unchecked")
	public List<Goods_Brand> getAll() {  //得到所有品牌列表
		return sessionFactory.getCurrentSession()//
				.createQuery("From Goods_Brand")//
				.list();
	}
}

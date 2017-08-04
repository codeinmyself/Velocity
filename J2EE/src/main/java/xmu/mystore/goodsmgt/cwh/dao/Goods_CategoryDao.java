package xmu.mystore.goodsmgt.cwh.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import xmu.mystore.goodsmgt.cwh.model.Goods_Category;

@Repository("goods_categoryDao")  
public class Goods_CategoryDao {

	@Autowired  
    private SessionFactory sessionFactory;
	
	public void save(Goods_Category gc){
		sessionFactory.getCurrentSession().save(gc);
	}
	
	public Goods_Category getById(Long id){
		return (Goods_Category) sessionFactory.getCurrentSession().get(Goods_Category.class, id);
	}
	
	public void update(Goods_Category gc){
		sessionFactory.getCurrentSession().update(gc);
	}
	
	@SuppressWarnings("unchecked")
	public List<Goods_Category> getAll(){
		return sessionFactory.getCurrentSession()//
				.createQuery("From Goods_Category")//
				.list();
	}
}

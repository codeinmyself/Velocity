package xmu.mystore.goodsmgt.cwh.dao;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import xmu.mystore.goodsmgt.cwh.model.Goods_Brand;
import xmu.mystore.goodsmgt.cwh.model.Goods_Stand;

@Repository("goods_standDao")
public class Goods_StandDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(Goods_Stand gs) { // 保存商品上下架信息
		sessionFactory.getCurrentSession().save(gs);
	}

	public Goods_Stand getById(Long id) { // 根据上下架id查询商品
		return (Goods_Stand) sessionFactory.getCurrentSession().get(Goods_Stand.class, id);
	}

	public void update(Goods_Stand gs) { // 修改上下架信息
		sessionFactory.getCurrentSession().update(gs);
	}

	@SuppressWarnings("unchecked")
	public Goods_Stand getStandByGoodsId(Long goods_id) {// 根据商品ID返回一个符合条件且已上架的上架信息
		Goods_Stand stand = (Goods_Stand) sessionFactory.getCurrentSession()//
				.createQuery("From Goods_Stand where goods_stand_goods_id = ?")//
				.setLong(0, goods_id)//
				.uniqueResult();
		if (stand != null) {
			Calendar on_market_time = TimeConvertor.StringToCalendar(stand.getOn_market_time());
			Calendar off_market_time = TimeConvertor.StringToCalendar(stand.getOff_market_time());
			Calendar now_time = Calendar.getInstance();
			if (now_time.compareTo(on_market_time) > 0 && now_time.compareTo(off_market_time) < 0) {
				return stand;
			}
		}
		return null;
	}

	public boolean compare(String on_market_time,String off_market_time){//比较上下架时间
		Calendar on = TimeConvertor.StringToCalendar(on_market_time);
		Calendar off = TimeConvertor.StringToCalendar(off_market_time);
		Calendar now = Calendar.getInstance();
		if (now.compareTo(on)<0 && on.compareTo(off)<0){
			return true;
		}
		return false;
	}
	
}

package xmu.mystore.goodsmgt.cwh.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import xmu.mystore.goodsmgt.cwh.model.Goods;

@Repository("goodsDao")
public class GoodsDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(Goods g) { // 添加商品
		sessionFactory.getCurrentSession().save(g);
	}

	public void update(Goods g) { // 修改商品信息
		sessionFactory.getCurrentSession().update(g);
	}

	public Goods getGoodsByGoodsCode(String serial_code) {// 根据商品编码查找商品
		return (Goods) sessionFactory.getCurrentSession()//
				.createQuery("From Goods where goods_serial_code = ?")//
				.setString(0, serial_code)//
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Goods> getGoodsByName(String goods_name) {// 根据商品名称查找商品（模糊查找）
		return sessionFactory.getCurrentSession()//
				.createQuery("From Goods where goods_name like ?")//
				.setString(0, "%" + goods_name + "%")//
				.list();//
	}

	@SuppressWarnings("unchecked")
	public String autoSerial_code(String store_name) {// 自动生成商品编号
		String prefix = store_name.substring(0, 2).toUpperCase();
		List<Goods> store_list = sessionFactory.getCurrentSession()//
				.createQuery("From Goods where goods_store_id like ? and goods_store_id != ? group by goods_store_id")//
				.setString(0, prefix + "%")//
				.setString(1,store_name)//
				.list();// 前两个字母重复的店铺名称
		int sum = store_list == null ? 0 : store_list.size();
		int goodsNum = getGoodsByStore(store_name).size();// 该商店的商品个数
		String temp = "000000" + (goodsNum + 1);
		String suffix = temp.substring(temp.length() - 6, temp.length());
		return prefix + (char) (sum + 'A') + suffix;
	}

	@SuppressWarnings("unchecked")
	public List<Goods> getGoodsByStore(String store_name) {// 根据商店名查找商品
		return sessionFactory.getCurrentSession()//
				.createQuery("From Goods where goods_store_id = ?")//
				.setString(0, store_name)//
				.list();
	}

	public List<Goods> getGoodsBy(Map<String, String> map) {// 根据参数查找商品列表
		String goods_name = map.get("goods_name");//商品名称
		Integer no = Integer.parseInt(map.get("no"));// 第no页
		Integer size = Integer.parseInt(map.get("size"));// 页尺寸
		String sortColumn = map.containsKey("pre_sale_number") ? "pre_sale_number" : "real_price";
		String sortMethod = Integer.parseInt(map.get(sortColumn)) == 1 ? "asc" : "desc";
		Long brand_id = null,category_id = null;
		boolean flag = false;
		boolean mark = false;
		String hql = "From Goods where Goods_name like ? and ";
		if (map.containsKey("brand_id")){
			brand_id = Long.parseLong(map.get("brand_id"));
			flag = true;
			hql +="Goods_brand_id = ? ";
		}
		if (map.containsKey("category_id")){
			if (flag) hql += "and ";
			category_id = Long.parseLong(map.get("category_id"));
			mark = true;
			hql +="Goods_category_id = ?";
		}
		hql+="order by "+sortColumn+" "+sortMethod;
		Query query= sessionFactory.getCurrentSession().createQuery(hql);
		int index = 0;
		query.setString(index++, "%"+goods_name+"%");
		if (flag){
			query.setLong(index++,brand_id);
		}
		if (mark){
			query.setLong(index++,category_id);
		}
		query.setFirstResult((no-1)*size);
		query.setMaxResults(size);
		return query.list();
	}
}

package xmu.mall.usercenter.zf.model;

import java.io.Serializable;

import xmu.mystore.ordersmgt.zf.model.Goods;

/**
 * Created by 63520 on 2017/5/26.
 * 
 * 用户收藏
 */
public class User_collect_goods implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3640883974153294276L;
	
	private long rec_id;       //主键
	private long user_id;      //用户ID
	private long goods_id;     //商品ID
	private String  add_time;  //添加时间
	private Goods goods;		
	
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public long getRec_id() {
		return rec_id;
	}
	public void setRec_id(long rec_id) {
		this.rec_id = rec_id;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public long getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(long goods_id) {
		this.goods_id = goods_id;
	}
	public String getAdd_time() {
		return add_time;
	}
	public void setAdd_time(String add_time) {
		this.add_time = add_time;
	}
	
}

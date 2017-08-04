package xmu.mall.usercenter.ghz.entity;

public class User_collect_goods {
	long rec_id;       //主键
	long user_id;      //用户ID
	long goods_id;     //商品ID
	String  add_time;  //添加时间
	
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

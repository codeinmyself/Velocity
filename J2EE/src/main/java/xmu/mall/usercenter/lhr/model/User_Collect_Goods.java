package xmu.mall.usercenter.lhr.model;

//用户收藏表
public class User_Collect_Goods {
	private Long rec_id;       //主键
	private Long user_id;      //用户ID
	private Long goods_id;     //商品ID
	private String  add_time;  //添加时间
	public Long getRec_id() {
		return rec_id;
	}
	public void setRec_id(Long rec_id) {
		this.rec_id = rec_id;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public Long getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(Long goods_id) {
		this.goods_id = goods_id;
	}
	public String getAdd_time() {
		return add_time;
	}
	public void setAdd_time(String add_time) {
		this.add_time = add_time;
	}
	
}

package xmu.mall.usercenter.ghz.entity;

public class Goods {
	long id;                 //商品id
	String name;		 //商品名
	String serial_code;      //商品编码
	Double weight;		 //商品重量
	int stock_count;	 //商品库存
	int pre_sale_number;	 //预售数量
	String store_id;	 //商店id
	Double mid_user_price;	 //中介价格
	Double market_price;	 //市场价格
	Double real_price;	 //真实价格
	int redeem_point; 	 //商品积分
	int category_id;	 //品类id
	int brand_id;		 //品牌id
	int Stand_id;            //上下架id
	String add_time; 	 //增加商品时间
	String last_modified_time;//最后修改商品信息时间
	String description;	 //商品描述
	String image_path;	 //商品图片
	Boolean is_dividable;	 //是否允许分单
	String default_express;   //默认快递
	
	
}

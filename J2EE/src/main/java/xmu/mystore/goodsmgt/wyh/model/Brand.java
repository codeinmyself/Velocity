package xmu.mystore.goodsmgt.wyh.model;

public class Brand {
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	private int brandId;		 //品牌id
	private String name;		 //品牌名称
	private String website;		 //品牌网址
	private String description;	 //品牌描述
	private int type;		 //品牌状态（目前表示是否在前台显示）
}

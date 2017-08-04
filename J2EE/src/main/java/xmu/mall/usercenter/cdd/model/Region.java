package xmu.mall.usercenter.cdd.model;

public class Region {
	private Long region_id;//地区id
	private Long parent_id;//父地区id
	private String region_name;//地区名
	private Integer region_type;//等级
	public Long getRegion_id() {
		return region_id;
	}
	public void setRegion_id(Long region_id) {
		this.region_id = region_id;
	}
	public Long getParent_id() {
		return parent_id;
	}
	public void setParent_id(Long parent_id) {
		this.parent_id = parent_id;
	}
	public String getRegion_name() {
		return region_name;
	}
	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}
	public Integer getRegion_type() {
		return region_type;
	}
	public void setRegion_type(Integer region_type) {
		this.region_type = region_type;
	}
	
}

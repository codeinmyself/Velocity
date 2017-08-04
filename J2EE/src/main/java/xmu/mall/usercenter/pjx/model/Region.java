package xmu.mall.usercenter.pjx.model;

public class Region
{
	private int region_id;
	private int parent_id;
	private String region_name;
	private int region_type;
	private int agency_id;
	
	public int getRegion_id() {
		return region_id;
	}
	public void setRegion_id(int region_id) {
		this.region_id = region_id;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public String getRegion_name() {
		return region_name;
	}
	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}
	public int getRegion_type() {
		return region_type;
	}
	public void setRegion_type(int region_type) {
		this.region_type = region_type;
	}
	public int getAgency_id() {
		return agency_id;
	}
	public void setAgency_id(int agency_id) {
		this.agency_id = agency_id;
	}
	
}

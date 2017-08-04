package xmu.mystore.goodsmgt.wyh.model;

public class Category {

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUpperCategoryId() {
		return upperCategoryId;
	}
	public void setUpperCategoryId(int upperCategoryId) {
		this.upperCategoryId = upperCategoryId;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	private int id;	    	 //品类id
	private String name;		 //品类名称
	private int upperCategoryId;	 //上级品类id
	private int rank;		 //品类等级
	private int type;		 //品类状态（目前表示是否在前台显示）
	private int priority;	         //品类前台显示顺序
}

package xmu.mystore.goodsmgt.cwh.model;

public enum Express {
	SHUNFENG("顺风"),JINGDONG("京东"),TIANTIAN("天天");
	private String name;
	Express(String name){
		this.name=name;
	}
	public String toString() {
		return name;
	}
}

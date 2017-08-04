package xmu.mystore.goodsmgt.cwh.model;

public enum Tnt {
	DISPLAY("显示"),HIDDEN("隐藏");
	String name;
	Tnt(String name){
		this.name = name;
	}
	public String toString(){
		return name;
	}
}

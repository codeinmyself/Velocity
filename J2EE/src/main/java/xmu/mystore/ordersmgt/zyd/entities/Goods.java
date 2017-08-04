package xmu.mystore.ordersmgt.zyd.entities;

public class Goods {
	long id;
	String name;
	int num;
	Double price;
	public Goods(){
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Double  getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}	
}

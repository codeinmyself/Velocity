package xmu.mall.usercenter.pjx.model;

/**
 * @author tangkai
 * @data 2017年6月2日--下午1:19:04
 */
public class Order_Goods {
	private long  id;
	private String name;
	private double price;
	private int num;
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

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
}

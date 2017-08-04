package xmu.mystore.goodsmgt.lcf.model;

public class SelectParameters extends Goods {
	/**
	 * 根据传进来的参数先判断参数是哪些，最多5个 （第几页（no）、页尺寸（size）、品牌id(brand_id)、
	 * 品类id(category_id)、 和一个排序方法（按销量(pre_sale_number)或真实价格(real_price)排序）
	 * 0表示降序排序，1表示升序排序； 至少为2个（一个为第几页，一个为页尺寸）； 如果参数为品牌表示要返回该品牌下的所有商品，
	 * 如果为品类表示返回该品类下的所有商品， 如果参数为一个以上，自行选择链接查询！！ 注意返回的商品都是已上架商品
	 */

	private static final long serialVersionUID = 2680052380956279242L;
	private int no;
	private int size;

	public void initialPage(int no, int size) {
		setNo(no);
		setSize(size);
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}

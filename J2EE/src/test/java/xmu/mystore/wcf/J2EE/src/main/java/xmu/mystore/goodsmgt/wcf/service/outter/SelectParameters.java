package xmu.mystore.goodsmgt.wcf.service.outter;

import xmu.mystore.goodsmgt.wcf.model.Goods;


/**
*@author created by �����
*@date 2017��5��31��--����1:45:41
*/
public class SelectParameters extends Goods{

	private String no;
	private String size;
	private String brandId;
	private String categoryId;
	private String preSaleNumber;//����
	private String realPrice;//���򷽷�
	private String goodsName;

	public SelectParameters()
	{
		
	}
	


	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getBrandId() {
		return brandId;
	}
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getPreSaleNumber() {
		return preSaleNumber;
	}
	public void setPreSaleNumber(String preSaleNumber) {
		this.preSaleNumber = preSaleNumber;
	}
	public String getRealPrice() {
		return realPrice;
	}
	public void setRealPrice(String realPrice) {
		this.realPrice = realPrice;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}


}

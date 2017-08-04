package xmu.mystore.goodsmgt.wyh.model;

public class Stand {
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public Double getMidUserPrice() {
		return midUserPrice;
	}
	public void setMidUserPrice(Double midUserPrice) {
		this.midUserPrice = midUserPrice;
	}
	public Double getMarketPrice() {
		return marketPrice;
	}
	public void setMarketPrice(Double marketPrice) {
		this.marketPrice = marketPrice;
	}
	public Double getRealPrice() {
		return realPrice;
	}
	public void setRealPrice(Double realPrice) {
		this.realPrice = realPrice;
	}
	public String getOnMarketTime() {
		return onMarketTime;
	}
	public void setOnMarketTime(String onMarketTime) {
		this.onMarketTime = onMarketTime;
	}
	public String getOffMarketTime() {
		return offMarketTime;
	}
	public void setOffMarketTime(String offMarketTime) {
		this.offMarketTime = offMarketTime;
	}
	public int getPreSaleCount() {
		return preSaleCount;
	}
	public void setPreSaleCount(int preSaleCount) {
		this.preSaleCount = preSaleCount;
	}
	private int id;		 //上下架id
	private int goodsId;		 //商品id
	private Double midUserPrice;	 //中介价格
	private Double marketPrice;	 //市场价格
	private Double realPrice;	 //真实价格
	private String onMarketTime;	 //上架时间
	private String offMarketTime;	 //下架时间
	private int preSaleCount;	 //预售数量
}

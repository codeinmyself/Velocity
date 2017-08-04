package xmu.mystore.goodsmgt.wyh.tool;

import java.util.Comparator;

import xmu.mystore.goodsmgt.wyh.model.Goods;

public class RealPriceComparator implements Comparator<Goods> {
	private int number;
	public RealPriceComparator(int number) {
		// TODO Auto-generated constructor stub
		this.number=number;
	}
	public int compare(Goods o1, Goods o2) {
		// TODO Auto-generated method stub
		if(number==1)//升序
			return (int)(o1.getMarket_price()-o2.getMarket_price());
		else 
			return (int)(o2.getMarket_price()-o1.getMarket_price());
	}

}

package xmu.mystore.goodsmgt.wyh.tool;

import java.util.Comparator;

import xmu.mystore.goodsmgt.wyh.model.Goods;

public class PreSaleNumberComparator implements Comparator<Goods> {
	private int number;
	public PreSaleNumberComparator(int number) {
		// TODO Auto-generated constructor stub
		this.number=number;
	}
	public int compare(Goods o1, Goods o2) {
		// TODO Auto-generated method stub
		if(number==1)//升序
			return o1.getPre_sale_number()-o2.getPre_sale_number();
		else 
			return o2.getPre_sale_number()-o1.getPre_sale_number();
	}

}

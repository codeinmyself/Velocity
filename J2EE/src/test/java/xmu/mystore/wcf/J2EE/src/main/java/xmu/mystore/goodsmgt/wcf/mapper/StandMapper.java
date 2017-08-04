package xmu.mystore.goodsmgt.wcf.mapper;

import java.util.List;

import xmu.mystore.goodsmgt.wcf.model.Stand;


/**
*@author created by �����
*@date 2017��5��31��--����1:44:07
*/
public interface StandMapper {
	public List<Stand> getStandList();
	public boolean addStand(Stand stand);
	public boolean deleteStandById(long id);
	public Stand getStandById(long id);
	public boolean updateStand(Stand stand);
	public Stand getGoodsPrice(Long goods_id);
}

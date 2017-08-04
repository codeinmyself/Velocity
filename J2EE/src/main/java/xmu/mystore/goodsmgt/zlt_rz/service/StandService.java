package xmu.mystore.goodsmgt.zlt_rz.service;

import java.util.List;

import xmu.mystore.goodsmgt.zlt_rz.model.Stand;

public interface StandService {

	public boolean modifyStand(Stand stand);

	public Stand getAStand(Stand stand);

	public List<Stand> getAllStand();

}

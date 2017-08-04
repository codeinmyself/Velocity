package xmu.mystore.goodsmgt.lcf.service;

import java.util.List;

import xmu.mystore.goodsmgt.lcf.model.Stand;

public interface StandService {

	public boolean modifyStand(Stand stand);

	public Stand getAStand(Stand stand);

	public List<Stand> getAllStand();

}

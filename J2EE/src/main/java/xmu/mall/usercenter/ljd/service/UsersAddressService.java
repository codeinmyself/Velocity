package xmu.mall.usercenter.ljd.service;

import java.util.List;

import xmu.mall.usercenter.ljd.model.Region;
import xmu.mall.usercenter.ljd.model.User_address;

public interface UsersAddressService {
	
	public User_address selectByAddressID(long address_id);
	
	public List<User_address> selectAllByUserID(long user_id);
	
	public List<Region> selectAllRegion();
	
	public List<Region> selectAllRegionByParentID(int parent_id);
	
	public boolean updateUserAddress(User_address user_address);
	
	public boolean setDefaultAddress(User_address user_address);
	
	public boolean deleteUserAddressByAddressID(long address_id);
	
	public boolean add(User_address user_address);
	
}

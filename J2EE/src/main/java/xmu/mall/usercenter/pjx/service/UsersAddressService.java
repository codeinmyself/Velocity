package xmu.mall.usercenter.pjx.service;

import java.util.List;

import xmu.mall.usercenter.pjx.model.User_address;
import xmu.mall.usercenter.pjx.model.Region;

public interface UsersAddressService {
	
	public User_address selectByUserIDAndAddressID(User_address user_address);
	
	public List<User_address> selectAllByUserID(long user_id);
	
	public List<Region> selectAllRegion();
	
	public List<Region> selectAllRegionByParentID(int parent_id);
	
	public boolean updateUserAddress(User_address user_address);
	
	public boolean setDefaultAddress(User_address user_address);
	
	public boolean deleteUserAddressBuAddressID(long address_id);
	
	public boolean add(User_address user_address);
	
}

package xmu.mall.usercenter.ljd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import xmu.mall.usercenter.ljd.model.User_address;

@Component
public interface UsersAddressMapper
{
	public User_address selectByAddressID(long address_id);
	
	public List<User_address> selectAllByUserID(long user_id);
	
	public boolean cancelDefaultAddressByUserID(User_address user_address);
	
	public boolean setDefaultAddressByUserIDAndAddressID(User_address user_address);
	
	public boolean updateUserAddress(User_address user_address);
	
	public boolean deleteUserAddressByAddressID(long address_id);
	
	public boolean add(User_address user_address);
}


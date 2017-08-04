package xmu.mall.usercenter.cmy.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import xmu.mall.usercenter.cmy.entity.Order_info;
import xmu.mall.usercenter.cmy.entity.SearchOrder;
import xmu.mall.usercenter.cmy.entity.User_address;

public interface UserAddressService {
	public List<User_address> getAllAddress(@Param("user_id")long user_id);
	public User_address getAddressByAddressID(@Param("address_id")long address_id);
	public void updateAddress(User_address userAddress);
	}

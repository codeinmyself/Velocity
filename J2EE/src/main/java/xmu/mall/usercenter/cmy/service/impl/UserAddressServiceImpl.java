package xmu.mall.usercenter.cmy.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mall.usercenter.cmy.entity.Order_info;
import xmu.mall.usercenter.cmy.entity.SearchOrder;
import xmu.mall.usercenter.cmy.entity.User_address;
import xmu.mall.usercenter.cmy.mapper.Order2Mapper;
import xmu.mall.usercenter.cmy.mapper.UserAddressMapper;
import xmu.mall.usercenter.cmy.service.Order2Service;
import xmu.mall.usercenter.cmy.service.UserAddressService;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserAddressServiceImpl implements UserAddressService{
	
	@Autowired (required=false) 
	private UserAddressMapper userAddressMapper;
		
	@Override
	public List<User_address> getAllAddress(@Param("user_id")long user_id) 
	{
		if(userAddressMapper == null)
			System.out.println("I am so sad");
		return userAddressMapper.getAllAddress(user_id);
	}

	public User_address getAddressByAddressID(@Param("address_id")long address_id){
		if(userAddressMapper == null)
			System.out.println("I am so sad");
		return userAddressMapper.getAddressByAddressID(address_id);
	}
	
	public void updateAddress(User_address userAddress){
		userAddressMapper.updateAddress(userAddress);
	}
}

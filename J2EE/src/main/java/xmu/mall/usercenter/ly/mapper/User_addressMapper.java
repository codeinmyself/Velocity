package xmu.mall.usercenter.ly.mapper;

import java.util.List;

import xmu.mall.usercenter.ly.model.User_address;

public interface User_addressMapper
{
	List<User_address> getAddressByUid(Long id);
}

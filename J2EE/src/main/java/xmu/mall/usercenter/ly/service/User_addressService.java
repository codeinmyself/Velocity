package xmu.mall.usercenter.ly.service;

import java.util.List;

import xmu.mall.usercenter.ly.model.User_address;

public interface User_addressService
{
	List<User_address> getAddressByUid(Long id);
}

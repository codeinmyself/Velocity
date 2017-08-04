package xmu.mall.usercenter.ly.service.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xmu.mall.usercenter.ly.mapper.User_addressMapper;
import xmu.mall.usercenter.ly.model.User_address;
import xmu.mall.usercenter.ly.service.User_addressService;

@Service("AddressService")
public class User_addressServiceImpl implements User_addressService
{
	@Autowired
	private User_addressMapper user_addressmapper;
	
	public List<User_address> getAddressByUid(Long id)
	{
		return user_addressmapper.getAddressByUid(id);
	}
}

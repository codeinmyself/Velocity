package xmu.mall.usercenter.cwh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mall.usercenter.cwh.mapper.IRegionMapper;
import xmu.mall.usercenter.cwh.mapper.IUser_AddressMapper;
import xmu.mall.usercenter.cwh.model.Region;
import xmu.mall.usercenter.cwh.model.User_Address;

@Service
@Transactional(rollbackFor = Exception.class)
public class User_AddressServiceImpl implements IUser_AddressService{

	@Autowired
	private IUser_AddressMapper user_addressMapper;
	@Autowired
	private IRegionMapper regionMapper;
	
	@Override
	public void addAddress(User_Address address) {
		user_addressMapper.addAddress(address);
	}

	@Override
	public List<User_Address> getAddressesByUserId(Long user_id) {
		return user_addressMapper.getAddressesByUserId(user_id);
	}

	@Override
	public void updateAddressByAddress(User_Address address) {
		user_addressMapper.updateAddressByAddress(address);
	}

	@Override
	public void deleteAddress(Long address_id) {
		user_addressMapper.deleteAddress(address_id);
	}

	@Override
	public User_Address getAddressByAddressId(Long address_id) {
		return user_addressMapper.getAddressByAddressId(address_id);
	}

	@Override
	public String getRegionNameByRegionId(Integer region_id) {
		return regionMapper.getRegionNameByRegionId(region_id);
	}

	@Override
	public List<Region> getChildsByParentId(Integer parent_id) {
		return regionMapper.getChildsByParentId(parent_id);
	}

	@Override
	public void changeDefaultToZero(Long user_id) {
		user_addressMapper.changeDefaultToZero(user_id);
	}

}

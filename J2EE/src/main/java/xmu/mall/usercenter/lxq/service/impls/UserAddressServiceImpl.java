package xmu.mall.usercenter.lxq.service.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mall.usercenter.lxq.mapper.RegionMapper;
import xmu.mall.usercenter.lxq.mapper.UserAddressMapper;
import xmu.mall.usercenter.lxq.model.Region;
import xmu.mall.usercenter.lxq.model.UserAddress;
import xmu.mall.usercenter.lxq.service.IUserAddressService;

@Service("userAddressService")
@Transactional
public class UserAddressServiceImpl implements IUserAddressService {

	@Autowired
	private UserAddressMapper user_addressMapper;
	@Autowired
	private RegionMapper regionMapper;

	@Override
	public void addAddress(UserAddress address) {
		user_addressMapper.addAddress(address);
	}

	@Override
	public List<UserAddress> getAddressesByUserId(Long user_id) {
		return user_addressMapper.getAddressesByUserId(user_id);
	}

	@Override
	public void updateAddressByAddress(UserAddress address) {
		user_addressMapper.updateAddressByAddress(address);
	}

	@Override
	public void deleteAddress(Long address_id) {
		user_addressMapper.deleteAddress(address_id);
	}

	@Override
	public UserAddress getAddressByAddressId(Long address_id) {
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

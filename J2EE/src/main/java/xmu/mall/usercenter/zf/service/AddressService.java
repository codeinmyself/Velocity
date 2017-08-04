package xmu.mall.usercenter.zf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mall.usercenter.zf.mappers.RegionMapper;
import xmu.mall.usercenter.zf.mappers.User_addressMapper;
import xmu.mall.usercenter.zf.model.Region;
import xmu.mall.usercenter.zf.model.User_address;

@Service("addressService")
@Transactional
public class AddressService {

	@Autowired
	private User_addressMapper addressMapper;

	@Autowired
	private RegionMapper regionMapper;
	
	public List<User_address> getUserAddress(long id){
		return this.addressMapper.getAddressByUid(id);
	}

	public User_address getAddressById(long aid) {
		return this.addressMapper.getAddressById(aid);
	}

    public boolean changeDefault(long uid) {
		this.addressMapper.changeToNotDefault();
		this.addressMapper.changeToDefault(uid);

		return true;
    }

	public void deleteAddress(long aid) {
		this.addressMapper.deleteAddress(aid);
	}

	public List<Region> getAllProvince(int country_id) {
		return this.regionMapper.getRegions(country_id);
	}

	public List<Region> getAllCity(int province) {
		return this.regionMapper.getRegions(province);
	}

	public List<Region> getAllDistrict(int city) {
		return this.regionMapper.getRegions(city);
	}

	public void saveAddress(User_address address) {
		if(address.getIs_default())
			this.addressMapper.changeToNotDefault();
		this.addressMapper.saveAddress(address);
	}

	public void updateAddress(User_address address) {
		if(address.getIs_default())
			this.addressMapper.changeToNotDefault();
		this.addressMapper.updateAddress(address);
	}
}

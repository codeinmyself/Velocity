package xmu.mall.usercenter.ghz.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mall.usercenter.ghz.entity.Address;
import xmu.mall.usercenter.ghz.mapper.IAddressMapper;

@Service
public class AddressService {

	@Autowired
	IAddressMapper addressMapper;

	public List<Address> getUserAddress(int user_id) {
		return addressMapper.getUserAddress(user_id);
	}

	public Address getAddress(int user_id, int address_id) {
		return addressMapper.getAddress(user_id, address_id);
	}
	
	public Address getDefaultAddress(int user_id) {
		return addressMapper.getDefaultAddress(user_id);
	}

	@Transactional
	public void setDefaultAddress(int user_id, int address_id) {
		addressMapper.removeDefaultAddress(user_id);
		addressMapper.setDefaultAddress(user_id, address_id);
	}

	@Transactional
	public void addNewAddress(Address address) {
		addressMapper.removeDefaultAddress(address.getUser_id());
		addressMapper.addNewAddress(address);
	}
	
	@Transactional
	public void updateAddress(Address address) {
		addressMapper.updateNewAddress(address);
		addressMapper.setDefaultAddress(address.getUser_id(), address.getId());
	}
	
	public void removeAddress(int address_id) {
		addressMapper.removeAddress(address_id);
	}
}

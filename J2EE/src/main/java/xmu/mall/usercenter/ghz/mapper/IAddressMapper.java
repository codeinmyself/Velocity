package xmu.mall.usercenter.ghz.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import xmu.mall.usercenter.ghz.entity.Address;

public interface IAddressMapper {
	List<Address> getUserAddress(int user_id);
	
	Address getAddress(@Param("user_id")int user_id, @Param("address_id")int address_id);
	
	Address getDefaultAddress(int user_id);
	
	void removeDefaultAddress(int user_id);
	
	void setDefaultAddress(@Param("user_id") int user_id, @Param("address_id") int address_id);
	
	void addNewAddress(Address address);
	
	void updateNewAddress(Address address);
	
	void removeAddress(int address_id);
}

package xmu.mall.usercenter.lxq.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import xmu.mall.usercenter.lxq.model.UserAddress;

@Repository
public interface UserAddressMapper {
	void addAddress(UserAddress address);// 添加地址

	List<UserAddress> getAddressesByUserId(Long user_id);// 根据用户id得到自身所有的地址

	void updateAddressByAddress(UserAddress address);// 修改地址

	void deleteAddress(Long address_id);// 根据地址id删除地址

	UserAddress getAddressByAddressId(Long address_id);// 根据id获得地址对象

	void changeDefaultToZero(Long user_id);// 将用户所有的地址都设为非默认。
}

package xmu.mall.usercenter.cmy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import xmu.mall.usercenter.cmy.entity.Order_info;
import xmu.mall.usercenter.cmy.entity.SearchOrder;
import xmu.mall.usercenter.cmy.entity.User_address;

@Repository
public interface UserAddressMapper {
	//具体实现在mapper层的OrderMapper.xml文件中
	public List<User_address> getAllAddress(@Param("user_id")long user_id);
	public User_address getAddressByAddressID(@Param("address_id")long address_id);
	public void updateAddress(User_address userAddress);
}

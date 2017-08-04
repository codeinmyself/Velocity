package xmu.mystore.pay.liulei.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import xmu.mystore.pay.liulei.model.UserAddress;

@Component
public interface UserAddressMapper {

	public void add(UserAddress userAddress);

	public void delete(UserAddress userAddress);

	public void update(UserAddress userAddress);

	public UserAddress select(UserAddress userAddress);

	public List<UserAddress> selectAll(@Param("user_id") long user_id);

}

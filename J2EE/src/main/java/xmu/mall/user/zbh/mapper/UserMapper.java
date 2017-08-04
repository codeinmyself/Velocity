package xmu.mall.user.zbh.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import xmu.mall.user.zbh.model.User;

@Repository
public interface UserMapper {
	public void insertUser(User user);
	public User getUserByMobilePhone(String mobilePhone);
	public User getUserByMobilePhoneAndPassword(@Param("mobilePhone")String mobilePhone,@Param("password")String password);
}

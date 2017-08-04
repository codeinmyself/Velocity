package xmu.mall.usercenter.cmy.mapper;

import org.springframework.stereotype.Repository;

import xmu.mall.usercenter.cmy.entity.User;

@Repository
public interface User2Mapper {
	
	public User getUserByUserId(long user_id);
	public void updateUser(User user);
}

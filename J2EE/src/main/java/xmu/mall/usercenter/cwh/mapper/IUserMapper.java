package xmu.mall.usercenter.cwh.mapper;


import org.springframework.stereotype.Repository;

import xmu.mall.usercenter.cwh.model.User;

@Repository
public interface IUserMapper {	
	User getUserByUserId(Long user_id);//根据用户id获得用户对象
	void updateUserByUser(User user);//根据用户对象更改用户
}

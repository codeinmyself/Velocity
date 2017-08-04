package xmu.mall.usercenter.ghz.mapper;

import org.apache.ibatis.annotations.Param;

import xmu.mall.usercenter.ghz.entity.User;

public interface IUserMapper {
	
	User getUserByName(int user_name);
	
	User getUserById(int user_id);

	boolean updateUserName(@Param("user_id") int user_id,
			@Param("nickname") String nickname);
}

package xmu.mall.usercenter.ly.mapper;

import java.util.List;

import xmu.mall.usercenter.ly.model.Users;

public interface IUsersMapper
{
	List<Users> getUserByUserId(Long id);
	void updateu(Long user_id,String user_name,String nickname,String mobile_phone,String imagepath);
}

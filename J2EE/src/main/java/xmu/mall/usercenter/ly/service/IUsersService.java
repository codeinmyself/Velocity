package xmu.mall.usercenter.ly.service;

import java.util.List;

import xmu.mall.usercenter.ly.model.Users;

public interface IUsersService
{
	List<Users> getUserByUserId(Long user_id);
	void updateu(Long user_id,String user_name,String nickname,String mobile_phone,String imagepath);
}

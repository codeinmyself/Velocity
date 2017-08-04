package xmu.mall.usercenter.pjx.service;

import java.util.List;

import xmu.mall.usercenter.pjx.model.Users;

public interface UsersService {
	
	public Users getUsersByID(Users user);
	
	public boolean updateUsername(Users user);
	
	public boolean updateNickname(Users user);
	
	public boolean updateMobilephone(Users user);
	
}

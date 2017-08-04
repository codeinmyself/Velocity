package xmu.mall.usercenter.cmy.service;

import xmu.mall.usercenter.cmy.entity.User;

public interface User2Service {
	public User getUserByUserId(long user_id);
	public void updateUser(User user);
}

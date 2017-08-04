package xmu.mall.user.zbh.service;

import xmu.mall.user.zbh.model.User;

public interface UserService {
	public void insertUser(User user);
	public User getUserByMobilePhone(String mobilePhone);
	public User getUserByMobilePhoneAndPassword(String mobilePhone,String password);

}

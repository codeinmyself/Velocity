package xmu.mall.usercenter.cdd.service;
import xmu.mall.usercenter.cdd.model.User;

public interface IMUserService {
	User getUserByUserId(Long user_id);//根据用户id获得用户对象
	void updateUserByUser(User user);//根据用户对象更改用户
}

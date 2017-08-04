package xmu.mystore.wx.zbh.service;

import java.util.List;

import xmu.mystore.wx.zbh.model.User;

public interface UserService {
	public User getUserByOpenid(String openid);
	public List<User> showAllUser();
	public void insertUser(User user);

}

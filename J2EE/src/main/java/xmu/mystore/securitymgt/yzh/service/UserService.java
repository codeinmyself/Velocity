package xmu.mystore.securitymgt.yzh.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mystore.securitymgt.yzh.mapper.UserMapper;
import xmu.mystore.securitymgt.yzh.model.User;


@Service("142528_userService")
@Transactional
public class UserService
{
	@Autowired
	private UserMapper userMapper;
	
	public User getUserByID(long id) {
		return this.userMapper.getUserByID(id);
	}
	public User getUserByMobile(String mobile){
		return this.userMapper.getUserByMobile(mobile);
	}
	public User getUserByUsername(String name) {
		return this.userMapper.getUserByUsername(name);
	}
	
	public User findUserByUsername(String name) {
		return this.userMapper.findUserByUsername(name);
	}
	
	public void updateUsername(long userid, String username) {
		this.userMapper.updateUsername(userid, username);
	}
	
	
	public List<User> getAllUsers() {
		return this.userMapper.getAllUsers();
	}
	
	public void changeUserStateById(Long user_id) {
		String new_state = "enable";
		User user = userMapper.getUserByID(user_id);
		if(user == null)
			return;
		if(user.getEnable().equals("enable")){
			new_state = "disable";
		} 
		this.userMapper.changeUserStateById(user_id, new_state);
	}

}

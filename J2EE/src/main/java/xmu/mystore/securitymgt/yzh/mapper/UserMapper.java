package xmu.mystore.securitymgt.yzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import xmu.mystore.securitymgt.yzh.model.User;

@Component
public interface UserMapper {
	User getUserByID(long id);
	User getUserByMobile(String mobile);
	User getUserByUsername(String name);
	User findUserByUsername(String name);
	void updateUsername(@Param("user_id")long userid, @Param("user_name")String username);
	List<User> getAllUsers();
	
	void changeUserStateById(@Param("user_id")Long user_id, @Param("new_state")String new_state);
}

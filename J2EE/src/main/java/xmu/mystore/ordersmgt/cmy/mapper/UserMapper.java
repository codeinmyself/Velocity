package xmu.mystore.ordersmgt.cmy.mapper;

import org.springframework.stereotype.Repository;

import xmu.mystore.ordersmgt.cmy.entity.User;

@Repository
public interface UserMapper {
	
	public User getUserByUserId(long user_id);
	
}

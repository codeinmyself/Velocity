package xmu.mystore.ordersmgt.cdd.dao;

import org.springframework.stereotype.Repository;

import xmu.mystore.ordersmgt.cdd.model.User;

@Repository
public interface UserMapper {
	
	public User getUserByUserId(long user_id);
	
}

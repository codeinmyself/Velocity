package xmu.mystore.ordersmgt.lhr.Mapper;

import org.springframework.stereotype.Repository;

import xmu.mystore.ordersmgt.lhr.model.User;

@Repository
public interface UserMapper {
	
	public User getUserByUserId(long user_id);
	
}

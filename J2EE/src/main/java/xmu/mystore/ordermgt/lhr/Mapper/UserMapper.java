package xmu.mystore.ordermgt.lhr.Mapper;

import org.springframework.stereotype.Repository;

import xmu.mystore.ordermgt.lhr.model.User;

@Repository
public interface UserMapper {
	
	public User getUserByUserId(long user_id);
	
}

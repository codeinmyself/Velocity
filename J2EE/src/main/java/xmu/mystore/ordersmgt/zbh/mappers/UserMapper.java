package xmu.mystore.ordersmgt.zbh.mappers;

import org.springframework.stereotype.Repository;

import xmu.mystore.ordersmgt.zbh.model.User;

@Repository
public interface UserMapper {
	public User getUserByUserId(long userId);
}

package xmu.mystore.ordersmgt.zyd.mapper;

import org.springframework.stereotype.Repository;

import xmu.mystore.ordersmgt.zyd.entities.User;

@Repository
public interface UserMapper {
	public User getUserById(long uid);
}

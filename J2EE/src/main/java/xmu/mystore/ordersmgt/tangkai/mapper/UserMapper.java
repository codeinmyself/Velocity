package xmu.mystore.ordersmgt.tangkai.mapper;

import org.springframework.stereotype.Repository;

import xmu.mystore.ordersmgt.tangkai.model.User;

/**
 * @author tangkai
 * @data 2017年6月2日--下午1:17:29
 */
@Repository
public interface UserMapper {
	
	public User getUserByUserId(long user_id);
	
}

package xmu.mystore.pay.lhg.dao;

import org.springframework.stereotype.Component;
import xmu.mystore.pay.lhg.model.User;

@Component
public interface UserDao {

	public User getUser(long id);
}

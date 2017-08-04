package xmu.mystore.pay.lhg.dao;

import org.apache.ibatis.annotations.Param;
import xmu.mystore.pay.lhg.model.UserAddress;

import java.util.List;

public interface UserAddressDao {

    public void add(UserAddress userAddress);

    public void delete(UserAddress userAddress);

    public void update(UserAddress userAddress);

    public UserAddress select(UserAddress userAddress);

    public List<UserAddress> selectAll(@Param("user_id") long user_id);

}

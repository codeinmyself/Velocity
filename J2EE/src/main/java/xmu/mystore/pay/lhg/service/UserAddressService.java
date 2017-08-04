package xmu.mystore.pay.lhg.service;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import xmu.mystore.pay.lhg.model.UserAddress;
@Mapper
public interface UserAddressService {

    public void addAUserAddress(@Param("pojo") UserAddress userAddress);

    public void modifyUserAddress(@Param("pojo") UserAddress userAddress);

}

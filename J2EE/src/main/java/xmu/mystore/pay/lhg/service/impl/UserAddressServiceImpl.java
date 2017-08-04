package xmu.mystore.pay.lhg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.mystore.pay.lhg.dao.UserAddressDao;
import xmu.mystore.pay.lhg.model.UserAddress;
import xmu.mystore.pay.lhg.service.UserAddressService;

@Service("UserAddressService")
public class UserAddressServiceImpl implements UserAddressService {

    @Autowired
    private UserAddressDao userAddressDao;

    @Override
    public void addAUserAddress(UserAddress userAddress) {
        userAddressDao.add(userAddress);
    }

    @Override
    public void modifyUserAddress(UserAddress userAddress) {
        userAddressDao.update(userAddress);
    }

}
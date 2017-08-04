package xmu.mystore.pay.lhg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xmu.mystore.pay.lhg.model.UserAddress;
import xmu.mystore.pay.lhg.service.UserAddressService;

@Controller
@RequestMapping(value = "/userAddress")
public class UserAddressController {

    @Autowired
    private UserAddressService userAddressService;

    @RequestMapping(value = "addOrder", method = RequestMethod.GET)
    public String addUserAddressPage() {
        return "/pay/lhg/myCart";
    }

    @RequestMapping(value = "addOrder", method = RequestMethod.POST)
    public String addUserAddress(@ModelAttribute("userAddress") UserAddress userAddress) {
        userAddressService.addAUserAddress(userAddress);
        return "/pay/lhg/myCart";
    }

    @RequestMapping(value = "modifyUserAddress", method = RequestMethod.GET)
    public String modifyUserAddressPage() {
        return "/pay/lhg/myCart";
    }

    @RequestMapping(value = "modifyUserAddress", method = RequestMethod.POST)
    public String modifyUserAddress(@ModelAttribute("userAddress") UserAddress userAddress) {
        userAddressService.addAUserAddress(userAddress);
        return "/pay/lhg/myCart";
    }

}

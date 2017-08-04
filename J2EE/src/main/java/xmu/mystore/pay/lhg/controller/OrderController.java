package xmu.mystore.pay.lhg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xmu.mystore.pay.lhg.model.OrderInfo;
import xmu.mystore.pay.lhg.service.OrderInfoService;

@Controller
@RequestMapping(value = "/user/orderindex/order")
public class OrderController {

    @Autowired
    @Qualifier("OrderInfoService")
    private OrderInfoService orderInfoService;

    @RequestMapping(value = "addOrder", method = RequestMethod.GET)
    public String addOrderPage() {
        return "/pay/lhg/balance";
    }


    @RequestMapping(value = "addOrder", method = RequestMethod.POST)
    public String addOrder(@ModelAttribute("order") OrderInfo orderInfo) {
        orderInfo.setOrder_price(2499.99);
        orderInfo.setOrder_id(1);
        orderInfoService.addOrderInfo(orderInfo);
        return "/pay/lhg/orderPay";
    }

}

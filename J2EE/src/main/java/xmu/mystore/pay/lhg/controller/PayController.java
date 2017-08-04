package xmu.mystore.pay.lhg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xmu.mystore.pay.lhg.model.OrderInfo;
import xmu.mystore.pay.lhg.service.OrderGoodsService;
import xmu.mystore.pay.lhg.service.OrderInfoService;

@Controller
@RequestMapping(value = "/pay")
public class PayController {

    @Autowired
    private OrderInfoService orderInfoService;

    @Autowired
    private OrderGoodsService orderGoodsService;

    @RequestMapping(value = "/lhg/orderPay", method = RequestMethod.POST)
    public void pay(Model model) {
//        model.addAttribute("goods", orderGoodsService.getAOrderGoods(null));
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrder_price(2499.7);
        model.addAttribute("order", orderInfo);
    }
}

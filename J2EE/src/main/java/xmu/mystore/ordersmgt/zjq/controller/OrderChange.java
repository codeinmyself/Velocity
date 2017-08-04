package xmu.mystore.ordersmgt.zjq.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import xmu.mystore.ordersmgt.zjq.Mapper.OrderChangeMapper;
import xmu.mystore.ordersmgt.zjq.Mapper.SqlSessionFactoryCreator;
import xmu.mystore.ordersmgt.zjq.model.Order_info;
import xmu.mystore.ordersmgt.zjq.service.OrderChangeMatch;

/**
 * Created by Administrator on 2017/5/23.
 */
@Controller
public class OrderChange {
    @RequestMapping("/UpdateShow")
    public String UpdateShow(@RequestParam(value="order_id")String order_id, Model model)
    {
                long orderId=Long.parseLong(order_id);
                Order_info order_info=new Order_info();
                OrderChangeMapper mapper=new OrderChangeMapper();
                order_info=mapper.SelectOrderById(order_id);
                model.addAttribute("orderinfo",order_info);
                return "zjq/OrderChange";
    }

    @RequestMapping("/UpdateStatus")
    @ResponseBody
    public Order_info UpdateStatus(@RequestParam(value="orderid") String order_id,@RequestParam(value="status") String status)
    {
        Order_info order_info=new Order_info();
        OrderChangeMatch match=new OrderChangeMatch();
        OrderChangeMapper mapper=new OrderChangeMapper();
        order_info=match.MatchOrderInfo(order_id,status);
        order_info=mapper.UpdateStatus(order_info);
        return order_info;
    }

    @RequestMapping("/UpdateAddress")
    @ResponseBody
    public Order_info UpdateAddress(@RequestParam(value="consignee")String consignee,@RequestParam(value = "zipcode") String zipcode,
                                    @RequestParam(value = "telephone")String telephone,@RequestParam(value="address") String address,
                                    @RequestParam(value = "order_id") String order_id)
    {
        Order_info order_info=new Order_info();
        order_info.setConsignee(consignee);
        order_info.setZipcode(zipcode);
        order_info.setTelephone(telephone);
        order_info.setAddress(address);
        long orderId=Long.parseLong(order_id);
        order_info.setOrder_id(orderId);
        OrderChangeMapper mapper=new OrderChangeMapper();
        order_info=mapper.UpdateAddress(order_info);
        return order_info;
    }
    @RequestMapping("/UpdateExpressCode")
    @ResponseBody
    public Order_info UpdateExpressCode(@RequestParam(value="expresscode") String expresscode,@RequestParam(value="order_id") String order_id)
    {
        long orderId=Long.parseLong(order_id);
        Order_info order_info=new Order_info();
        order_info.setOrder_id(orderId);
        order_info.setExpressCode(expresscode);
        OrderChangeMapper mapper=new OrderChangeMapper();
        order_info=mapper.UpdateExpressCode(order_info);
        return order_info;
    }
    @RequestMapping("/UpdateRemark")
    @ResponseBody
    public Order_info UpdateRemark(@RequestParam(value="remark") String remark,@RequestParam(value="order_id") String order_id)
    {
        long orderId=Long.parseLong(order_id);
        Order_info order_info=new Order_info();
        order_info.setOrder_id(orderId);
        order_info.setRemark(remark);
        OrderChangeMapper mapper=new OrderChangeMapper();
        order_info=mapper.UpdateRemark(order_info);
        return order_info;
    }
}

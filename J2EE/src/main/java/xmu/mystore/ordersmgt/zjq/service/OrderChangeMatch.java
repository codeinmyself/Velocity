package xmu.mystore.ordersmgt.zjq.service;

import xmu.mystore.ordersmgt.zjq.Mapper.OrderChangeMapper;
import xmu.mystore.ordersmgt.zjq.model.Order_info;


import java.util.Date;

/**
 * Created by Administrator on 2017/5/31.
 */
public class OrderChangeMatch {
    public Order_info MatchOrderInfo(String order_id,String status)
    {
        Order_info order_info=new Order_info();
        OrderChangeMapper mapper=new OrderChangeMapper();
        int date;
        long orderId=Long.parseLong(order_id);
        int Status=0;
        order_info.setOrder_id(orderId);
        if(status.equals("未付款"))
        {
            Status=0;
            order_info.setOrder_status(Status);
            mapper.UpdateMakeTime(order_info);
        }
        else if(status.equals("已收款"))
        {
            Status=1;
            long d= new Date().getTime();
            order_info.setPay_time(d);
            order_info.setOrder_status(Status);
            mapper.UpdateMakeTime(order_info);
        }
        else if(status.equals("定制中"))
        {
            Status=2;
            long d= new Date().getTime();
            order_info.setMake_time(d);
            order_info.setOrder_status(Status);
            mapper.UpdateMakeTime(order_info);
        }
        else if(status.equals("已发货"))
        {
            Status=3;
            long d= new Date().getTime();
            order_info.setShipped_time(d);
            order_info.setOrder_status(Status);
            mapper.UpdateShippedTime(order_info);
        }
        else if(status.equals("已收货"))
        {
            Status=4;
            long d= new Date().getTime();
            order_info.setReceive_time(d);
            order_info.setOrder_status(Status);
            mapper.UpdateReceiveTime(order_info);
        }
        else if(status.equals("取消"))
        {
            Status=5;
            long d= new Date().getTime();
            order_info.setCancel_time(d);
            order_info.setOrder_status(Status);
            mapper.UpdateCancelTime(order_info);
        }
        return order_info;
    }
}

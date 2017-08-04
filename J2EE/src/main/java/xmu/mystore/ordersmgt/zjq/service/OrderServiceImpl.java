package xmu.mystore.ordersmgt.zjq.service;

import xmu.mystore.ordersmgt.zjq.Mapper.OrderServiceMapper;
import xmu.mystore.ordersmgt.zjq.model.Order_info;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2017/6/2.
 */
public class OrderServiceImpl implements OrderService {
    public String createOrder_sn()
    {
        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        String head=format.format(date);
        Random r=new Random();
        int b=r.nextInt(100000);
        String body=String.format("%05d",b);
        return head+body;
    }
    public List<Order_info> getOrderByUserId(long user_id)
    {
        List<Order_info> orderInfos=new ArrayList<Order_info>();
        OrderServiceMapper mapper=new OrderServiceMapper();
        orderInfos=mapper.SelectOrdersById(user_id);
        return orderInfos;
    }
    public List<Order_info> getOrderByStatus(long user_id,int status)
    {
        List<Order_info> orderInfos=new ArrayList<Order_info>();
        OrderServiceMapper mapper=new OrderServiceMapper();
        orderInfos=mapper.SelectOrdersByStatus(user_id,status);
        return orderInfos;
    }
    public void receiveOrder(long order_id)
    {
        OrderServiceMapper mapper=new OrderServiceMapper();
        mapper.UpdateSend(order_id);
    }
    public void cancelOrder(long order_id)
    {
        OrderServiceMapper mapper=new OrderServiceMapper();
        mapper.UpdateCancel(order_id);
    }

}

package xmu.mystore.ordersmgt.zjq.Mapper;

import org.apache.ibatis.session.SqlSession;
import xmu.mystore.ordersmgt.zjq.model.Order_info;
import xmu.mystore.ordersmgt.zjq.model.UserStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/2.
 */
public class OrderServiceMapper {
    private SqlSession sqlSession;
    protected void finalize()
    {
        if(sqlSession!=null)
        {
            sqlSession.close();
        }
    }
    public OrderServiceMapper()
    {
        sqlSession=SqlSessionFactoryCreator.getSqlSessionFactory().openSession(true);
    }

    public List<Order_info> SelectOrdersById(long user_id)
    {
        List<Order_info> orderInfos=new ArrayList<Order_info>();
        try
        {
            orderInfos=sqlSession.selectList("OrderService.selectbyuserid",user_id);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return orderInfos;
    }

    public List<Order_info> SelectOrdersByStatus(long user_id,int status)
    {
        List<Order_info> orderInfos=new ArrayList<Order_info>();
        UserStatus userStatus=new UserStatus(user_id,status);
        try
        {
            orderInfos=sqlSession.selectList("OrderService.selectbyuserandstatus",userStatus);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return orderInfos;
    }
    public void UpdateSend(long order_id)
    {
        try
        {
            sqlSession.update("OrderService.updatesend",order_id);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void UpdateCancel(long order_id)
    {
        try
        {
            sqlSession.update("OrderService.updatecancel",order_id);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}

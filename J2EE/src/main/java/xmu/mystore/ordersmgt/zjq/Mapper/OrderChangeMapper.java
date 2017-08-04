package xmu.mystore.ordersmgt.zjq.Mapper;

import org.apache.ibatis.session.SqlSession;
import xmu.mystore.ordersmgt.zjq.model.Order_info;

/**
 * Created by Administrator on 2017/5/31.
 */
public class OrderChangeMapper {
    private SqlSession sqlSession;
    public OrderChangeMapper()
    {
        sqlSession=SqlSessionFactoryCreator.getSqlSessionFactory().openSession(true);
    }
    protected void finalize()
    {
        if(sqlSession!=null)
        {
            sqlSession.close();
        }
    }
    public Order_info SelectOrderById(String order_id)
    {
        Order_info order_info=new Order_info();
        try
        {
            order_info=sqlSession.selectOne("OrderChange.selectorderbyid",order_id);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return order_info;
    }
    public Order_info UpdateStatus(Order_info order_info)
    {
        try
        {
            int num=sqlSession.update("OrderChange.updatestatus",order_info);
            if(num<1)
            {
                return null;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return order_info;
    }
    public Order_info UpdateAddress(Order_info order_info)
    {
        try
        {
            int num=sqlSession.update("OrderChange.updateaddress",order_info);
            if(num<1)
            {
                return null;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return order_info;
    }
    public Order_info UpdateExpressCode(Order_info order_info)
    {
        try
        {
            int num=sqlSession.update("OrderChange.updateexpresscode",order_info);
            if(num<1)
            {
                return null;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return order_info;
    }
    public Order_info UpdateRemark(Order_info order_info)
    {
        try
        {
            int num=sqlSession.update("OrderChange.updateaddress",order_info);
            if(num<1)
            {
                return null;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return order_info;
    }
    public Order_info UpdateMakeTime(Order_info order_info)
    {
        try
        {
            int num=sqlSession.update("OrderChange.updatemaketime",order_info);
            if(num<1)
            {
                return null;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return order_info;
    }
    public Order_info UpdateShippedTime(Order_info order_info)
    {
        try
        {
            int num=sqlSession.update("OrderChange.updateshippedtime",order_info);
            if(num<1)
            {
                return null;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return order_info;
    }
    public Order_info UpdateReceiveTime(Order_info order_info)
    {
        try
        {
            int num=sqlSession.update("OrderChange.updatereceivetime",order_info);
            if(num<1)
            {
                return null;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return order_info;
    }
    public Order_info UpdateCancelTime(Order_info order_info)
    {
        try
        {
            int num=sqlSession.update("OrderChange.updatecanceltime",order_info);
            if(num<1)
            {
                return null;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return order_info;
    }
}

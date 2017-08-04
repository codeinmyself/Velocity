package xmu.mystore.ordersmgt.zjq.Mapper;

import org.apache.ibatis.session.SqlSession;
import xmu.mystore.ordersmgt.zjq.model.Order_goods;
import xmu.mystore.ordersmgt.zjq.model.Order_info;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/31.
 */
public class OrderDetailMapper {
    private SqlSession sqlSession;
    protected void finalize()
    {
        if(sqlSession!=null)
        {
            sqlSession.close();
        }
    }
    public OrderDetailMapper()
    {
        sqlSession=SqlSessionFactoryCreator.getSqlSessionFactory().openSession(true);
    }
    public List<Order_goods> SelectOrdersGoods(long orderId)
    {
        List<Order_goods> selectOrderGoods=new ArrayList<Order_goods>();
        try
        {
            selectOrderGoods=sqlSession.selectList("OrderDetail.selectordermapgoods",orderId);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return selectOrderGoods;
    }
    public Order_info SelectOrderOne(long orderId)
    {
        Order_info order_info=new Order_info();
        try
        {
            order_info=sqlSession.selectOne("OrderDetail.selectoneorder",orderId);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return order_info;
    }
}

package xmu.mystore.ordersmgt.zjq.Mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by Administrator on 2017/5/21.
 */
public class SqlSessionFactoryCreator {
    private static SqlSessionFactory sqlSessionFactory = null;

    private SqlSessionFactoryCreator() {

    }
    public static SqlSessionFactory getSqlSessionFactory()
    {
        if(sqlSessionFactory == null) {
            Reader reader = null;
            try {
                reader = Resources.getResourceAsReader("mybatisConfig.xml");
            } catch (IOException e) {
                e.printStackTrace();
            }
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }

        return sqlSessionFactory;
    }
}

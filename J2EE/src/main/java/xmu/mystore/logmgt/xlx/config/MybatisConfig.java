package xmu.mystore.logmgt.xlx.config;

import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;

/*
 * author:幸兰欣
 *
 */

@Configuration
//@ComponentScan("com.xmu.sw.zjh.javaee.config")
@EnableTransactionManagement
public class MybatisConfig {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScanner = new MapperScannerConfigurer();
        mapperScanner.setBasePackage("xmu.mystore.logmgt.xlx.mappers");
        return mapperScanner;
    }

    
    
	@Bean
	protected DruidDataSource DataSource()
	{
		DruidDataSource dataSource=new DruidDataSource();
	
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/shop");
		dataSource.setUsername("root");
		dataSource.setPassword("xxxxx");
		try {
			dataSource.setFilters("stat");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		//设置初始化连接大小
		dataSource.setInitialSize(0);
		//连接池最大使用连接数量
		dataSource.setMaxActive(20);
		//连接池最小空闲
		dataSource.setMinIdle(0);
		//获取连接最大等待事件
		dataSource.setMaxWait(100000);
		//
		dataSource.setTestWhileIdle(true);
		//检测空闲连接的频率
		dataSource.setTimeBetweenEvictionRunsMillis(6000);
		//
		dataSource.setMinEvictableIdleTimeMillis(25200000);
		//
		dataSource.setLogAbandoned(true);
		//防止取到的连接不可以用
		dataSource.setTestOnBorrow(true);
		dataSource.setTestOnReturn(true);
		
		//prepearedStatement
		dataSource.setPoolPreparedStatements(true);
		dataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
		
		dataSource.setValidationQuery("select * from user");
		

		return dataSource;
		
	}
	
	//mybatis分页插件
	@Bean
	public com.github.pagehelper.PageHelper PageHelper()
	{
		com.github.pagehelper.PageHelper helper=new com.github.pagehelper.PageHelper();
		Properties p=new Properties();
		p.setProperty("helperDialect", "mysql");
		p.setProperty("reasonable", "true");
		helper.setProperties(p);
		return helper;
	}

    @Bean
    public SqlSessionFactoryBean sessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setPlugins(new Interceptor[]{(Interceptor) PageHelper()});
        sessionFactory.setDataSource(DataSource());
        sessionFactory.setTypeAliasesPackage("xmu.mystore.logmgt.xlx.model");
        sessionFactory.setTypeHandlersPackage("xmu.mystore.logmgt.xlx.TypeHandlers");
        return sessionFactory;
    }
	
    @Bean
    public DataSourceTransactionManager transactionManager() {
        DataSourceTransactionManager txManager = new DataSourceTransactionManager();
        txManager.setDataSource(DataSource());
        return txManager;
    }
	
	

}

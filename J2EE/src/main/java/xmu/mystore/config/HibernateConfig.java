package xmu.mystore.config;

import java.io.IOException;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

/**
 *
 * Simple to Introduction
 * 
 * @ProjectName: myStore
 * @Package : com.mystore.config
 * @ClassName: HibernateConfig
 * @Description: config DataSource for hibernate
 * @Author : zlt
 * @CreateDate: 2017-5-7
 * @UpdateUser: zlt
 * @UpdateDate: 2017-5-7
 * @UpdateRemark:
 * @Version : [v1.0]
 *
 */

@Configuration
public class HibernateConfig {
	private String driverClassName = "com.mysql.jdbc.Driver";
	private String jdbcURL = "jdbc:mysql://localhost:3306/mystore";
	private String username = "mystore";
	private String password = "javaee";

	@Bean
	public DataSource dataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(driverClassName);
		ds.setUrl(this.jdbcURL);
		ds.setUsername(username);
		ds.setPassword(password);
		return ds;
	}

	@Bean
	public SessionFactory sessionFactory() {
		try {
			LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
			lsfb.setDataSource(dataSource());
			// the mapped models
			lsfb.setPackagesToScan(new String[] { "xmu.mystore.goodsmgt" });

			Properties props = new Properties();
			props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

			lsfb.setHibernateProperties(props);
			lsfb.afterPropertiesSet();
			SessionFactory object = lsfb.getObject();
			return object;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}

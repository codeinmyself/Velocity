package xmu.mystore.config.yzh;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import xmu.mystore.aop.zy.ServiceLogAspect;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class AOPConfig {

}

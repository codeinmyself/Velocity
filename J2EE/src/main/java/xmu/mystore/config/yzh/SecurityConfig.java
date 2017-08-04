package xmu.mystore.config.yzh;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;

import xmu.mystore.securitymgt.yzh.service.CustomUserDetailsService;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

// url的访问控制
// 在获取一些url的时候检测是否登录和有没有权限
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

	@Bean
	public AccessDeniedServletHandler accessDeniedHandler(){
		return new AccessDeniedServletHandler();
	}
	
    @Override  
    protected void configure(AuthenticationManagerBuilder auth)  
            throws Exception {
        auth.userDetailsService(userDetailsService())
           .passwordEncoder(new ShaPasswordEncoder());  // 使用Sha加密
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.csrf().disable();
    	
    	http
    		.formLogin()
    		    .defaultSuccessUrl("/loginSuccessDispatch")       // 登录后根据用户类型跳转
    		.and()
    			.authorizeRequests()   // 用户为超级管理员的时候才能进行商城的管理
    			.antMatchers("/MallMgt", "/MallMgt/*", "/MallMgt/*/*").hasAnyAuthority("super_admin")
    		.and()
    			.authorizeRequests()  // 用户为商店管理员的时候才能进行商店的管理
    			.antMatchers("/Brand", "/Stand", "/Goods", "/Category", "/Role", 
    						"/UserRole", "/order/*").hasAnyAuthority("admin")
    		.and()  // 首页都可以浏览
    			.authorizeRequests().antMatchers("/").permitAll()   		
    		.and()  // 其他的请求都需要认证
    			.authorizeRequests().anyRequest().authenticated()
    		.and()
    			.logout().permitAll();
    	
    	http.exceptionHandling().accessDeniedHandler(accessDeniedHandler());
    }
}
package xmu.mystore.securitymgt.yzh.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import xmu.mystore.securitymgt.yzh.model.User;
import xmu.mystore.securitymgt.yzh.model.UserType;

//import com.xmu.sw.yzh.orderlist.model.User;
//import com.xmu.sw.yzh.orderlist.service.UserService;

public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserService userService;

	@Autowired
	private UserTypeService userTypeService;
	
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.findUserByUsername(username);
        
        if(user == null || user.getEnable().equals("disable")){
            throw new UsernameNotFoundException("not found");
        }
        
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        
        authorities.add(new SimpleGrantedAuthority(user.getUser_type()));
        return new org.springframework.security.core.userdetails.User(user.getUser_name(),
                user.getPassword(), authorities);
    }
    
    
}

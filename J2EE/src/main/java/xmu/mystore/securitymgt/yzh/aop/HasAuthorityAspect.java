package xmu.mystore.securitymgt.yzh.aop;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Component;

import xmu.mystore.securitymgt.yzh.model.Permission;
import xmu.mystore.securitymgt.yzh.service.UserPermissionService;
import xmu.mystore.securitymgt.yzh.util.HasAuthorityUtil;

@Aspect
@Component
public class HasAuthorityAspect {
	@Autowired
	private  HttpServletRequest request;
	
	@Autowired
	UserPermissionService userPermissionService;
	
	@Pointcut("@annotation(xmu.mystore.securitymgt.yzh.annotation.HasAuthority)")
	public void authorityPointcut() {
	}
	
	@Around("authorityPointcut()")
	public Object checkAuthority(ProceedingJoinPoint pjp) throws Throwable{
		String autority = HasAuthorityUtil.getHasAutority(pjp);
		
		System.out.println("request should have authority:" + autority); 
		//在这里检测Principle 是不是用这个权限
		SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession()
				.getAttribute("SPRING_SECURITY_CONTEXT");
		String username = null;
		Long user_id = null;
		if (securityContextImpl != null) {
			username = securityContextImpl.getAuthentication().getName();
			user_id = (Long) request.getSession().getAttribute("userId");
//			System.out.println("username"+username + "user_id" + user_id);
		} else {
			return "redirect:/login";
		}
		if(hasAuthority(user_id, autority)){
			return pjp.proceed();
		} else {
			return "/yzh/403";
		}
	}

	private boolean hasAuthority(Long user_id, String autority) {
		List<Permission> permissionList = userPermissionService.getAllPermissionByUserId(user_id);
		
		for(Permission permission : permissionList){
//			System.out.println(permission.toString());
			if(permission.getPermission().equals(autority)){
				return true;
			}
		}
		return false;
	}
}

package xmu.mystore.logmgt.yzh.aop;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Component;

import xmu.mystore.logmgt.yzh.model.Log;
import xmu.mystore.logmgt.yzh.service.LogService;

import xmu.mystore.logmgt.yzh.annotation.ControllerLogger;

@Aspect
@Component
public class ControllerLog {
	
	@Autowired
	@Qualifier("142528_logService")
	private LogService logService;

	@Autowired
	private  HttpServletRequest request;
	
	// Controller层切点
	@Pointcut("@annotation(xmu.mystore.logmgt.yzh.annotation.ControllerLogger)")
	public void controllerAspect() {
	}

	@Around("controllerAspect()")
	public Object homeControllerLog(ProceedingJoinPoint pjp) throws Throwable {
		Log log = new Log();
		log.setLocal_ip(request.getLocalAddr());
		log.setRemote_ip(request.getRemoteAddr());
		log.setRequest_method(request.getMethod());
		log.setRequest_url(request.getRequestURI());
		log.setResolve_class(pjp.getTarget().getClass().getSimpleName());
		log.setResolve_method(pjp.getSignature().getName());
		log.setDescription(getControllerMethodDescription(pjp));
		log.setOperatorObject(getControllerMethodOperatorObject(pjp));
		Object obj = pjp.proceed();

		log.setResult(obj.toString());
		SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession()
				.getAttribute("SPRING_SECURITY_CONTEXT");
		if (securityContextImpl != null) {
			String username = securityContextImpl.getAuthentication().getName();
			log.setUsername(username);
		} else {
			log.setUsername("");
		}
		//System.out.println(log.toString());
		logService.addLog(log);
		return obj;
	}

	
	//获取注解中对方法的描述信息 用于Controller层注解
	public static String getControllerMethodDescription(JoinPoint joinPoint) throws Exception {
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
		Class targetClass = Class.forName(targetName);
		Method[] methods = targetClass.getMethods();
		String description = "";
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				Class[] clazzs = method.getParameterTypes();
				if (clazzs.length == arguments.length) {
					description = method.getAnnotation(ControllerLogger.class).description();
					break;
				}
			}
		}
		return description;
	}
	
	//获取注解中对方法的描述信息 用于Controller层注解
	public static String getControllerMethodOperatorObject(JoinPoint joinPoint) throws Exception {
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
		Class targetClass = Class.forName(targetName);
		Method[] methods = targetClass.getMethods();
		String operatorObject = "";
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				Class[] clazzs = method.getParameterTypes();
				if (clazzs.length == arguments.length) {
					operatorObject = method.getAnnotation(ControllerLogger.class).operatorObeject();
					break;
				}
			}
		}
		return operatorObject;
	}
}

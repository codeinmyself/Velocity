package xmu.mystore.securitymgt.yzh.util;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;

import xmu.mystore.securitymgt.yzh.annotation.HasAuthority;

public class HasAuthorityUtil {
	/**
	 * 获取注解中对方法的描述信息 用于Controller层的security的tableName
	 * 
	 * @param joinPoint
	 *            切点
	 * @return 方法描述
	 * @throws Exception
	 */
	public static String getHasAutority(JoinPoint joinPoint) throws Exception {
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
		Class targetClass = Class.forName(targetName);
		Method[] methods = targetClass.getMethods();
		String authority = "";
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				Class[] clazzs = method.getParameterTypes();
				if (clazzs.length == arguments.length) {
					authority = method.getAnnotation(HasAuthority.class).authority();
					break;
				}
			}
		}
		return authority;
	}
	

}

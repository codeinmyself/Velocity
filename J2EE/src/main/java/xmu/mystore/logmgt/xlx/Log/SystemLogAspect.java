package xmu.mystore.logmgt.xlx.Log;

import java.lang.reflect.Method;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;    
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.druid.support.json.JSONUtils;

import xmu.mystore.logmgt.xlx.annotation.ServiceLogger;
import xmu.mystore.logmgt.xlx.model.Log;

import xmu.mystore.logmgt.xlx.service.LogService;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SystemLogAspect {
	private static final Logger log=Logger.getLogger(SystemLogAspect.class);
	
	//用于存储查询log记录
	@Autowired
	LogService logservice;
	
	
	//定义pointcut
	@Pointcut("@annotation(xmu.mystore.logmgt.xlx.annotation.ServiceLogger)")
	public void serviceAspect()
	{
		
	}
	
	
	//在返回后调用，进行日志记录
	@AfterReturning(value = "serviceAspect()")
	public void doAfterReturning(JoinPoint joinPoint)
	{
//		 System.out.println("==doAround方法调用==");
//		 HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();    
//	     HttpSession session = request.getSession();    
//	          读取session中的用户   ,当前用户已current_user的键存在session里 
//	     User user = (User) session.getAttribute("current_user");   
//	     String params = "";    
//         if (joinPoint.getArgs() !=  null && joinPoint.getArgs().length > 0) {    
//             for ( int i = 0; i < joinPoint.getArgs().length; i++) {    
//                params += JSONUtils.toJSONString(joinPoint.getArgs()[i]) + ";";    
//            }    
//        }
        
         try {    
           /*==========数据库日志=========*/    
           Log log =new Log();   
           log.setDescription(getServiceMethodDescription(joinPoint));    
           log.setExceptionCode(null);    
           log.setExceptionDetails(null);   
           log.setOperateObject(getServiceMethodOperateObject(joinPoint));
//         log.setOperateObjectId(getServiceMethodOperateObjectID(joinPoint));
           log.setMethodname((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));    
//         log.setParams(params);
           /**************************/
         
           log.setUserid(1);    
           /*************************/
           log.setSuccess(true);
//         log.setCreatetime(System.currentTimeMillis());    
             log.setCreatetime(new Date());
           //保存数据库    
           logservice.save(log);    
               
       }  catch (Exception ex) {    
           //记录本地异常日志    
           log.error("==异常通知异常1==");    
           log.error("异常信息:{}"+ex.getMessage());    
       }    
        /*==========记录本地异常日志==========*/    
       log.info("调用方法:{}"+joinPoint.getTarget().getClass().getName() + joinPoint.getSignature().getName());    
//       log.info("参数:{}"+params);
		
	}
	
	//service层方法抛出异常后调用
	 @AfterThrowing(pointcut = "serviceAspect()", throwing = "e")    
     public  void doAfterThrowing(JoinPoint joinPoint, Throwable e) {    
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();    
//        HttpSession session = request.getSession();    
//        //读取session中的用户   ,当前用户已current_user的键存在session里 
//        User user = (User) session.getAttribute("current_user");      
        //获取用户请求方法的参数并序列化为JSON格式字符串   
		 System.out.println("==doAfterThrowing方法调用==");
//        String params = "";    
//         if (joinPoint.getArgs() !=  null && joinPoint.getArgs().length > 0) {    
//             for ( int i = 0; i < joinPoint.getArgs().length; i++) {    
//                params += JSONUtils.toJSONString(joinPoint.getArgs()[i]) + ";";    
//            }    
//        }    
         try {    

            /*==========数据库日志=========*/    
            Log log =new Log();   
            log.setDescription(getServiceMethodDescription(joinPoint));    
            log.setExceptionCode(e.getClass().getName());    
            log.setExceptionDetails(e.getMessage());   
            log.setOperateObject(getServiceMethodOperateObject(joinPoint));
//            log.setOperateObjectId(getServiceMethodOperateObjectID(joinPoint));
            log.setMethodname((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));    
//            log.setParams(params);  
            /******************************/
            log.setUserid(1);   
            /******************************/
            log.setSuccess(false); 
//            log.setCreatetime(System.currentTimeMillis());    
            log.setCreatetime(new Date());  
            //保存数据库    
            logservice.save(log);    
             
        }  catch (Exception ex) { 
        	
            //记录本地异常日志    
            log.error("==异常记录时发生异常==");    
            log.error("异常信息:{}"+ex.getMessage());    
        }    
         /*==========记录本地异常日志==========*/    
        log.error("异常方法:{}"+joinPoint.getTarget().getClass().getName() + joinPoint.getSignature().getName());    
        log.error("异常代码：{}"+e.getClass().getName());
        log.error("异常信息：{}"+ e.getMessage());
//        log.error("参数:{}"+params);
    }    
    
	 /**  
	     * 获取注解中对方法的描述信息 用于service层注解  
	     *  
	     * @param joinPoint 切点  
	     * @return 方法描述  
	     * @throws Exception  
	     */    
	     public  static String getServiceMethodDescription(JoinPoint joinPoint)    
	             throws Exception {    
	        String targetName = joinPoint.getTarget().getClass().getName();    
	        String methodName = joinPoint.getSignature().getName();    
	        Object[] arguments = joinPoint.getArgs();    
	        Class<?> targetClass = Class.forName(targetName);    
	        Method[] methods = targetClass.getMethods();    
	        String description = "";    
	         for (Method method : methods) {    
	             if (method.getName().equals(methodName)) {    
	                Class<?>[] clazzs = method.getParameterTypes();    
	                 if (clazzs.length == arguments.length) {    
	                    description = method.getAnnotation(ServiceLogger. class).description();    
	                     break;    
	                }    
	            }    
	        }    
	         return description;    
	    }  
	     
	     /**  
		     * 获取注解中对方法的描述信息 用于service层注解  
		     *  
		     * @param joinPoint 切点  
		     * @return 获取操作对象  
		     * @throws Exception  
		     */    
		     public  static String getServiceMethodOperateObject(JoinPoint joinPoint)    
		             throws Exception {    
		        String targetName = joinPoint.getTarget().getClass().getName();    
		        String methodName = joinPoint.getSignature().getName();    
		        Object[] arguments = joinPoint.getArgs();    
		        Class<?> targetClass = Class.forName(targetName);    
		        Method[] methods = targetClass.getMethods();    
		        String operateObject = "";    
		         for (Method method : methods) {    
		             if (method.getName().equals(methodName)) {    
		                Class<?>[] clazzs = method.getParameterTypes();    
		                 if (clazzs.length == arguments.length) {    //名字相同，参数个数相同，确定找到了这个方法
		                    operateObject = method.getAnnotation(ServiceLogger. class).OperateObject();    
		                     break;    
		                }    
		            }    
		        }    
		         return operateObject;    
		    } 
	
		     	/**  
			     * 约定对于删除和增加和修改的方法进行日志记录，为了记录 
			     *  
			     * @param joinPoint 切点  
			     * @return 获取操作对象id  
			     * @throws Exception  
			     */    
//			     public static long getServiceMethodOperateObjectID(JoinPoint joinPoint)    
//			             throws Exception {    
//			        String targetName = joinPoint.getTarget().getClass().getName();    
//			        String methodName = joinPoint.getSignature().getName();    
//			        Object[] arguments = joinPoint.getArgs();
//			        String operateObjectID=arguments[0].toString();
//			        long objectid=Long.parseLong(operateObjectID);
//			        return objectid;   
//			    } 
}

package xmu.mystore.securitymgt.yzh.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface HasAuthority {
	//String tableName() default "";
	//String operator() default "";
	String authority() default ""; 
	//String[] authorities() default "";
}



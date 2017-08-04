package xmu.mystore.goodsmgt.cwh.service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=GoodsExistValidator.class)
public @interface GoodsExist {
	
	int min() default 1;
	
	int max() default 10;
	
    String message();

    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};

}

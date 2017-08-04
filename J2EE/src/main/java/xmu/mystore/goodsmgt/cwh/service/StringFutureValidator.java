package xmu.mystore.goodsmgt.cwh.service;

import java.util.Calendar;

import javax.annotation.Resource;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;

import xmu.mystore.goodsmgt.cwh.dao.TimeConvertor;
import xmu.mystore.goodsmgt.cwh.service.GoodsService;

public class StringFutureValidator implements ConstraintValidator<StringFuture, String> {

    @Resource
    private ResourceBundleMessageSource messageSource;
    
    private StringFuture future;
    
    @Override
    public void initialize(StringFuture future) {
        this.future = future;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintContext) {
        boolean isValid;
        Calendar now = Calendar.getInstance();
        Calendar value_time = TimeConvertor.StringToCalendar(value);
        
        if(now.compareTo(value_time)<0) {
            isValid = true;
        }
        else {
            isValid = false;
        }
        
        if(!isValid) {
            constraintContext.disableDefaultConstraintViolation();
            constraintContext.buildConstraintViolationWithTemplate(future.message()).addConstraintViolation();
        }
        return isValid;
    }

}
package xmu.mystore.goodsmgt.cwh.service;

import javax.annotation.Resource;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;

import xmu.mystore.goodsmgt.cwh.service.GoodsService;

public class GoodsExistValidator implements ConstraintValidator<GoodsExist, String> {

    @Resource
    private ResourceBundleMessageSource messageSource;
    
    @Autowired
    private GoodsService service;
    
    private GoodsExist ge;
    
    @Override
    public void initialize(GoodsExist ge) {
        this.ge = ge;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintContext) {
        boolean isValid;
        
        
        if(value != null && value.length()>ge.min()  &&value.length() <= ge.max() && !service.existGoodsByGoodsCode(value)) {
            isValid = true;
        }
        else {
            isValid = false;
        }
        
        if(!isValid) {
            constraintContext.disableDefaultConstraintViolation();
            constraintContext.buildConstraintViolationWithTemplate(ge.message()).addConstraintViolation();
        }
        return isValid;
    }

}
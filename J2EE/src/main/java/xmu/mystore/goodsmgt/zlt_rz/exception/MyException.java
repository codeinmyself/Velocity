package xmu.mystore.goodsmgt.zlt_rz.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author zhenglongtian
 *
 */
@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="it is a test")
public class MyException extends RuntimeException{

}

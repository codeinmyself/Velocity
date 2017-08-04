package xmu.mystore.goodsmgt.lcf.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="Error test~")
public class MyException extends RuntimeException{

}

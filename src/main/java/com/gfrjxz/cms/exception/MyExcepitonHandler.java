package com.gfrjxz.cms.exception;

import com.gfrjxz.cms.util.RessponseMessge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


//统一异常处理
@ControllerAdvice
public class MyExcepitonHandler {

    private static  final Logger logger = LoggerFactory.getLogger(MyExcepitonHandler.class);
    @ExceptionHandler(value=Exception.class)
    public Object BadparameshandleException(Exception exception) {

        if (exception.getClass().getName().equals("org.springframework.web.bind.MethodArgumentNotValidException")){
            String errorInfo = ((MethodArgumentNotValidException) exception).getBindingResult().getFieldError().getDefaultMessage();
            return RessponseMessge.Error(null,errorInfo);
        }
        logger.error(exception.getMessage());
        exception.printStackTrace();
        return RessponseMessge.Error(null,exception.getMessage());
    }
    @ExceptionHandler(value=UserException.class)
    public Object UserException(UserException exception)    {
        logger.error("发生错误了:"+exception.getMessage());
        return RessponseMessge.Error(null,exception.getMessage());
    }


}

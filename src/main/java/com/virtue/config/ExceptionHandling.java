package com.virtue.config;

import com.virtue.model.ReturnParam;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler
    public ReturnParam toExcetion(Exception e){
        e.printStackTrace();

        return new ReturnParam(false,"服务器异常！");
    }
}

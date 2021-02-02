package com.pp.buying.exception;


import com.pp.buying.exception.baseerrorinfo.CommonEnum;
import com.pp.buying.vo.ResultBody;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 全局异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理自定义异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public ResultBody bizExceptionHandler(HttpServletRequest req, BizException e){
        return ResultBody.error(e.getErrorCode(),e.getErrorMsg());
    }

    @ExceptionHandler(value =NullPointerException.class)
    @ResponseBody
    public ResultBody exceptionHandler(HttpServletRequest req,NullPointerException e){
        return ResultBody.error(CommonEnum.BODY_NOT_MATCHE);
    }

    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public ResultBody exceptionHandler(HttpServletRequest req,Exception e){
        return ResultBody.error(CommonEnum.INTERNAL_SERVER_ROR);
    }

    @ExceptionHandler(value = IOException.class)
    @ResponseBody
    public ResultBody exceptionHandler(HttpServletRequest req,IOException e){
        return ResultBody.error(CommonEnum.NOT_FOUND);
    }

}

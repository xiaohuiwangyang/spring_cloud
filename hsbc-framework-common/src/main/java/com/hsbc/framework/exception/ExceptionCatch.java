package com.hsbc.framework.exception;

import com.google.common.collect.ImmutableMap;
import com.hsbc.framework.model.response.CommonCode;
import com.hsbc.framework.model.response.ResponseResult;
import com.hsbc.framework.model.response.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常捕获类
 */
@ControllerAdvice //控制器增强
public class ExceptionCatch {
    public static final Logger log = LoggerFactory.getLogger(ExceptionCast.class);
    //定义map，配置异常类型多对应的错误代码
    private static ImmutableMap<Class<? extends Throwable>, ResultCode> immutableMaps;
    //定义map的build对象，构建map
    public static ImmutableMap.Builder<Class<? extends Throwable>, ResultCode> builder = ImmutableMap.builder();


    //捕获CustomerException的异常
    @ExceptionHandler(CustomerException.class)
    @ResponseBody
    public ResponseResult customerException(CustomerException customerException) {
        log.error("catch exception:{}", customerException.getMessage());
        ResultCode resultCode = customerException.getResultCode();
        return new ResponseResult(resultCode);
    }

    //捕获不可预知的的异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResult exception(Exception exception) {
        log.error("catch exception:{}", exception.getMessage());
        if (immutableMaps == null) {
            immutableMaps = builder.build();
        }
        ResultCode resultCode = immutableMaps.get(exception.getClass());
        if (resultCode != null) {
            return new ResponseResult(resultCode);
        } else {
            return new ResponseResult(CommonCode.SERVER_ERROR);
        }
    }

    static {
        //定义异常类型多对应的错误代码
        builder.put(HttpMessageNotReadableException.class, CommonCode.INVALID_PARAM);
    }

}

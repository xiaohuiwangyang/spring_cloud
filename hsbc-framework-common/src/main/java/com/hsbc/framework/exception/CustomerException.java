package com.hsbc.framework.exception;


import com.hsbc.framework.model.response.ResultCode;

/**
 * 定义异常
 */
public class CustomerException extends RuntimeException {
    //错误代码
    ResultCode resultCode;

    public CustomerException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

   public ResultCode getResultCode(){
        return resultCode;
   }
}

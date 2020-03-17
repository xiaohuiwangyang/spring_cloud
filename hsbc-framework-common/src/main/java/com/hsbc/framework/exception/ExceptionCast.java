package com.hsbc.framework.exception;


import com.hsbc.framework.model.response.ResultCode;

public class ExceptionCast {
    public static void castException(ResultCode resultCode){
        throw new CustomerException(resultCode);
    }
}

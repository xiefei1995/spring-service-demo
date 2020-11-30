//package com.goat.calvin.service.api.controller.base;
//
//
///**
// * <p> 业务错误 <p/>
// * @author xiefei15
// * @version 1.0.0
// * @since 2020/9/21 13:41
// */
//public class BusinessException extends RuntimeException{
//
//    private String errorCode = "500";
//    private Object data;
//
//    public BusinessException() {
//        super((String)null, (Throwable)null);
//    }
//
//    public BusinessException(String message) {
//        super(message, (Throwable)null);
//    }
//
//    public BusinessException(String code, String message) {
//        super(message, (Throwable)null);
//        this.errorCode = code;
//    }
//
//    public BusinessException(String code, String message, Object data) {
//        super(message, (Throwable)null);
//        this.errorCode = code;
//        this.data = data;
//    }
//
//    public BusinessException(String message, Exception innerException) {
//        super(message, innerException);
//    }
//
//    public BusinessException(String message, Object data, Exception innerException) {
//        super(message, innerException);
//        this.data = data;
//    }
//
//    public BusinessException(Exception innerException) {
//        super(innerException);
//    }
//
//    public String getErrorCode() {
//        return this.errorCode;
//    }
//
//    public void setErrorCode(String errorCode) {
//        this.errorCode = errorCode;
//    }
//
//    public void setData(Object data) {
//        this.data = data;
//    }
//
//    public Object getData() {
//        return this.data;
//    }
//}

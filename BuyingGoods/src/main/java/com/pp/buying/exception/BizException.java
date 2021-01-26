package com.pp.buying.exception;

import com.pp.buying.exception.baseerrorinfo.BaseErrorInfoInterface;

public class BizException extends RuntimeException{

    /**
     * 错误码
     */
    private String errorCode;
    /**
     * 错误信息
     */
    private String errorMsg;

    public BizException(){
        super();
    }

    public BizException(BaseErrorInfoInterface errorInfo){
        super(errorInfo.getResulteCode());
        this.errorCode = errorInfo.getResulteCode();
        this.errorMsg = errorInfo.getResultMsg();
    }

    public BizException(BaseErrorInfoInterface errorInfo,Throwable csuse){
        super(errorInfo.getResulteCode(),csuse);
        this.errorCode = errorInfo.getResulteCode();
        this.errorMsg = errorInfo.getResultMsg();
    }

    public BizException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public BizException(String errorCode, String errorMsg) {
        super(errorCode);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BizException(String errorCode, String errorMsg, Throwable cause) {
        super(errorCode, cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }


    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
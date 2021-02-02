package com.pp.buying.vo;

import com.pp.buying.exception.baseerrorinfo.BaseErrorInfoInterface;
import com.pp.buying.exception.baseerrorinfo.CommonEnum;

/**
 * 数据传输格式
 */
public class ResultBody {

    /**
     * 响应码
     */
    private String code;

    /**
     * 响应消息
     */
    private String msg;

    /**
     * 响应结果
     */
    private Object result;

    public ResultBody(){

    }

    public ResultBody(BaseErrorInfoInterface errorInfo){
        this.code = errorInfo.getResulteCode();
        this.msg = errorInfo.getResultMsg();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    /**
     * 成功
     * @param data
     * @return
     */
    public static ResultBody success(Object data){
        ResultBody resultBody = new ResultBody();
        resultBody.setCode(CommonEnum.SUCCESS.getResulteCode());
        resultBody.setMsg(CommonEnum.SUCCESS.getResultMsg());
        resultBody.setResult(data);
        return resultBody;
    }

    /**
     * 失败
     */
    public static ResultBody error(String code, String message){
        ResultBody resultBody = new ResultBody();
        resultBody.setCode(code);
        resultBody.setMsg(message);
        resultBody.setResult(null);
        return resultBody;
    }

    /**
     * 失败
     */
    public static ResultBody error(BaseErrorInfoInterface errorInfo){
        ResultBody rb = new ResultBody();
        rb.setMsg(errorInfo.getResultMsg());
        rb.setCode(errorInfo.getResulteCode());
        rb.setResult(null);
        return rb;
    }

    /**
     * 失败
     */
    public static ResultBody error(String message){
        ResultBody rb = new ResultBody();
        rb.setCode("-1");
        rb.setMsg(message);
        rb.setResult(null);
        return rb;
    }
}
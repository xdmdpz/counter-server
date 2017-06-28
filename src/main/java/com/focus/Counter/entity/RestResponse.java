package com.focus.Counter.entity;

/**
 * @author if
 *
 */
public class RestResponse {
    private String code = null;
    private String msg = null;
    private Object data = null;

    public RestResponse() {
    }

    public RestResponse(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }



    public void SuccessReply(String msg, Object data) {
        this.code = "000000";
        this.msg = msg;
        this.data = data;
    }

    public void SuccessReply(String msg) {
        this.code = "000000";
        this.msg = msg;
        this.data = null;
    }

    public void NoCountReply(String msg) {
        this.code = "000404";
        this.msg = msg;
        this.data = null;
    }
    public void ErrorReply(String msg){
        this.code = "000010";
        this.msg = msg;
        this.data = null;
    }
}

package com.doandkeep.devjourney.bean;

/**
 * Created by zhangtao on 16/8/1.
 */
public class BaseWeiboResponse<T> {
    private String request;
    private String error_code;
    private String error;

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}

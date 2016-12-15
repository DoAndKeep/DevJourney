package com.doandkeep.devjourney.base.presentation;

/**
 * 错误Model
 * Created by zhangtao on 2016/12/15.
 */

public class ErrorModel extends BaseModel {
    private int statusCode;
    private String message;

    public ErrorModel(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }
}

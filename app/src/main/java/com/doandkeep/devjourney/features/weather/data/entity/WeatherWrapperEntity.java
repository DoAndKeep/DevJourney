package com.doandkeep.devjourney.features.weather.data.entity;

/**
 * Created by zhangtao on 16/8/11.
 */
public class WeatherWrapperEntity {
    private String errNum;
    private String errMsg;
    private WeatherEntity retData;

    public String getErrNum() {
        return errNum;
    }

    public void setErrNum(String errNum) {
        this.errNum = errNum;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public WeatherEntity getRetData() {
        return retData;
    }

    public void setRetData(WeatherEntity retData) {
        this.retData = retData;
    }
}

package com.doandkeep.devjourney.bean.weather;

/**
 * Created by zhangtao on 16/8/11.
 */
public class WeatherWrapper {
    private String errNum;
    private String errMsg;
    private Weather retData;

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

    public Weather getRetData() {
        return retData;
    }

    public void setRetData(Weather retData) {
        this.retData = retData;
    }
}

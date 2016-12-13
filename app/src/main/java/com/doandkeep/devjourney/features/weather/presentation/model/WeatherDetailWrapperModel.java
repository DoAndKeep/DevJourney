package com.doandkeep.devjourney.features.weather.presentation.model;

import com.doandkeep.devjourney.base.presentation.BaseModel;

/**
 * 天气详情包装Model
 * Created by zhangtao on 16/8/11.
 */
public class WeatherDetailWrapperModel extends BaseModel {
    private String errNum;
    private String errMsg;
    private WeatherDetailModel retData;

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

    public WeatherDetailModel getRetData() {
        return retData;
    }

    public void setRetData(WeatherDetailModel retData) {
        this.retData = retData;
    }
}

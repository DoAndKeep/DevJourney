package com.doandkeep.devjourney.features.douban.movie.presentation.model;

import com.doandkeep.devjourney.base.presentation.BaseModel;

/**
 * Created by zhangtao on 2016/11/23.
 */

public class MovieImageModel extends BaseModel {
    private String large;
    private String medium;
    private String small;

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }
}

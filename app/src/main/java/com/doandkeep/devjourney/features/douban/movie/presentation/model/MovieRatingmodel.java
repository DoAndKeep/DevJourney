package com.doandkeep.devjourney.features.douban.movie.presentation.model;

import com.doandkeep.devjourney.base.presentation.BaseModel;

/**
 * Created by zhangtao on 2016/11/23.
 */

public class MovieRatingmodel extends BaseModel {
    private int max;
    private int min;
    private float average;
    private String stars;

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }
}

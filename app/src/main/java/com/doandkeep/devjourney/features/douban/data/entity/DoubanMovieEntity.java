package com.doandkeep.devjourney.features.douban.data.entity;

import com.doandkeep.devjourney.base.data.entity.IDataEntity;

/**
 * Created by zhangtao on 2016/11/23.
 */

public class DoubanMovieEntity implements IDataEntity {
    /**
     * 条目id
     */
    private String id;
    /**
     * 中文名
     */
    private String title;
    /**
     * 原名
     */
    private String original_title;
    /**
     * 条目URL
     */
    private String alt;
    /**
     * 电影海报图，分别提供288px x 465px(大)，96px x 155px(中) 64px x 103px(小)尺寸
     */
    private DoubanMovieImageEntity images;
    /**
     * 评分
     */
    private DoubanMovieRatingEntity rating;
    /**
     * 年代
     */
    private String year;
    /**
     * 条目分类, movie或者tv
     */
    private String subtype;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public DoubanMovieImageEntity getImages() {
        return images;
    }

    public void setImages(DoubanMovieImageEntity images) {
        this.images = images;
    }

    public DoubanMovieRatingEntity getRating() {
        return rating;
    }

    public void setRating(DoubanMovieRatingEntity rating) {
        this.rating = rating;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }
}

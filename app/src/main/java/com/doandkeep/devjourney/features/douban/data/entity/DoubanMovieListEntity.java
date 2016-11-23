package com.doandkeep.devjourney.features.douban.data.entity;

import com.doandkeep.devjourney.base.data.entity.IDataEntity;

import java.util.List;

/**
 * Created by zhangtao on 2016/11/23.
 */
public class DoubanMovieListEntity implements IDataEntity {
    private int count;
    private int start;
    private int total;
    private String title;
    private List<DoubanMovieEntity> subjects;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<DoubanMovieEntity> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<DoubanMovieEntity> subjects) {
        this.subjects = subjects;
    }
}

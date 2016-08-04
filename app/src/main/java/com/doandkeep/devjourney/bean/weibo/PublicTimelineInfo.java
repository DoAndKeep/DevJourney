package com.doandkeep.devjourney.bean.weibo;

import com.doandkeep.devjourney.bean.BaseDto;

import java.util.List;

/**
 * 最新的公共微博信息
 * Created by zhangtao on 16/8/1.
 */
public class PublicTimelineInfo extends BaseDto {

    private int previous_cursor;
    private String next_cursor;
    private int total_number;
    private List<?> statuses;

    public int getPrevious_cursor() {
        return previous_cursor;
    }

    public void setPrevious_cursor(int previous_cursor) {
        this.previous_cursor = previous_cursor;
    }

    public String getNext_cursor() {
        return next_cursor;
    }

    public void setNext_cursor(String next_cursor) {
        this.next_cursor = next_cursor;
    }

    public int getTotal_number() {
        return total_number;
    }

    public void setTotal_number(int total_number) {
        this.total_number = total_number;
    }

    public List<?> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<?> statuses) {
        this.statuses = statuses;
    }
}

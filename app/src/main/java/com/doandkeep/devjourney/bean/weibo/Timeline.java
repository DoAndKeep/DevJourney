package com.doandkeep.devjourney.bean.weibo;

import com.doandkeep.devjourney.bean.BaseWeiboResponse;

import java.util.List;

/**
 * 最新的公共微博信息
 * Created by zhangtao on 16/8/1.
 */
public class Timeline extends BaseWeiboResponse {

    private List<WeiboTimeline> statuses;
    private String previous_cursor;
    private String next_cursor;
    private int total_number;

    public List<WeiboTimeline> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<WeiboTimeline> statuses) {
        this.statuses = statuses;
    }

    public String getPrevious_cursor() {
        return previous_cursor;
    }

    public void setPrevious_cursor(String previous_cursor) {
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
}

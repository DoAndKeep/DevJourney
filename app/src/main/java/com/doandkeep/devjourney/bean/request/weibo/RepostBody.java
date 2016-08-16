package com.doandkeep.devjourney.bean.request.weibo;

/**
 * Created by zhangtao on 16/8/15.
 */
public class RepostBody {
    private String access_token;

    private long id;

    public RepostBody(String access_token, long id) {
        this.access_token = access_token;
        this.id = id;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

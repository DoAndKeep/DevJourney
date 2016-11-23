package com.doandkeep.devjourney.features.douban.data;

import com.doandkeep.devjourney.bean.weibo.Timeline;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by zhangtao on 16/8/5.
 */
public interface DoubanService {

    @GET("movie/in_theaters")
    Call<Timeline> movieForInTheaters(@Query("city") String city);
}

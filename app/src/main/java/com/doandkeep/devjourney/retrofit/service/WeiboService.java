package com.doandkeep.devjourney.retrofit.service;

import com.doandkeep.devjourney.bean.weibo.Timeline;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by zhangtao on 16/8/5.
 */
public interface WeiboService {
    @GET("statuses/public_timeline.json")
    Call<Timeline> timelineForPublic(@Query("access_token") String token, @Query("count") int count, @Query("page") int page);

    @GET("statuses/friends_timeline.json")
    Call<Timeline> timelineForFriend(@Query("access_token") String token, @Query("count") int count, @Query("page") int page);

    @GET("statuses/user_timeline.json")
    Call<Timeline> timelineForMine(@Query("access_token") String token, @Query("count") int count, @Query("page") int page);
}

package com.doandkeep.devjourney.retrofit.service;

import com.doandkeep.devjourney.bean.weibo.Timeline;
import com.doandkeep.devjourney.bean.weibo.WeiboTimeline;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by zhangtao on 16/8/5.
 */
public interface WeiboService {

    @GET("statuses/public_timeline.json")
    Call<Timeline> timelineForPublic(@Query("count") int count, @Query("page") int page);

    @GET("statuses/friends_timeline.json")
    Call<Timeline> timelineForFriend(@Query("count") int count, @Query("page") int page);

    @GET("statuses/user_timeline.json")
    Call<Timeline> timelineForMine(@Query("count") int count, @Query("page") int page);

    @GET("statuses/public_timeline.json")
    Call<Timeline> timelineForPublic();

    @FormUrlEncoded
    @POST("statuses/repost.json")
    Call<WeiboTimeline> repost(@Field("id") String id);

}

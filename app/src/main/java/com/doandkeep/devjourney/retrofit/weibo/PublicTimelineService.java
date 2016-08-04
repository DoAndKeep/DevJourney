package com.doandkeep.devjourney.retrofit.weibo;

import com.doandkeep.devjourney.bean.weibo.PublicTimelineInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by zhangtao on 16/8/1.
 */
public interface PublicTimelineService {
    @GET("statuses/public_timeline.json")
    Call<PublicTimelineInfo> publicTimelines(@Query("access_token") String access_token, @Query("count") int count, @Query("page") int page, @Query("base_app") int base_app);
}

package com.doandkeep.devjourney.retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhangtao on 16/8/5.
 */
public class ServiceGenerator {

    private static final String BASE_URL = "https://api.weibo.com/2/";

    private static Retrofit.Builder retrofitBuilder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    private static OkHttpClient.Builder okHttpClientBuilder =
            new OkHttpClient.Builder();

    public static <T> T createService(Class<T> serviceClass) {
        retrofitBuilder.client(okHttpClientBuilder.build());
        Retrofit retrofit = retrofitBuilder.build();
        return retrofit.create(serviceClass);
    }

}

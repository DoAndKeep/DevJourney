package com.doandkeep.devjourney.retrofit;

import com.doandkeep.devjourney.base.MyApplication;
import com.doandkeep.devjourney.third.weibo.AccessTokenKeeper;
import com.doandkeep.devjourney.util.DebugLog;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhangtao on 16/8/5.
 */
public class ServiceGenerator {

    private static final String TAG = ServiceGenerator.class.getCanonicalName();

    private static final String BASE_URL = "https://api.weibo.com/2/";

    private static Retrofit.Builder retrofitBuilder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    private static OkHttpClient.Builder okHttpClientBuilder =
            new OkHttpClient.Builder().addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request originalRequest = chain.request();
                    HttpUrl originalHttpUrl = originalRequest.url();

                    if (originalHttpUrl.url().toString().startsWith(BASE_URL)) {
                        HttpUrl url = originalHttpUrl.newBuilder()
                                .addQueryParameter("access_token", AccessTokenKeeper.readAccessToken(MyApplication.getInstance()).getToken())
                                .build();
                        Request request = originalRequest.newBuilder()
                                .url(url)
                                .method(originalRequest.method(), originalRequest.body())
                                .build();

                        return chain.proceed(request);
                    } else {
                        return chain.proceed(originalRequest);
                    }
                }
            }).addNetworkInterceptor(new StethoInterceptor());

    public static <T> T createService(Class<T> serviceClass) {
        retrofitBuilder.client(okHttpClientBuilder.build());
        Retrofit retrofit = retrofitBuilder.build();
        return retrofit.create(serviceClass);
    }

}

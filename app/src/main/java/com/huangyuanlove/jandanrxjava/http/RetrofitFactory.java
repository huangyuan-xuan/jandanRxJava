package com.huangyuanlove.jandanrxjava.http;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.huangyuanlove.jandanrxjava.BuildConfig;
import com.huangyuanlove.jandanrxjava.util.L;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**

 */
public class RetrofitFactory {

    private static final String BASE_URL = "http://i.jandan.net/";
    private static final long TIMEOUT = 30;
    private static RetrofitService retrofitService;

    private static OkHttpClient getHttpClient() {

        return new OkHttpClient.Builder()

                .addInterceptor(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                    @Override
                    public void log(String message) {
                        L.d("OKHttp-----", message);

                    }
                }).setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE))
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .build();


    }

    private static GsonBuilder getGsonBuild() {
        return new GsonBuilder()
                .serializeNulls()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY);
    }


    public static RetrofitService getInstance() {
        if (retrofitService == null) {
            retrofitService = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    // 添加Gson转换器
                    .addConverterFactory(GsonConverterFactory.create(getGsonBuild().create()))
                    // 添加Retrofit到RxJava的转换器
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(getHttpClient())
                    .build()
                    .create(RetrofitService.class);
        }

        return retrofitService;
    }

    public static RetrofitService getInstance(String baseUrl) {

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(getGsonBuild().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(getHttpClient())
                .build()
                .create(RetrofitService.class);
    }


}

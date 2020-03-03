package com.mrbhartiya.education.api;

import androidx.annotation.NonNull;

import com.mrbhartiya.education.utility.Constant;
import com.mrbhartiya.education.utility.PreferenceHelper;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public static <T> T createRetrofitService(final Class<T> clazz) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws
                            IOException {
                        Request request = chain.request().newBuilder()
                                .addHeader("client-key", "5A8BCCE6BE3EB88187E1C65351C5A")
                                .addHeader("secret-key","89D57674427A6B8295559BED753CF")
                                .addHeader("Content-Type","application/json")
                                .addHeader("Accept","application/json")
                                .addHeader("Authorization",PreferenceHelper.getUserToken()!=null ? PreferenceHelper.getUserToken():"")
                                .build();
                        return chain.proceed(request);
                    }


                })
                .addInterceptor(interceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(1, TimeUnit.MINUTES)
                .build();

        final Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constant.BASE_URL)
                .build();

        return retrofit.create(clazz);
    }

}

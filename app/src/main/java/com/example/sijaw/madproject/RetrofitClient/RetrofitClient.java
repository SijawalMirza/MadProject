package com.example.sijaw.madproject.RetrofitClient;



import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sijaw on 11/30/2017.
 */

public class RetrofitClient {
    private static Retrofit ourInstance;
    static String token="";

    public static Retrofit getInstance() {
        if (ourInstance == null) {
            OkHttpClient.Builder okhttp=new OkHttpClient.Builder().addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {

                    Request request=chain.request();

                    request.newBuilder().addHeader("Authorization","Bearer "+token);

                   return chain.proceed(request);

                }
            });

            ourInstance = new Retrofit.Builder()
                    .client(okhttp.build())
                    .baseUrl("http://192.168.137.1/blood_bank/public/api/")
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }

        return ourInstance;
    }

    private RetrofitClient() {
    }
}

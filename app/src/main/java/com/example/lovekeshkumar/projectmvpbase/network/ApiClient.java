package com.example.lovekeshkumar.projectmvpbase.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


/**
 * Created by HP on 3/23/2017.
 */
public class ApiClient {
    // http://ec2-34-208-174-81.us-west-2.compute.amazonaws.com:9082/Frenzy/frenzy/v1/mobileRegister
    //Main Url
  public static final String BASE_URL = "http://apiw.nvish.com/public/";
   
     public static Gson gson = new GsonBuilder()
            .setLenient()
            .create();
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson));

    public static <S> S createService(Class<S> serviceClass) {
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();

                Request.Builder requestBuilder = original.newBuilder()
                       // .addHeader("Content-Type", "application/x-www-form-urlencoded")
                        .addHeader("Content-Type", "application/json")
                       // .addHeader(" Auth-Identifier", "08c5b004c092044ea02bc236ce6f40cd72bdfa798a7ee1e3187b64a7f8f9f09a")
                        //.addHeader("Content-Type", "application/json; charset=UTF-8")
                        .method(original.method(), original.body());

                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        });
        httpClient.connectTimeout(1, TimeUnit.HOURS);
        httpClient.readTimeout(1, TimeUnit.HOURS);
        Retrofit retrofit = builder.client(httpClient.build()).build();
        return retrofit.create(serviceClass);
    }

}

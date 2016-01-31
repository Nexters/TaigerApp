package com.nexters.taigerapp.network.request;

import com.nexters.taigerapp.network.ServerConstant;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

public class TagierRestAdapter {
    public static Retrofit restTemplate = null;

    static  {
        restTemplate = new Retrofit.Builder()
                .baseUrl(ServerConstant.LOCAL_HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}

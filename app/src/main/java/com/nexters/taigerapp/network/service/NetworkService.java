package com.nexters.taigerapp.network.service;

import com.nexters.taigerapp.network.ServerConstant;

import java.util.Map;

import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.http.GET;

public interface NetworkService {
    @GET("/")
    Call<Map<String, String>> getIp();

    class Factory {
        public static NetworkService create(){
            return new Retrofit.Builder()
                    .baseUrl(ServerConstant.TEST_HOST)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(NetworkService.class);
        }
    }
}

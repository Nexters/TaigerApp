package com.nexters.taigerapp.network.service;

import com.nexters.taigerapp.network.ServerConstant;

import java.util.Map;

import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TestService {
    @GET("/deal/option/{path}")
    Call<Map<String, String>> getVendorItemId(@Path("path") String path);

    class Factory {
        public static TestService create(){
            return new Retrofit.Builder()
                    .baseUrl(ServerConstant.TEST1_HOST)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(TestService.class);
        }
    }
}

package com.nexters.taigerapp.network.service;

import com.nexters.taigerapp.network.ServerConstant;
import com.nexters.taigerapp.network.service.condition.UserCondition;
import com.nexters.taigerapp.network.response.model.AuthResult;
import com.nexters.taigerapp.ui.user.User;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface UserService {
    @POST("/user/login")
    AuthResult login(String kakaoToken);

    @POST("/user/logout")
    void logout();

    @POST("/user/register")
    AuthResult register(UserCondition condition);

    @GET("/user/me")
    User userInfo();

    @PUT("/user/me")
    void saveUser(UserCondition condition);

    class Factory {
        public static UserService create(){
            return new Retrofit.Builder()
                    .baseUrl(ServerConstant.LOCAL_HOST)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(UserService.class);
        }
    }
}

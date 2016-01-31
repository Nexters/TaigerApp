package com.nexters.taigerapp.network.request;

import com.nexters.taigerapp.network.request.condition.UserCondition;
import com.nexters.taigerapp.network.response.model.AuthResult;
import com.nexters.taigerapp.network.response.model.User;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface UserRequest {
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
}

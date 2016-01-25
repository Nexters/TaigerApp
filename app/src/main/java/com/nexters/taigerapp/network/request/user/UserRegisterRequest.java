package com.nexters.taigerapp.network.request.user;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.nexters.taigerapp.network.ServerUrl;
import com.nexters.taigerapp.network.TaigerApi;
import com.nexters.taigerapp.network.request.RequestInfo;

public class UserRegisterRequest extends TaigerApi implements RequestInfo {
    private String kakaoId;
    private String name;
    private Integer gender;
    private Integer age;
    private AsyncHttpResponseHandler responseHandler;

    public UserRegisterRequest(String kakaoId, String name, Integer gender, Integer age, AsyncHttpResponseHandler responseHandler) {
        this.kakaoId = kakaoId;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.responseHandler = responseHandler;
    }

    @Override
    public String getUrl() {
        return ServerUrl.LOCAL_HOST + ServerUrl.USER_REGISTER;
    }

    @Override
    public RequestParams getParams() {
        RequestParams params = new RequestParams();
        params.add("kakaoId", kakaoId);
        params.add("name", name);
        params.add("gender", String.valueOf(gender));
        params.add("age", String.valueOf(age));
        return params;
    }

    @Override
    public void request() {
        asyncClient.post(getUrl(), getParams(), responseHandler);
    }
}

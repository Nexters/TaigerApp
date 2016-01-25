package com.nexters.taigerapp.network.request.user;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.nexters.taigerapp.network.ServerUrl;
import com.nexters.taigerapp.network.TaigerApi;
import com.nexters.taigerapp.network.request.RequestInfo;

public class UserInfoRequest extends TaigerApi implements RequestInfo {
    private String kakaoId;
    private AsyncHttpResponseHandler responseHandler;

    public UserInfoRequest(String kakaoId, AsyncHttpResponseHandler responseHandler) {
        this.kakaoId = kakaoId;
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
        return params;
    }

    @Override
    public void request() {
        asyncClient.get(getUrl(), getParams(), responseHandler);
    }
}

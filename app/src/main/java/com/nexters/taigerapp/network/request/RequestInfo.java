package com.nexters.taigerapp.network.request;

import com.loopj.android.http.RequestParams;

/**
 * Created by BoBinLee on 2016. 1. 24..
 */
public interface RequestInfo {
    String POST = "POST";
    String GET = "GET";
    String DELETE = "DELETE";

    /**
     * 요청할 target url.
     * @return 요청할 target url.
     */
    String getUrl();

    /**
     * http요청에 필요한 params.
     * @return http요청에 필요한 params.
     */
    RequestParams getParams();

    void request();
}

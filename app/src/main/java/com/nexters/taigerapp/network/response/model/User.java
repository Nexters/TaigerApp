package com.nexters.taigerapp.network.response.model;

import com.nexters.taigerapp.network.response.ResponseBody;

/**
 * Created by BoBinLee on 2016. 1. 24..
 */
public class User {
    private long id;
    private String kakaoId;
    private String name;
    private Integer gender;
    private Integer age;
    private Integer meetingCount;
    private Integer reliability;

    public User(ResponseBody responseBody) throws ResponseBody.ResponseBodyException {
        this.id = responseBody.getLong("id");
        this.kakaoId = responseBody.getString("kakaoId");
        this.name = responseBody.getString("name");
        this.gender = responseBody.getInt("gender");
        this.age = responseBody.getInt("age");
        this.meetingCount = responseBody.getInt("meetingCount");
        this.reliability = responseBody.getInt("reliability");
    }
}

package com.nexters.taigerapp.ui.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private long id;
    private String kakaoId;
    private String name;
    private Integer gender;
    private Integer age;
    private Integer meetingCount;
    private Integer reliability;
}

package com.nexters.taigerapp.network.request.condition;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserCondition {
    private String kakaoId;
    private String kakaoToken;
    private String name;
    private Integer gender;
    private Integer age;
}

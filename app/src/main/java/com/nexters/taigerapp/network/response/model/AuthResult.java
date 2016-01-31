package com.nexters.taigerapp.network.response.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResult {
    private String accessToken;
    private String ipAddress;
    private Date loginDate;
}

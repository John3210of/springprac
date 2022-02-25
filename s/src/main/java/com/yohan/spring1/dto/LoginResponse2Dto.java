package com.yohan.spring1.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class LoginResponse2Dto {

    private Long userid;

    private String email;

    private String username;

    private String token;

    @Builder
    public LoginResponse2Dto(Long userId, String email, String username, String token){
        this.userid = userId;
        this.email = email;
        this.username = username;
        this.token = token;
    }
}
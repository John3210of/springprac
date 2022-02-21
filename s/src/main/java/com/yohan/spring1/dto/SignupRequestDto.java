package com.yohan.spring1.dto;

import lombok.Data;

@Data   // getter setterr requiredargsconstructor, tostring, equalsandhashcod 어노테이션을 포함함.
public class SignupRequestDto {

    private String username;
    private String password;
    private String passwordCheck;
    private String email;

}
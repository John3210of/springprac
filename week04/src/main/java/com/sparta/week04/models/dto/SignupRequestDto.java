package com.sparta.week04.models.dto;

import lombok.Getter;
import lombok.Setter;

//여기서 예외처리 해줘야할듯?

@Setter
@Getter
public class SignupRequestDto {

    private String username;
    private String password;
    private String passwordCheck;
    private String email;

}
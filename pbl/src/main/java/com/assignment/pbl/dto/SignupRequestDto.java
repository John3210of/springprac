package com.assignment.pbl.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignupRequestDto {

    private String username;
    private String password;
    private String passwordCheck;
    private String email;

}
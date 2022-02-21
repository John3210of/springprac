package com.yohan.spring1.controller;

import com.yohan.spring1.dto.SignupRequestDto;
import com.yohan.spring1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/api/register")   //회원가입 임시
    public String register(@RequestBody SignupRequestDto signupRequestDto){
        return userService.Signup(signupRequestDto);

    }
}

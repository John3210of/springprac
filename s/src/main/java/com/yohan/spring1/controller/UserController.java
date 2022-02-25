package com.yohan.spring1.controller;

import com.yohan.spring1.dto.LoginDto;
import com.yohan.spring1.dto.SignupRequestDto;
import com.yohan.spring1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    // 회원가입
    @PostMapping("/api/register")
    public String register(@RequestBody SignupRequestDto signupRequestDto) {
        return userService.Signupv2(signupRequestDto);
    }

//    public String login(@RequestBody Map<String, String> user) {
//     로그인
    @PostMapping("/api/login")

        public String login(@RequestBody LoginDto loginDto) {

        return userService.loginChk(loginDto);

    }
}
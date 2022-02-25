package com.yohan.spring1.controller;

import com.yohan.spring1.dto.LoginDto;
import com.yohan.spring1.dto.LoginResponseDto;
import com.yohan.spring1.dto.SignupRequestDto;
import com.yohan.spring1.model.User;
import com.yohan.spring1.repository.UserRepository;
import com.yohan.spring1.security.JwtTokenProvider;
import com.yohan.spring1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.Map;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
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
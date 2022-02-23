package com.yohan.spring1.controller;

import com.yohan.spring1.dto.LoginDto;
import com.yohan.spring1.dto.SignupRequestDto;

import com.yohan.spring1.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;
//    private final BoardService boardService;
//    private final BoardRepository boardRepository;
//    private final LikesService likesService;
//    private final LikesRepository likesRepository;


    @PostMapping("/api/register")   //회원가입
    public String register(@RequestBody SignupRequestDto signupRequestDto, HttpServletRequest request) {
        return userService.Signup(signupRequestDto,request);
    }

    @PostMapping("/api/login")  //로그인
    public String login(@RequestBody LoginDto loginDto, HttpServletRequest request) {
        return userService.LoginChk(loginDto, request);
    }
}

package com.yohan.spring1.controller;

import com.yohan.spring1.dto.LoginDto;
import com.yohan.spring1.dto.SignupRequestDto;

import com.yohan.spring1.service.UserService;
import lombok.RequiredArgsConstructor;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@RestController
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @PostMapping("/api/register")   //회원가입
    public String register(@RequestBody SignupRequestDto signupRequestDto, HttpServletRequest request) {
        return userService.Signup(signupRequestDto,request);
    }

    @PostMapping("/api/login")  //로그인
    public String login(@RequestBody LoginDto loginDto, HttpServletRequest request) {
        return userService.LoginChk(loginDto, request);
    }

    @PostMapping("/api/logout") //로그아웃
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();   //=> 세션 삭제
        JSONObject obj = new JSONObject();
        obj.put("result", "True");
        obj.put("msg", "로그아웃에 성공했습니다.");
        return obj.toString();
    }
}

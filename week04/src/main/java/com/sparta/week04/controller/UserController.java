package com.sparta.week04.controller;

import com.sparta.week04.models.dto.SignupRequestDto;
import com.sparta.week04.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired  //DI를 받는 부분 @@@@@@@@@@@@여기 공부해 @@@@@@@@@@@
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("/")
//    public String home(){
//        return "index";
//    }

    // 회원 로그인 페이지
    @GetMapping("/api/login")
    public String login() {
        return "login";
    }

    // 회원 가입 페이지
    @GetMapping("/api/register")
    public String signup() {
        return "register";
    }

    // 회원 가입 요청 처리
    @PostMapping("/api/register")
    public String registerUser(SignupRequestDto requestDto) {
        userService.registerUser(requestDto);
        return "redirect:/api/login";
    }
}
package com.yohan.spring1.controller;

import com.yohan.spring1.dto.SignupRequestDto;
import com.yohan.spring1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//@RequiredArgsConstructor

@Controller
public class UserController {

    private final UserService userService;

//    @PostMapping("/api/register")   //회원가입 임시
//    public String register(@RequestBody SignupRequestDto signupRequestDto){
//        return userService.Signup(signupRequestDto);
//
//    }

    @Autowired  //DI를 받는 부분 @@@@@@@@@@@@여기 공부해 @@@@@@@@@@@
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //메인페이지
    @GetMapping("/")
    public String home(){
        return "index";
    }

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

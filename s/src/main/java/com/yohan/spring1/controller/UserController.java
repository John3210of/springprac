package com.yohan.spring1.controller;

import com.yohan.spring1.dto.SignupRequestDto;
import com.yohan.spring1.model.User;
import com.yohan.spring1.repository.UserRepository;
import com.yohan.spring1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @PostMapping("/api/register")
    public String register(Long id,@RequestBody SignupRequestDto signupRequestDto){
        return userService.Signup(id,signupRequestDto);

    }
}

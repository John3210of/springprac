package com.yohan.spring1.service;

import com.yohan.spring1.dto.SignupRequestDto;

import com.yohan.spring1.model.User;
import com.yohan.spring1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    //    public UserService(UserRepository userRepository) {     @RequiredArgsConstructor 있어서 안넣어도 됨.
//        this.userRepository = userRepository;
//    }

    @Transactional
    public String Signup(Long id, SignupRequestDto signupRequestDto){
        User user = new User(signupRequestDto);
        userRepository.save(user);
        return "회원가입 완료";
    }

}

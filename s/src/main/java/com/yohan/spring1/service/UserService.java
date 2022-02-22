package com.yohan.spring1.service;

import com.yohan.spring1.dto.SignupRequestDto;

import com.yohan.spring1.model.User;
import com.yohan.spring1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
//@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    //@RequiredArgsConstructor 있어서 안넣어도 됨.
    //    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

//    @Transactional
//    public String Signup(SignupRequestDto signupRequestDto){
//        User user = new User(signupRequestDto);
//        userRepository.save(user);
//        return "회원가입 완료";
//    }

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(SignupRequestDto requestDto) {
        String username = requestDto.getUsername();
        // 패스워드 암호화
        String password = passwordEncoder.encode(requestDto.getPassword());
        String passwordCheck = passwordEncoder.encode(requestDto.getPasswordCheck());
        String email = requestDto.getEmail();

        // password check 확인
        // 회원 ID 중복 확인
        Optional<User> found = userRepository.findByUsername(username);
        if (found.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자 ID 가 존재합니다.");
        }

        User user = new User(username, password, passwordCheck,email);
        userRepository.save(user);  //DB에 저장하는 부분
    }

}

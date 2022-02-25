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

//     로그인
    @PostMapping("/api/login")
//    public String login(@RequestBody Map<String, String> user) {
        public String login(@RequestBody LoginDto loginDto) {

         JSONObject obj = new JSONObject();

        if (false) {
            obj.put("result", "False");
            obj.put("msg", "이미 로그인 되어 있습니다.");
            return obj.toString();
        }

        String email = loginDto.getEmail();
        String password = loginDto.getPassword();
        boolean exists = userRepository.existsByEmailAndPassword(email, password);

        if (exists) {
            User user = userRepository.findByEmail(email).orElseThrow(() -> new NullPointerException("해당 아이디가 존재하지 않습니다."));
            String token= jwtTokenProvider.createToken(user.getUsername(), user.getRoles());
            //이거 어케 responseDto에 담았는지 물어보기
            obj.put("result", "True");
            obj.put("msg", "로그인에 성공했습니다.");
            obj.append("token",token);
            LoginResponseDto loginResponseDto = new LoginResponseDto(user);
            JSONObject dto = new JSONObject(loginResponseDto);
            obj.append("data", dto); //얘도 어펜드로 넣어야됨
            return obj.toString();
        } else {
            obj.put("result", "False");
            obj.put("msg", "닉네임 또는 패스워드를 확인해주세요.");
            return obj.toString();
        }

    }
}
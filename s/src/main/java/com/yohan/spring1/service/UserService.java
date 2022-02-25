package com.yohan.spring1.service;

import com.yohan.spring1.dto.LoginDto;
import com.yohan.spring1.dto.LoginResponseDto;
import com.yohan.spring1.dto.SignupRequestDto;

import com.yohan.spring1.model.User;
import com.yohan.spring1.repository.UserRepository;
import com.yohan.spring1.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Optional;
import java.util.regex.Pattern;


@Service
@RequiredArgsConstructor

public class UserService {

    private final UserRepository userRepository;
    // 비밀번호 암호화
    private final PasswordEncoder passwordEncoder;
    // 유저 저장소
    private final JwtTokenProvider jwtTokenProvider;

//    @Autowired
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @Transactional
    public String Signupv2(SignupRequestDto signupRequestDto) {
        JSONObject obj = new JSONObject();

//        if (session != null) {
//            obj.put("result", "False");
//            obj.put("msg", "이미 로그인이 되어 있습니다.");
//            return obj.toString();
//        }

        // 유저 생성
        User user = User.builder()
                .email(signupRequestDto.getEmail())
                .username(signupRequestDto.getUsername())
                .password(signupRequestDto.getPassword())
                .passwordCheck(signupRequestDto.getPasswordCheck())
                .roles(Collections.singletonList("ROLE_USER")) // 최초 가입시 USER 로 설정
                .build();

        //닉네임은 `최소 3자 이상, 알파벳 대소문자(a~z, A~Z), 숫자(0~9)`로 구성하기
        if (!Pattern.matches("^[A-Za-z0-9]*$", signupRequestDto.getUsername()) || signupRequestDto.getUsername().length() < 3) {
            obj.put("result", "fail");
            obj.put("msg", "닉네임은 최소 3자 이상, 알파벳 대소문자(a~z, A~Z), 숫자(0~9)입니다.");
            return obj.toString();
        }
        //비밀번호는 `최소 4자 이상이며, 닉네임과 같은 값이 포함된 경우 회원가입에 실패`로 만들기
        if (signupRequestDto.getPassword().contains(signupRequestDto.getUsername()) || signupRequestDto.getPassword().length() < 4) {
            obj.put("result", "fail");
            obj.put("msg", "비밀번호는 최소 4자 이상이며, 닉네임과 같은 값이 포함될 수 없습니다.");
            return obj.toString();
        }
        //비밀번호 확인은 비밀번호와 정확하게 일치하기
        if (!signupRequestDto.getPassword().equals(signupRequestDto.getPasswordCheck())) {
            obj.put("result", "fail");
            obj.put("msg", "비밀번호 일치 여부를 확인해주세요.");
            return obj.toString();
        }
        // 회원 email 중복 확인
        Optional<User> foundId = userRepository.findByEmail(signupRequestDto.getEmail());
        if (foundId.isPresent()) {
            obj.put("result", "fail");
            obj.put("msg", "중복된 사용자 email이 존재합니다.");
            return obj.toString();
        }
        // 회원 이름 중복 확인
        Optional<User> foundName = userRepository.findByUsername(signupRequestDto.getUsername());
        if (foundName.isPresent()) {
            obj.put("result", "fail");
            obj.put("msg", "중복된 사용자 닉네임이 존재합니다.");
            return obj.toString();
        }

        // 비밀번호 암호화
//        String password = passwordEncoder.encode(signupRequestDto.getPassword());
        // 유저 저장하기
        userRepository.save(user);
        obj.put("result", "success");
        obj.put("msg", "회원 가입에 성공하였습니다.");
        return obj.toString();
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////

//    //로그인 체크
//    public String LoginChk(LoginDto loginDto, HttpServletRequest request) {
//
//
//
//    }
}



//    @Transactional
////    public String Signup(SignupRequestDto requestDto, HttpServletRequest request) {
//    public String Signup(SignupRequestDto requestDto) {
//        String username = requestDto.getUsername();
//        String password = requestDto.getPassword();
//        String passwordCheck = requestDto.getPasswordCheck();
//        String email = requestDto.getEmail();
//
//
////        HttpSession session = request.getSession(false);
//
//        JSONObject obj = new JSONObject();
////        if (session != null) {
////            obj.put("result", "False");
////            obj.put("msg", "이미 로그인이 되어 있습니다.");
////            return obj.toString();
////        }
//
//        //닉네임은 `최소 3자 이상, 알파벳 대소문자(a~z, A~Z), 숫자(0~9)`로 구성하기
//        if (!Pattern.matches("^[A-Za-z0-9]*$", username) || username.length() < 3) {
//            obj.put("result", "fail");
//            obj.put("msg", "닉네임은 최소 3자 이상, 알파벳 대소문자(a~z, A~Z), 숫자(0~9)입니다.");
//            return obj.toString();
//        }
//        //비밀번호는 `최소 4자 이상이며, 닉네임과 같은 값이 포함된 경우 회원가입에 실패`로 만들기
//        if (password.contains(username) || password.length() < 4) {
//            obj.put("result", "fail");
//            obj.put("msg", "비밀번호는 최소 4자 이상이며, 닉네임과 같은 값이 포함될 수 없습니다.");
//            return obj.toString();
//        }
//        //비밀번호 확인은 비밀번호와 정확하게 일치하기
//        if (!password.equals(passwordCheck)) {
//            obj.put("result", "fail");
//            obj.put("msg", "비밀번호 일치 여부를 확인해주세요.");
//            return obj.toString();
//        }
//        // 회원 email 중복 확인
//        Optional<User> foundId = userRepository.findByEmail(email);
//        if (foundId.isPresent()) {
//            obj.put("result", "fail");
//            obj.put("msg", "중복된 사용자 email이 존재합니다.");
//            return obj.toString();
//        }
//        // 회원 이름 중복 확인
//        Optional<User> foundName = userRepository.findByUsername(username);
//        if (foundName.isPresent()) {
//            obj.put("result", "fail");
//            obj.put("msg", "중복된 사용자 닉네임이 존재합니다.");
//            return obj.toString();
//        }

//        password = passwordEncoder.encode(requestDto.getPassword());

//        User user = new User(username, password, passwordCheck, email);
//
//        userRepository.save(user);
//        obj.put("result", "success");
//        obj.put("msg", "회원 가입에 성공하였습니다.");
//        return obj.toString();
//    }




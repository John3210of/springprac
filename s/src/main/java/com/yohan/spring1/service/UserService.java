package com.yohan.spring1.service;

import com.yohan.spring1.dto.SignupRequestDto;

import com.yohan.spring1.model.User;
import com.yohan.spring1.repository.UserRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.regex.Pattern;


@Service
//@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    //@RequiredArgsConstructor 있어서 안넣어도 됨.
    //    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public String Signup(SignupRequestDto requestDto) {
        String username = requestDto.getUsername();
        // 패스워드 암호화
        String password = requestDto.getPassword();
        String passwordCheck = requestDto.getPasswordCheck();
        String email = requestDto.getEmail();

        //닉네임은 `최소 3자 이상, 알파벳 대소문자(a~z, A~Z), 숫자(0~9)`로 구성하기
        if (!Pattern.matches("^[A-Za-z0-9]*$", username) || username.length() < 3) {
            JSONObject obj = new JSONObject();
            obj.append("result", "fail");
            obj.append("msg", "닉네임은 최소 3자 이상, 알파벳 대소문자(a~z, A~Z), 숫자(0~9)입니다.");
            return obj.toString();
        }
        //비밀번호는 `최소 4자 이상이며, 닉네임과 같은 값이 포함된 경우 회원가입에 실패`로 만들기
        if (password.contains(username) || password.length() < 4) {
            System.out.println("비번4자에용");
            JSONObject obj = new JSONObject();
            obj.append("result", "fail");
            obj.append("msg", "비밀번호는 최소 4자 이상이며, 닉네임과 같은 값이 포함될 수 없습니다.");
            return obj.toString();
        }
        //비밀번호 확인은 비밀번호와 정확하게 일치하기
        if (!password.equals(passwordCheck)) {
            JSONObject obj = new JSONObject();
            System.out.println("비번불일치에용");
            obj.append("result", "fail");
            obj.append("msg", "비밀번호 일치 여부를 확인해주세요.");
            return obj.toString();
        }
        // 회원 email 중복 확인
        Optional<User> foundId = userRepository.findByEmail(email);
        if (foundId.isPresent()) {
            JSONObject obj = new JSONObject();
            obj.append("result","fail");
            obj.append("msg", "중복된 사용자 email이 존재합니다.");
            return obj.toString();
        }
        // 회원 이름 중복 확인
        Optional<User> foundName = userRepository.findByUsername(username);
        if (foundName.isPresent()) {
            JSONObject obj = new JSONObject();
            obj.append("result", "fail");
            obj.append("msg", "중복된 사용자 닉네임이 존재합니다.");
            return obj.toString();
        }

        password = passwordEncoder.encode(password);
        passwordCheck = passwordEncoder.encode(passwordCheck);
        User user = new User(username, password,passwordCheck, email);
        userRepository.save(user);
        JSONObject obj = new JSONObject();
        obj.append("result", "success");
        obj.append("msg", "회원 가입 성공하였습니다.");
        return obj.toString();
    }

}

package com.yohan.spring1.service;

import com.yohan.spring1.dto.LoginDto;
import com.yohan.spring1.dto.SignupRequestDto;

import com.yohan.spring1.model.User;
import com.yohan.spring1.repository.UserRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;
import java.util.regex.Pattern;


@Service
public class UserService {

    private final UserRepository userRepository;


    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public String Signup(SignupRequestDto requestDto,HttpServletRequest request) {
        String username = requestDto.getUsername();
        String password = requestDto.getPassword();
        String passwordCheck = requestDto.getPasswordCheck();
        String email = requestDto.getEmail();

        HttpSession session = request.getSession(false);

        JSONObject obj = new JSONObject();
        if (session != null){
            obj.append("result", "False");
            obj.append("msg", "이미 로그인이 되어 있습니다.");
            return obj.toString();

        }

        //닉네임은 `최소 3자 이상, 알파벳 대소문자(a~z, A~Z), 숫자(0~9)`로 구성하기
        if (!Pattern.matches("^[A-Za-z0-9]*$", username) || username.length() < 3) {
//            JSONObject obj = new JSONObject();
            obj.append("result", "fail");
            obj.append("msg", "닉네임은 최소 3자 이상, 알파벳 대소문자(a~z, A~Z), 숫자(0~9)입니다.");
            return obj.toString();
        }
        //비밀번호는 `최소 4자 이상이며, 닉네임과 같은 값이 포함된 경우 회원가입에 실패`로 만들기
        if (password.contains(username) || password.length() < 4) {
//            JSONObject obj = new JSONObject();
            obj.append("result", "fail");
            obj.append("msg", "비밀번호는 최소 4자 이상이며, 닉네임과 같은 값이 포함될 수 없습니다.");
            return obj.toString();
        }
        //비밀번호 확인은 비밀번호와 정확하게 일치하기
        if (!password.equals(passwordCheck)) {
//            JSONObject obj = new JSONObject();
            obj.append("result", "fail");
            obj.append("msg", "비밀번호 일치 여부를 확인해주세요.");
            return obj.toString();
        }
        // 회원 email 중복 확인
        Optional<User> foundId = userRepository.findByEmail(email);
        if (foundId.isPresent()) {
//            JSONObject obj = new JSONObject();
            obj.append("result","fail");
            obj.append("msg", "중복된 사용자 email이 존재합니다.");
            return obj.toString();
        }
        // 회원 이름 중복 확인
        Optional<User> foundName = userRepository.findByUsername(username);
        if (foundName.isPresent()) {
//            JSONObject obj = new JSONObject();
            obj.append("result", "fail");
            obj.append("msg", "중복된 사용자 닉네임이 존재합니다.");
            return obj.toString();
        }

//        password = passwordEncoder.encode(password);
//        passwordCheck = passwordEncoder.encode(passwordCheck);
        User user = new User(username, password,passwordCheck, email);
        userRepository.save(user);
//        JSONObject obj = new JSONObject();
        obj.append("result", "success");
        obj.append("msg", "회원 가입 성공하였습니다.");
        return obj.toString();
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////
    //로그인 체크하는곳
    
    public String LoginChk(LoginDto loginDto, HttpServletRequest request) {

        JSONObject obj = new JSONObject();

        //    사용자 로그인 체크
        if (request.getSession(false) != null){       //조건고치기, 비밀번호 암호화 불가능한거 해결 할 방법 찾기
            obj.put("result", "False");
            obj.put("msg", "이미 로그인이 되어 있습니다.");
            return obj.toString();
        }

        String email = loginDto.getEmail();
        String password = loginDto.getPassword();
        boolean exists = userRepository.existsByEmailAndPassword(email, password);
        HttpSession session = request.getSession();

        if (exists){
            User user = userRepository.findByEmail(email).orElseThrow(() -> new NullPointerException("해당 아이디가 존재하지 않습니다."));
            obj.append("result", "True");
            obj.append("msg", "로그인에 성공했습니다.");
            obj.append("email", email);
            obj.append("username", user.getUsername());
            session.setAttribute("loginDto", loginDto); //세션에 값을 넣어줌
            return obj.toString();
        } else{
            obj.append("result", "False");
            obj.append("msg", "닉네임 또는 패스워드를 확인해주세요.");
//            session.invalidate();   //세션 삭제
            return obj.toString();
        }

    }
}


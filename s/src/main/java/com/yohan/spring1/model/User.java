package com.yohan.spring1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.yohan.spring1.dto.SignupRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@NoArgsConstructor
public class User extends Timestamped {
    //id , email , nickname , 시간들
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id //pk값으로 쓰겠다
    @Column(name = "userid")
    private Long id;

    @Column(nullable = false, unique = true)   //이메일
    private String email;

    @Column(nullable = false, unique = true)   //유저이름
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String passwordCheck;

    @JsonBackReference  //순환참조 방지. 자식 클래스   //mappedby => 관계의 주인은 이쪽이 아니다.
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Board> boardList = new ArrayList<>();


    public User(SignupRequestDto signupRequestDto) {
        this.username = signupRequestDto.getUsername();
        this.password = signupRequestDto.getPassword();
        this.passwordCheck = signupRequestDto.getPasswordCheck();
        this.email = signupRequestDto.getEmail();

    }
}
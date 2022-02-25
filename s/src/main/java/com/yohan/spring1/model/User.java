package com.yohan.spring1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.yohan.spring1.dto.SignupRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User extends Timestamped implements UserDetails {
    //id , email , nickname , 시간들
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @JsonBackReference  //순환참조 방지. 자식 클래스   //mappedby => 관계의 주인은 이쪽이 아니다.
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Likes> LikeList = new ArrayList<>();


    public User(SignupRequestDto signupRequestDto) {
        this.username = signupRequestDto.getUsername();
        this.password = signupRequestDto.getPassword();
        this.passwordCheck = signupRequestDto.getPasswordCheck();
        this.email = signupRequestDto.getEmail();
    }

    public User(String username, String password,String passwordCheck, String email) {
        this.username = username;
        this.password = password;
        this.passwordCheck = passwordCheck;
        this.email = email;
    }

    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}